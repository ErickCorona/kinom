package gui;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyleContext.SmallAttributeSet;

import classes.Funcion;
import classes.Pelicula;
import classes.Sala;

public class PnHorario extends JPanel {
	Sala sala;
	Pelicula pel;
	ArrayList<pnDiaHorario> semana;

	/**
	 * Create the panel.
	 */
	public PnHorario() {
		semana = new ArrayList<pnDiaHorario>();
		setBorder(new TitledBorder(null, "Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
	
	public void llenar(Calendar fecha){
		if(getComponents().length > 0){
			removeAll();
			llenar(fecha);
			return;
		}
		for(int i=0; i< 7; i++){
			pnDiaHorario pnHorario = new pnDiaHorario(fecha);
			this.add(pnHorario);
			semana.add(pnHorario);
			fecha.add(Calendar.DAY_OF_YEAR, 1);
		}
		
	}
	
	public void llenar(ArrayList<Funcion> func, Calendar fecha){
		if(getComponents().length > 0){
			removeAll();
			llenar(func, fecha);
			return;
		}
		ArrayList<Funcion> funDia ;
		for(int i=0; i< 7; i++){
			funDia = obtenerFuncDia(func, fecha);
			pnDiaHorario pnHorario = new pnDiaHorario(fecha);
			pnHorario.cargarFunciones(funDia);
			this.add(pnHorario);
			semana.add(pnHorario);
			fecha.add(Calendar.DAY_OF_YEAR, 1);
		}
	}
	
	public ArrayList<Funcion> obtenerFuncDia(ArrayList<Funcion> funciones, Calendar fecha){
		//TODO Lucky Jason Race y Ximena Sari;aga
		ArrayList<Funcion> funDia = new ArrayList<Funcion>();
		for (Funcion funcion : funciones) {
			if(funcion.getHorario().get(Calendar.DAY_OF_YEAR)==fecha.get(Calendar.DAY_OF_YEAR)){
				funDia.add(funcion);
			}
		}
		return funDia;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPel() {
		return pel;
	}

	public void setPel(Pelicula pel) {
		this.pel = pel;
	}

	public void guardar() {
		for (pnDiaHorario pnDia : semana) {
			pnDia.guardarFunciones(this.pel,this.sala);
		}
		
		
	}

}
