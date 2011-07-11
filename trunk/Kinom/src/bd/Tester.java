package bd;


import java.io.File;

class Tester {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		Conexion c = new Conexion();
		try{
			for(int i=0;i<10;i++){
				c.GuardaPelicula(new File("pelicula"+(i+1)+".jpg"), "Película " + (i+1), "B", "120", "Película No. " + (i+1), "Español");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
