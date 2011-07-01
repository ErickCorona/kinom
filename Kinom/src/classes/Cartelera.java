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
	 * Toma las pel�culas del <i>ArrayList</i> global <i>funciones</i> a proyectarse en una fecha espec�fica en diferentes salas.
	 * @param fecha <i>Calendar</i> que contiene la fecha deseada.
	 * @return <i>ArrayList</i> de <i>Funcion</i> que contiene las diferentes pel�culas.
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
	 * Toma las funciones que ser�n proyectadas en la fecha actual <i>currentDate</i> de una pel�cula en espec�fico en una sala.
	 * @param pel Pel�cula de la que se quieren las funciones.
	 * @param sala Sala en la que est� la pel�cula.
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
					new Sala(rs.getInt(3),rs.getInt("cap_sala"))
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
			if(rs.getInt("2x1_pre")==date.get(Calendar.DAY_OF_WEEK))
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
