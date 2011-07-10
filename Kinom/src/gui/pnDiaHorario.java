package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import classes.Funcion;
import classes.Pelicula;
import classes.Sala;

public class pnDiaHorario extends JPanel {
	private String dia;
	private Calendar fecha;
	public JButton btnAgregar;
	private int numBotones; //Empezando por cero
	public HashMap<Integer,JTextHora> horario;
	private JLabel label;
	

	/**
	 * Create the panel.
	 */
	public pnDiaHorario(Calendar fecha) {
		numBotones = 0; //Empieza en cero
		horario = new HashMap<Integer, JTextHora>();
		SimpleDateFormat dfDia = new SimpleDateFormat("EEEEE");
		SimpleDateFormat dfFecha = new SimpleDateFormat("dd/MMM/yy");
		
		setLayout(new MigLayout("", "[][][][]", "[][]"));
		
		JLabel lblDia = new JLabel(dfDia.format(fecha.getTime()));//Obtemeos el tiempo itroducido
		lblDia.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblDia, "cell 0 0,alignx center");
		
		//=====Boton de agregar====
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextHora nHora = new JTextHora(numBotones);
				horario.put(numBotones, nHora);
				add(nHora, "cell 1 0 1 2,growx"); //Se agrega el boton
				/*
				btnAgregar = new JButton("Agregar");
				add(btnAgregar,"cell "+(numBotones+2)+  " 0 1 2");
				*/
				numBotones++;
				
				validate();
			
				//textField.setColumns(10);
			}
		});
		add(btnAgregar, "cell 2 0 1 2");
		//====Boton de agregar====
		
		//Boton de eliminar//
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numBotones>0){
					JTextHora nHora = horario.get(numBotones-1);
					if(nHora.getText().equals("")){
					horario.remove(numBotones-1);
					remove(nHora);
					numBotones--;
					validate();
					}else{
						JOptionPane.showMessageDialog(pnDiaHorario.this, "No se puede eliminar, borre el campo");
					}
				}
				
			}
		});
		add(btnEliminar, "cell 3 0 1 2");
		
		
		
		//=====Boton de eliminar//
		this.fecha = fecha;
		label = new JLabel(dfFecha.format(this.fecha.getTime()));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label, "cell 0 1,alignx center");
		

	}
	/**
	 * Carga las funciones apartir de un arreglo de funciones
	 * @param func
	 */
	public void cargarFunciones(ArrayList<Funcion> func){
		for (Funcion funcion : func) {
			JTextHora nHora = new JTextHora(numBotones);
			nHora.setFuncion(funcion);
			horario.put(numBotones, nHora);
			add(nHora, "cell 1 0 1 2,growx"); //Se agrega el boton
			/*
			btnAgregar = new JButton("Agregar");
			add(btnAgregar,"cell "+(numBotones+2)+  " 0 1 2");
			*/
			numBotones++;
			
			validate();
		
			
		}
		
	}
	
	public void guardarFunciones(Pelicula pel, Sala sal) throws ParseException{
		Set<Integer> keys = this.horario.keySet(); 
		for (Integer k : keys) {
			JTextHora hraFuncion = horario.get(k);
			if(hraFuncion.getText().equals("")){
				continue;
			}else if(!hraFuncion.cambio()){
				continue;
			}
			
			SimpleDateFormat validacion = new SimpleDateFormat("HH:mm");
		
			
			//System.out.println(label.getText());
			//System.out.println("Horario"+hraFuncion.getText());
			SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yy");
			SimpleDateFormat dfFinal = new SimpleDateFormat("yyyy-MM-dd");
			
				Date val = validacion.parse(hraFuncion.getText());
				
				Date fecha = df.parse(label.getText());
				
				String fechaFinal = dfFinal.format(fecha);
				hraFuncion.guardar(pel,sal,fechaFinal);
		
		}
	}
	

	public JLabel getLabel() {
		return label;
	}
}
