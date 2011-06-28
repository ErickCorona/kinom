package bd;


import java.sql.ResultSet;

class Tester {

	public static void main(String args[]){
		Conexion c = new Conexion("root","pass","kinom");
		ResultSet rs;
		try{
			rs = c.executeQ("SELECT * FROM peliculas");
			System.out.println("Primer registro: " + rs.next() + " : " + rs.getString(2));
			c.close();
		}catch(Exception e){
				e.printStackTrace();
		}
		
	}
}
