package gui;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import classes.Funcion;
import classes.Pelicula;

public class BtnPelicula extends JToggleButton {
	
	private int sala;
	private Pelicula peli;
	
	public BtnPelicula(){
		super();
		
	}
	
	public BtnPelicula(Funcion func){
		super();

		peli = func.getPelicula();
		this.sala = func.getSala().getNumero();
		
		setIcon(this.peli.getImagen());
		setText("");
		
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public Pelicula getPeli() {
		return peli;
	}

	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}

}
