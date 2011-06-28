package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import classes.Funcion;
import classes.Pelicula;
import java.awt.Color;

public class PnPelicula extends JPanel{
	
	BtnPelicula tglbtnPelicula;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnPelicula(Funcion funcion) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTituloDeLa = new JLabel("TItulo de la pelicula");
		lblTituloDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTituloDeLa = new GridBagConstraints();
		gbc_lblTituloDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloDeLa.gridx = 0;
		gbc_lblTituloDeLa.gridy = 0;
		add(lblTituloDeLa, gbc_lblTituloDeLa);
		
		JLabel lblSala = new JLabel("Sala: 2");
		lblSala.setForeground(Color.BLACK);
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblSala = new GridBagConstraints();
		gbc_lblSala.insets = new Insets(0, 0, 5, 0);
		gbc_lblSala.gridx = 0;
		gbc_lblSala.gridy = 1;
		add(lblSala, gbc_lblSala);
		
		tglbtnPelicula = new BtnPelicula(funcion);
		GridBagConstraints gbc_tglbtnPelicula = new GridBagConstraints();
		gbc_tglbtnPelicula.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPelicula.gridx = 0;
		gbc_tglbtnPelicula.gridy = 2;
		add(tglbtnPelicula, gbc_tglbtnPelicula);
		
		
		lblTituloDeLa.setText(funcion.getPelicula().getNombre());
		lblSala.setText("Sala: " + funcion.getSala().getNumero());
		

	}

	public PnPelicula() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTituloDeLa = new JLabel("TItulo de la pelicula");
		lblTituloDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblTituloDeLa = new GridBagConstraints();
		gbc_lblTituloDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloDeLa.gridx = 0;
		gbc_lblTituloDeLa.gridy = 0;
		add(lblTituloDeLa, gbc_lblTituloDeLa);
		
		JLabel lblSala = new JLabel("Sala: 2");
		lblSala.setForeground(Color.BLACK);
		lblSala.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblSala = new GridBagConstraints();
		gbc_lblSala.insets = new Insets(0, 0, 5, 0);
		gbc_lblSala.gridx = 0;
		gbc_lblSala.gridy = 1;
		add(lblSala, gbc_lblSala);
		
		tglbtnPelicula = new BtnPelicula();
		GridBagConstraints gbc_tglbtnPelicula = new GridBagConstraints();
		gbc_tglbtnPelicula.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPelicula.gridx = 0;
		gbc_tglbtnPelicula.gridy = 2;
		add(tglbtnPelicula, gbc_tglbtnPelicula);

	}

	public BtnPelicula getTglbtnPelicula() {
		return tglbtnPelicula;
	}

	public void setTglbtnPelicula(BtnPelicula tglbtnPelicula) {
		this.tglbtnPelicula = tglbtnPelicula;
	}
	
	


}
