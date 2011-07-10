package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;

import bd.Conexion;

public class Cartelera {

	private ArrayList<Funcion> funciones;
	private Calendar currentDate;
	
	/**
	 * Crea una instancia de Cartelera asignando como fecha actual <i>currentDate</i> la del momento en que se crea. Usa esa fecha para cargar las funciones de la base de datos. 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public Cartelera() throws SQLException, ClassNotFoundException, ParseException{
		currentDate = Calendar.getInstance();
		currentDate.set(Calendar.DATE, currentDate.get(Calendar.DATE)-1);
		loadFunciones(Calendar.getInstance());
	}
	
	/**
	 * Toma las películas del <i>ArrayList</i> global <i>funciones</i> a proyectarse en una fecha específica en diferentes salas.
	 * @param fecha <i>Calendar</i> que contiene la fecha deseada.
	 * @return <i>ArrayList</i> de <i>Funcion</i> que contiene las diferentes películas.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public ArrayList<Funcion> getPeliculas(Calendar fecha) throws SQLException, ClassNotFoundException, ParseException{
		loadFunciones(fecha);
		ArrayList<Funcion> p = new ArrayList<Funcion>();
		boolean entro = false;
		boolean isToday = fecha.get(Calendar.DAY_OF_YEAR)==Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		for(Funcion f:funciones){
			entro = false;
			for(Funcion faux:p){
				if((faux.getPelicula().getId()!=f.getPelicula().getId() || faux.getSala().getNumero()!=f.getSala().getNumero())
						&& (!isToday || f.getHorario().getTimeInMillis()>=fecha.getTimeInMillis()-7200000)){
					entro=false;
				}else{
					entro = true;
					break;
				}
			}
			if(!entro && (!isToday || f.getHorario().getTimeInMillis()>=fecha.getTimeInMillis()-7200000))
				p.add(f);
			System.out.println(p.size());
		}
		return p;
	}
	
	/**
	 * Regresa todas las peliculas en la base de datos que no estan eliminadas
	 * @param fecha <i>Calendar</i> que contiene la fecha deseada.
	 * @return <i>ArrayList</i> de <i>Peliculas</i> que contiene las diferentes películas.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public ArrayList<Pelicula> getPeliculas() throws SQLException, ClassNotFoundException, ParseException{
		ArrayList<Pelicula> p = new ArrayList<Pelicula>();
		Conexion conn = new Conexion();
		ResultSet rs = conn.select("Peliculas");
		Pelicula pel;
		while(rs.next()){
			byte blob[] = rs.getBytes("img_pel");
			pel = new Pelicula(rs.getInt("id_pel"), rs.getString("nom_pel"), new ImageIcon(blob), rs.getString("clas_pel"), rs.getInt("dur_pel"), rs.getString("sin_pel"), rs.getString("idm_pel"));
			p.add(pel);
		}
		conn.close();
		return p;
	}
	
	/**
	 * Toma las funciones que serán proyectadas en la fecha actual <i>currentDate</i> de una película en específico en una sala.
	 * @param pel Película de la que se quieren las funciones.
	 * @param sala Sala en la que está la película.
	 * @return <i>ArrayList</i> de <i>Funcion</i> que contiene las diferentes funciones.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public ArrayList<Funcion> getFunciones(Pelicula pel, int sala) throws SQLException, ClassNotFoundException, ParseException{
		ArrayList<Funcion> p = new ArrayList<Funcion>();
		boolean isToday = currentDate.get(Calendar.DAY_OF_YEAR)==Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		for(Funcion f:funciones){
			if(f.getPelicula().getId()==pel.getId() && f.getSala().getNumero()==sala
				&& (!isToday || f.getHorario().getTimeInMillis()>=currentDate.getTimeInMillis()-7200000))
				p.add(f);
		}
		return p;
	}
	
	public static ArrayList<Funcion> getFuncionDesdeHoy(Pelicula pel, int sala) throws SQLException, ClassNotFoundException, ParseException{
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		Conexion conn = new Conexion();
		String stm = "SELECT id_fun,hro_fun FROM funciones WHERE id_pel=" + pel.getId() + " AND id_sala=" + sala + " AND strftime('%s',hro_fun) >= strftime('%s',date('now','localtime')) ORDER BY hro_fun";
		System.out.println(stm);
		//String stm = "SELECT * FROM funciones";
		ResultSet rs = conn.executeQ(stm);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		while(rs.next()){
			Funcion func = new Funcion();
			func.setPelicula(pel);
			func.setSala(new Sala(sala, 0));
			Calendar fecha = Calendar.getInstance();
			fecha.setTime(format.parse(rs.getString("hro_fun")));
			func.setHorario(fecha);
			func.setId(rs.getInt("id_fun"));
			
			funciones.add(func);
		}
		
		conn.close();
		return funciones;
		
	}
	
	/**
	 * Carga en el <i>ArrayList</i> global <i>funciones</i> desde la base de datos las funciones de una fecha especificada.
	 * @param date Fecha a consultar.
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public void loadFunciones(Calendar date) throws SQLException, ClassNotFoundException, ParseException{
		if(currentDate.get(Calendar.DAY_OF_YEAR)==date.get(Calendar.DAY_OF_YEAR))
			return;
		currentDate = date;
		funciones = new ArrayList<Funcion>();
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		
		Conexion con = new Conexion();
		ResultSet rs = con.executeQ("SELECT * FROM funciones,peliculas,salas WHERE funciones.id_pel=peliculas.id_pel AND funciones.id_sala=salas.id_sala AND date(hro_fun) ='" + format2.format(date.getTime()) + "' ORDER BY hro_fun");
		
		while(rs.next()){
			Calendar fecha = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			fecha.setTime(format.parse(rs.getString("hro_fun")));
			
			//System.out.println(fecha.getTime());
			byte blob[] = rs.getBytes("img_pel");
			funciones.add(
				new Funcion(
					new Pelicula(rs.getInt(2), rs.getString("nom_pel"), new ImageIcon(blob), rs.getString("clas_pel"), rs.getInt("dur_pel"), rs.getString("sin_pel"), rs.getString("idm_pel")),
					fecha,
					new Sala(rs.getInt(3),rs.getInt("cap_sala")),
					rs.getInt("ocu_fun"),
					rs.getInt("id_fun")
				)
			);
		}

		con.close();
	}
	
	public static double getPrecio(){
		Conexion con = new Conexion();
		double pre = 0;
		try {
			ResultSet rs = con.select("precios");
			pre = rs.getDouble("base_pre");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre;
	}
	
	public static boolean is2x1(Calendar date){
		Conexion con = new Conexion();
		boolean pre = false;
		try {
			ResultSet rs = con.select("precios");
			if(rs.getInt("dosx1_pre")==date.get(Calendar.DAY_OF_WEEK))
				pre = true;
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pre;
	}

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
}
