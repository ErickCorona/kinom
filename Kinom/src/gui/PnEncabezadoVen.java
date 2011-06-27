package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class PnEncabezadoVen extends JPanel {
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public PnEncabezadoVen() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(panel_1);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblFecha);
		
		JComboBox cmbFecha = new JComboBox();
		cmbFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbFecha.setModel(new DefaultComboBoxModel(new String[] {"Prueba 1", "Prueba 2"}));
		panel_1.add(cmbFecha);

	}

}
