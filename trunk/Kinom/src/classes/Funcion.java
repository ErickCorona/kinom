package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Funcion {

	private Pelicula pelicula;
	private Calendar horario;
	private Sala sala;
	private int ocupados;
	
	public Funcion(Pelicula pelicula, Calendar horario, Sala sala) {
		this.pelicula = pelicula;
		this.horario = horario;
		this.sala = sala;
	}

	public Funcion(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public String consultarFuncion(){
		String s = "";
		s+= pelicula.getNombre() + pelicula.getIdioma() + "\n";
		s+= "Sala: " + sala.getNumero() + "\n\n";
		s+= "Clas. " + pelicula.getClasificacion() + "\n";
		s+= "Sinopsis: \n" + pelicula.getSinopsis();
		return s;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public int getOcupados() {
		return ocupados;
	}

	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		String horario = format.format(this.getHorario().getTime());
		return horario;
		//return super.toString();
	}
	
}
