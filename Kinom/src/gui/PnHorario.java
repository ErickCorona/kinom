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
	/**
	 * Obtiene una fecha y apartir de ese dia crea una tabla con los siguientes dias
	 * hasta la siguiente semana
	 * @param fecha
	 */
	public void llenar(Calendar fecha){
		//Si esta vacion removemos todos los paneles
		if(getComponents().length > 0){
			removeAll();
			semana.clear();
			llenar(fecha);//Volvemos a llamar
			return;
		}
		//Si esta vacio lo llenamos
		for(int i=0; i< 7; i++){
			pnDiaHorario pnHorario = new pnDiaHorario(fecha); //Creamos un nuevo Panel por dia con la fecha
			this.add(pnHorario);//Lo agregamos
			semana.add(pnHorario); //Lo agregamos al arreglo 
			fecha.add(Calendar.DAY_OF_YEAR, 1);//Sumanmos la fecha
		}
		
	}
	/**
	 * Llena el panel apartir de la informaccion dada
	 * @param func Arreglo de funciones
	 * @param fecha Fecha inicial
	 */
	public void llenar(ArrayList<Funcion> func, Calendar fecha){
		if(getComponents().length > 0){
			//Si esta lleno removemos todos y volvemos a llamar a la funcion
			removeAll();
			semana.clear();
			llenar(func, fecha);
			return;
		}
		ArrayList<Funcion> funDia ; //FUnciones en un dia determinado
		for(int i=0; i< 7; i++){
			funDia = obtenerFuncDia(func, fecha); //Obtemeos las funciones de un dia 
			pnDiaHorario pnHorario = new pnDiaHorario(fecha);//Creamos el pnDIaHorario con la fecha
			pnHorario.cargarFunciones(funDia);//Cargamos las funciones
			this.add(pnHorario);//Agregamos el panel
			semana.add(pnHorario);//Agremos el panel
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
