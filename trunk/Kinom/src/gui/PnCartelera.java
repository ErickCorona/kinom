package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import classes.Funcion;
import classes.Pelicula;

import java.awt.GridLayout;
import java.awt.color.CMMException;

public class PnCartelera extends JPanel {
	private ArrayList<Funcion> funciones;
	private JPanel pnCartelera;
	private ArrayList<BtnPelicula> botones;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public PnCartelera(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
		int cols = 4;
		int rows = (int) Math.ceil(funciones.size() / cols);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{218, 154, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		pnCartelera = new JPanel();
		scrollPane.setViewportView(pnCartelera);
		pnCartelera.setLayout(new GridLayout(rows, cols , 10, 10));
		
		JTextPane txtInformacion = new JTextPane();
		GridBagConstraints gbc_txtInformacion = new GridBagConstraints();
		gbc_txtInformacion.fill = GridBagConstraints.BOTH;
		gbc_txtInformacion.gridx = 0;
		gbc_txtInformacion.gridy = 1;
		add(txtInformacion, gbc_txtInformacion);
		
		
		
		llenarCartelera();

	}
	public PnCartelera() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{218, 154, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		pnCartelera = new JPanel();
		scrollPane.setViewportView(pnCartelera);
		pnCartelera.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextPane txtInformacion = new JTextPane();
		GridBagConstraints gbc_txtInformacion = new GridBagConstraints();
		gbc_txtInformacion.fill = GridBagConstraints.BOTH;
		gbc_txtInformacion.gridx = 0;
		gbc_txtInformacion.gridy = 1;
		add(txtInformacion, gbc_txtInformacion);
		
		

	}
	
	private void llenarCartelera(){
		ButtonGroup group = new ButtonGroup();
		for (Funcion func : this.funciones) {
			System.out.println("hola");
			PnPelicula peli = new PnPelicula(func);
			pnCartelera.add(peli);
			group.add(peli.getTglbtnPelicula());
			botones.add(peli.getTglbtnPelicula());

		}
	}
	public ArrayList<BtnPelicula> getBotones() {
		return botones;
	}
	public void setBotones(ArrayList<BtnPelicula> botones) {
		this.botones = botones;
	}


}
