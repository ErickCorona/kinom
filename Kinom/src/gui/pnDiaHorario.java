package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnDiaHorario extends JPanel {
	private String dia;
	private Calendar fecha;
	public JButton btnAgregar;
	private int numBotones; //Empezando por cero
	public HashMap<Integer,JTextHora> horario;
	

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
				//Quitamos el boton
				//remove(btnAgregar);
				 //new JTextHora(1);
				//String id = "btn"+numBotones;
				String cont = "cell " + (numBotones+1) + " 0 1 2,growx";
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
					horario.remove(numBotones-1);
					remove(nHora);
					numBotones--;
					validate();
				}
				
			}
		});
		add(btnEliminar, "cell 3 0 1 2");
		
		
		
		//=====Boton de eliminar//
		
		JLabel label = new JLabel(dfFecha.format(fecha.getTime()));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(label, "cell 0 1,alignx center");
		

	}
	

}
