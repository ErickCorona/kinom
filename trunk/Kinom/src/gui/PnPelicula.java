package gui;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Insets;
import java.awt.Font;

public class PnPelicula extends JPanel {

	/**
	 * Create the panel.
	 */
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
		
		JToggleButton tglbtnPelicula = new JToggleButton("Pelicula");
		GridBagConstraints gbc_tglbtnPelicula = new GridBagConstraints();
		gbc_tglbtnPelicula.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPelicula.gridx = 0;
		gbc_tglbtnPelicula.gridy = 1;
		add(tglbtnPelicula, gbc_tglbtnPelicula);

	}

}
