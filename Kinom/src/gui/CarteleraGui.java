package gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import classes.Funcion;
import classes.Pelicula;
import classes.btnFuncion;

public class CarteleraGui extends JPanel {
	private static final long serialVersionUID = 1L;
	private Funcion funciones[];
	
	/**
	 * Recive el arreglo de funciones que va a ser desplegadas
	 * @param funciones
	 */
	public CarteleraGui(Funcion[] funciones) {
		this.funciones = funciones;
		this.setLayout(new GridLayout((int)Math.ceil(funciones.length/4), 4, 20, 20)); //Asinga un layout de n x 4
		llenarCartelear();
	}
	
	/**
	 * Crea los botones con base en el arreglo de funciones.
	 */
	private void llenarCartelear(){
		ButtonGroup group = new ButtonGroup();
		for(Funcion func : funciones){
			btnFuncion n_f = new btnFuncion(func);
			group.add(n_f.getBtnPeli());
			this.add(n_f);
		}	
	}
	
	//Depuracion y pruebas 
	
	protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = CarteleraGui.class.getResource(path);
	    return new ImageIcon(imgURL);
	}
	
	public static void main(String args[]){
		Funcion funciones[] = new Funcion[12];
		for(int i=0; i<funciones.length; i++){

			ImageIcon leftButtonIcon = createImageIcon("cars2.jpeg");
			
			funciones[i] = new Funcion(new Pelicula("Prueba Pelicula"));
			funciones[i].getPelicula().setImagen(leftButtonIcon);
		}
		JFrame frame = new JFrame("Prueba");
		frame.setContentPane(new CarteleraGui(funciones));
		frame.pack();
		frame.setVisible(true);	
	}
	

}
