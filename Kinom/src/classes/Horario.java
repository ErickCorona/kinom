package classes;

import java.util.Date;
import java.util.ArrayList;

public class Horario {

	private int dia;
	private ArrayList<Date> horaIni;
	
	public Horario(int dia, ArrayList<Date> horaIni) {
		this.dia = dia;
		this.horaIni = horaIni;
	}

	public Horario(int dia) {
		this.dia = dia;
	}
	
	public void addHora(Date hora){
		horaIni.add(hora);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public ArrayList<Date> getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(ArrayList<Date> horaIni) {
		this.horaIni = horaIni;
	}
}
