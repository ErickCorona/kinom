package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import bd.Conexion;

public class testConn {
	public static void main(String args[]){
		Conexion conn = new Conexion();
		/*String stm = "SELECT DISTINCT " +
				"peliculas.id_pel as id_pel,peliculas.nom_pel as nom_pel " +
				"FROM peliculas,funciones,salas " + 
				"WHERE funciones.id_sala = salas.id_sala " +
				"AND peliculas.id_pel = funciones.id_pel " +
				"AND date(funciones.hro_fun) = date('now', 'localtime') " +
				"AND salas.id_sala = 2" ;//+ id_pel;*/
		String stm = "SELECT peliculas.nom_pel,COUNT(ventas.id_ven) as venta,SUM(ventas.prec_ven) as total FROM  ventas,funciones,peliculas  WHERE  ventas.id_fun = funciones.id_fun  AND funciones.id_pel = peliculas.id_pel  AND date(funciones.hro_fun)=date('now','localtime')  AND funciones.id_pel = 1 AND funciones.id_sala = 3";
		//String stm = "SELECT DISTINCT peliculas.id_pel as id_pel,peliculas.nom_pel as nom_pel FROM peliculas LEFT JOIN funciones LEFT JOIN salas WHERE funciones.id_sala = salas.id_sala AND peliculas.id_pel = funciones.id_pel AND date(funciones.hro_fun) = date('now', 'localtime') AND salas.id_sala = 2";
		System.out.println(stm);
		ResultSet rs ;
		try {
			rs = conn.executeQ(stm);
					while(rs.next()){
				System.out.println("Pelicula:"+rs.getString("nom_pel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
