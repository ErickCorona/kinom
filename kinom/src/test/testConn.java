package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Conexion;
import classes.Funcion;

public class testConn {
	public static void main(String args[]){
		ArrayList<Funcion> funciones = new ArrayList<Funcion>();
		int sala = 1;
		int pel = 1;
		Conexion conn = new Conexion();
		String stm = "SELECT * FROM funciones,peliculas,salas WHERE funciones.id_pel=peliculas.id_pel AND funciones.id_sala=salas.id_sala AND salas.id_sala = "+sala+" AND peliculas.id_pel = "+pel+" AND strftime('%s',funciones.hro_fun) > strftime('%s',date('now','localtime'))";
		//String stm = "SELECT * FROM funciones";
		System.out.println(stm);
		ResultSet rs;
		try {
			rs = conn.executeQ(stm);
			while(rs.next()){
				System.out.println("id:" + rs.getString(1));
				System.out.println(""+rs.getString(3));
				System.out.println(""+rs.getString(4));
				System.out.println(""+rs.getString(5));
				System.out.println(""+rs.getString(6));
				System.out.println(""+rs.getString(7));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
