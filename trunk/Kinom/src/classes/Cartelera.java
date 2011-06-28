package classes;

import gui.BtnPelicula;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.ImageIcon;

import bd.Conexion;

public class Cartelera {

	private ArrayList<Funcion> funciones;
	private Calendar currentDate;
	
	public Cartelera() throws SQLException, ClassNotFoundException, ParseException{
		currentDate = Calendar.getInstance();
		currentDate.set(Calendar.DATE, currentDate.get(Calendar.DATE)-1);
		loadFunciones(Calendar.getInstance());
	}

	public Cartelera(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	public ArrayList<Funcion> getPeliculas(Calendar fecha) throws SQLException, ClassNotFoundException, ParseException{
		loadFunciones(fecha);
		ArrayList<Funcion> p = new ArrayList<Funcion>();
		boolean entro = false;
		boolean isToday = fecha.get(Calendar.DAY_OF_YEAR)==Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		for(Funcion f:funciones){
			entro = false;
			for(Funcion faux:p){
				entro = true;
				if((faux.getPelicula().getId()!=f.getPelicula().getId() || faux.getSala()!=f.getSala())
						&& (!isToday || f.getHorario().getTimeInMillis()>=fecha.getTimeInMillis()-7200000)){
					p.add(f);
					break;
				}
			}
			if(!entro)
				p.add(f);
		}
		return p;
	}
	
	public ArrayList<Funcion> getFunciones(Pelicula pel) throws SQLException, ClassNotFoundException, ParseException{
		Calendar fecha = currentDate;
		loadFunciones(fecha);
		ArrayList<Funcion> p = new ArrayList<Funcion>();
		boolean isToday = fecha.get(Calendar.DAY_OF_YEAR)==Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		for(Funcion f:funciones){
			if(f.getPelicula().equals(pel) 
				&& (!isToday || f.getHorario().getTimeInMillis()>=fecha.getTimeInMillis()-7200000))
				p.add(f);
		}
		return p;
	}
	
	public void loadFunciones(Calendar date) throws SQLException, ClassNotFoundException, ParseException{
		if(currentDate.get(Calendar.DAY_OF_YEAR)==date.get(Calendar.DAY_OF_YEAR))
			return;
		currentDate = date;
		funciones = new ArrayList<Funcion>();
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		
		Conexion con = new Conexion();
		ResultSet rs = con.executeQ("SELECT * FROM funciones,peliculas,salas WHERE funciones.id_pel=peliculas.id_pel AND funciones.id_sala=salas.id_sala AND date(hro_fun) ='" + format2.format(date.getTime()) + "'");
		
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

	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
}
