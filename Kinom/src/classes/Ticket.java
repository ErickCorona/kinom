package classes;

import java.util.Date;

public class Ticket {

	public static final int NORMAL = 0;
	public static final int CORTESIA = 1;
	
	private Funcion funcion;
	private double precio;
	private int tipo;
	private String descripcion;
	private Usuario ticketero;
	
	public Ticket(Funcion funcion) {
		this.funcion = funcion;
		this.tipo = NORMAL;
	}

	public Ticket(Funcion funcion, double precio, Usuario ticketero) {
		this.funcion = funcion;
		this.precio = precio;
		this.ticketero = ticketero;
		this.tipo = NORMAL;
	}
	
	public void imprimir(){
		
	}

	public Funcion getFuncion() {
		return funcion;
	}
	
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void hacerCortesia(String descripcion){
		this.descripcion = descripcion;
		this.tipo = CORTESIA;
	}
	
	public void cancelarCortesia(){
		this.descripcion = "";
		this.tipo = NORMAL;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Usuario getTicketero() {
		return ticketero;
	}
	
	public void setTicketero(Usuario ticketero) {
		this.ticketero = ticketero;
	}
	
}
