package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bd.Conexion;

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
	
	public static ArrayList<Sala> getSalas() throws SQLException, ClassNotFoundException{
		ArrayList<Sala> s = new ArrayList<Sala>();
		Conexion conn = new Conexion();
		ResultSet rs = conn.select("salas");
		while(rs.next()){
			Sala sala = new Sala(rs.getInt("id_sala"),rs.getInt("cap_sala"));
			s.add(sala);
		}
		return s;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.numero;
	}
}
