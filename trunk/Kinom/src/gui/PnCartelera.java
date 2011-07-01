package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;

import classes.Funcion;

public class PnCartelera extends JPanel  {
	private ArrayList<Funcion> funciones;
	private JPanel pnCartelera;
	private ArrayList<BtnPelicula> botones;
	private JTextPane txtInformacion;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public PnCartelera(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
		int cols = 1;
		cols = 4 ;
		
		
		int rows = 0;
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
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pnCartelera.setLayout(new GridLayout(rows, cols , 5, 5));
		
		txtInformacion = new JTextPane();
		txtInformacion.setEnabled(true);
		txtInformacion.setEditable(false);
		
		GridBagConstraints gbc_txtInformacion = new GridBagConstraints();
		gbc_txtInformacion.fill = GridBagConstraints.BOTH;
		gbc_txtInformacion.gridx = 0;
		gbc_txtInformacion.gridy = 1;
		add(txtInformacion, gbc_txtInformacion);
		
		botones = new ArrayList<BtnPelicula>();
		
		llenarCartelera();
		
		Style style;
		style = txtInformacion.addStyle("24", null);
		StyleConstants.setFontSize(style, 24);
		style = txtInformacion.addStyle("24bold", style);
		StyleConstants.setBold(style, true);
		style = txtInformacion.addStyle("18", null);
		StyleConstants.setFontSize(style, 18);
		style = txtInformacion.addStyle("18bold", style);
		StyleConstants.setBold(style, true);
		style = txtInformacion.addStyle("Red18bold", style);
		StyleConstants.setForeground(style, Color.red);
		style = txtInformacion.addStyle("12", null);
		StyleConstants.setFontSize(style, 12);

		
	}
	public PnCartelera() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{218, 0, 154, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);
		
		JTextPane txtInformacion = new JTextPane();
		txtInformacion.setEditable(false);
		GridBagConstraints gbc_txtInformacion = new GridBagConstraints();
		gbc_txtInformacion.fill = GridBagConstraints.BOTH;
		gbc_txtInformacion.gridx = 0;
		gbc_txtInformacion.gridy = 2;
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
			//peli.getTglbtnPelicula().addComponentListener(this);

		}
	}
	
	
	public ArrayList<BtnPelicula> getBotones() {
		return botones;
	}
	public void setBotones(ArrayList<BtnPelicula> botones) {
		this.botones = botones;
	}
	
	public JTextPane getTxtInformacion() {
		return txtInformacion;
	}
	public void setTxtInformacion(JTextPane txtInformacion) {
		this.txtInformacion = txtInformacion;
	}

	
}
