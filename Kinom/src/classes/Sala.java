package classes;

public class Sala {

	private int numero;
	private int capacidad;
	
	public Sala(){
	}
	
	public Sala(int numero, int capacidad) {
		super();
		this.numero = numero;
		this.capacidad = capacidad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
