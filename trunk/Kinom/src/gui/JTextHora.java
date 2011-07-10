package gui;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;

import bd.Conexion;

import classes.Funcion;
import classes.Pelicula;
import classes.Sala;

public class JTextHora extends JTextField {
	private static final long serialVersionUID = 1L;
	int id;
	Funcion funcion;
	//String dia;
	
	
	public Funcion getFuncion() {
		return funcion;
	}


	public void setFuncion(Funcion funcion) {
		setText(funcion.getHorarString());
		this.funcion = funcion;
	}


	public JTextHora(int id){
		super();
		setColumns("00:00".length());
		funcion = null;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void guardar(Pelicula pel, Sala sala, String fecha) throws ParseException {
		Conexion conn = new Conexion();
		if(funcion == null){
			//No existe la funcion se guarda en la base de datos
			
			try {
				/*SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yy");
				java.util.Date fechaFinal =  format.parse(fecha);
				*/
				String fechaHora = fecha +" "+this.getText()+":00" ;
				String valores = "null,"+pel.getId()+","+sala.getNumero()+",'"+fechaHora+"',0,0";
				conn.insert("funciones", valores);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(getText().length() > 0){
				//Modificar funcion
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String fechaHora = fecha +" "+this.getText()+":00" ;
				try {
					conn.update("funciones", "hro_fun = '"+fechaHora+"'", "id_fun = "+funcion.getId());
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else{
				//Borrar el horario
				try {
					conn.delete("funciones", "id_fun = '"+funcion.getId()+"'");
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
