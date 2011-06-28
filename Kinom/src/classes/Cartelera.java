package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import bd.Conexion;

public class Cartelera {

	private ArrayList<Funcion> funciones;
	
	public Cartelera(){
		
	}

	public Cartelera(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	public ArrayList<Pelicula> getPeliculas(Calendar fecha){
		ArrayList<Pelicula> p = new ArrayList<Pelicula>();
		for(int i=0;i<funciones.size();i++){
			if(funciones.get(i).getHorario().get(Calendar.DATE)==fecha.get(Calendar.DATE))
				p.add(funciones.get(i).getPelicula());
		}
		return p;
	}
	
	public ArrayList<Funcion> getFunciones(Pelicula pel, Calendar fecha){
		ArrayList<Funcion> f = new ArrayList<Funcion>();
		for(int i=0;i<funciones.size();i++){
			if(funciones.get(i).getPelicula().equals(pel)
					&& funciones.get(i).getHorario().get(Calendar.DATE)==fecha.get(Calendar.DATE))
				f.add(funciones.get(i));
		}
		return f;
	}
	
	public void loadFunciones() throws SQLException, ClassNotFoundException{
		funciones = new ArrayList<Funcion>();
		Calendar fecha = Calendar.getInstance();
		
		Conexion con = new Conexion();
		ResultSet rs = con.executeQ("SELECT * FROM funciones,peliculas,salas WHERE funciones.id_pel=peliculas.id_pel AND funciones.id_sala=salas.id_sala");
		
		while(rs.next()){
			fecha.set(2011, 6, 27, 23, 57, 58);
			Blob blob = rs.getBlob("img_pel");
			funciones.add(
				new Funcion(
					new Pelicula(Integer.parseInt(rs.getString(2)), rs.getString("nom_pel"), new ImageIcon(blob.getBytes(1L, (int)blob.length())), rs.getString("clas_pel"), Integer.parseInt(rs.getString("dur_pel")), rs.getString("sin_pel"), rs.getString("idm_pel")),
					fecha,
					new Sala(Integer.parseInt(rs.getString(3)),Integer.parseInt(rs.getString("cap_sala")))
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
