package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class Funcion {

	private Pelicula pelicula;
	private Calendar horario;
	private Sala sala;
	private int ocupados;
	private int id;
	
	public Funcion(){
		
	}
	
	public Funcion(Pelicula pelicula, Calendar horario, Sala sala, int ocupados, int id) {
		this.pelicula = pelicula;
		this.horario = horario;
		this.sala = sala;
		this.ocupados = ocupados;
		this.id = id;
	}

	public Funcion(Pelicula pelicula) {
		this.pelicula = pelicula;
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
	
	public int getLibres() {
		return sala.getCapacidad()-ocupados;
	}

	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
		String horario = format.format(this.getHorario().getTime());
		return horario+"  Disp: "+ (getLibres());
		//return super.toString();
	}
	
	public String getHorarString(){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horario = format.format(this.getHorario().getTime());
		return horario;
	}
	
}
