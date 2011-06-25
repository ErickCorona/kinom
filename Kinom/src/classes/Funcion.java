package classes;

public class Funcion {

	private Pelicula pelicula;
	private Horario horarios[];
	private Sala sala;
	
	public Funcion(Pelicula pelicula, Horario[] horarios, Sala sala) {
		this.pelicula = pelicula;
		this.horarios = horarios;
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

	public Horario[] getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario[] horarios) {
		this.horarios = horarios;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
