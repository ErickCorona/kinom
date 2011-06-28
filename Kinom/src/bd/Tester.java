package bd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

class Tester {

	public static void main(String args[]){
		/*Conexion c = new Conexion("root","pass","kinom");
		ResultSet rs;
		try{
			rs = c.executeQ("SELECT * FROM peliculas");
			System.out.println("Primer registro: " + rs.next() + " : " + rs.getString(2));
			c.close();
		}catch(Exception e){
				e.printStackTrace();
		}*/
		
		/*Calendar hoy = Calendar.getInstance();
		hoy.set(2012, 11, 21, 11, 59, 59);
		System.out.println("Dia: " + hoy.getTime());*/
		
		classes.Cartelera cart = new classes.Cartelera();
		try {
			cart.loadFunciones();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
