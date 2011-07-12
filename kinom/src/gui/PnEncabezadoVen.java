package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnEncabezadoVen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	JComboBox cmbFecha;
	

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
		txtNombre.setEditable(false);
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
		cmbFecha = new JComboBox();
		cmbFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbFecha.setModel(new DefaultComboBoxModel(new String[] {"Prueba 1", "Prueba 2"}));
		panel_1.add(cmbFecha);
		
		cmbFecha.setActionCommand("cmbFecha");

	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JComboBox getCmbFecha() {
		return cmbFecha;
	}


	public void setCmbFecha(JComboBox cmbFecha) {
		this.cmbFecha = cmbFecha;
	}
	
	public void setModelFecha(DefaultComboBoxModel model){
		this.cmbFecha.setModel(model);
	}

}
