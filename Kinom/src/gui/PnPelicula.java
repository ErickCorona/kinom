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

public class PnPelicula extends JPanel {
	private int id;
	private String titulo;
	private ImageIcon imagen;
	JToggleButton tglbtnPelicula;

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
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTituloDeLa = new JLabel("TItulo de la pelicula");
		lblTituloDeLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTituloDeLa = new GridBagConstraints();
		gbc_lblTituloDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloDeLa.gridx = 0;
		gbc_lblTituloDeLa.gridy = 0;
		add(lblTituloDeLa, gbc_lblTituloDeLa);
		
		tglbtnPelicula = new JToggleButton("Pelicula");
		GridBagConstraints gbc_tglbtnPelicula = new GridBagConstraints();
		gbc_tglbtnPelicula.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPelicula.gridx = 0;
		gbc_tglbtnPelicula.gridy = 1;
		add(tglbtnPelicula, gbc_tglbtnPelicula);
		
		this.id = funcion.getPelicula().getId();
		this.titulo = funcion.getPelicula().getNombre();
		this.imagen = funcion.getPelicula().getImagen();
		lblTituloDeLa.setText(this.titulo);
		tglbtnPelicula.setIcon(this.imagen);

	}

	public PnPelicula() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTituloDeLa = new JLabel("TItulo de la pelicula");
		lblTituloDeLa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTituloDeLa = new GridBagConstraints();
		gbc_lblTituloDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloDeLa.gridx = 0;
		gbc_lblTituloDeLa.gridy = 0;
		add(lblTituloDeLa, gbc_lblTituloDeLa);
		
		tglbtnPelicula = new JToggleButton("Pelicula");
		GridBagConstraints gbc_tglbtnPelicula = new GridBagConstraints();
		gbc_tglbtnPelicula.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPelicula.gridx = 0;
		gbc_tglbtnPelicula.gridy = 1;
		add(tglbtnPelicula, gbc_tglbtnPelicula);

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	
	public JToggleButton getTglbtnPelicula() {
		return tglbtnPelicula;
	}
	public void setTglbtnPelicula(JToggleButton tglbtnPelicula) {
		this.tglbtnPelicula = tglbtnPelicula;
	}

}
