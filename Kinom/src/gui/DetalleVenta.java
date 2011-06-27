package gui;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class DetalleVenta extends JPanel {
	JLabel lblTitulo;
	JLabel lblNum;
	JTextField txtNum;
	JLabel lblHorario;
	JList lstHoraio;
	JButton btnImprimir;
	JButton btnCancelar;
	

	/**
	 * Create the panel.
	 */
	public DetalleVenta() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		lblTitulo = new JLabel("TICKET");
		lblNum = new JLabel("Numero:");
		txtNum = new JTextField(3);
		lblHorario = new JLabel("Horarios:");
		lstHoraio = new JList();
		DefaultListModel model = new DefaultListModel();
		model.addElement("Prueba");
		lstHoraio.setModel(model);
		
		btnImprimir = new JButton("Imprimir");
		btnCancelar = new JButton("Cancelar");
		JPanel num = new JPanel(new FlowLayout());
		this.add(lblTitulo);
		num.add(lblNum);
		num.add(txtNum);
		this.add(num);
		this.add(lblHorario);
		this.add(lstHoraio);
		this.add(btnImprimir);
		this.add(btnCancelar);
		
	}
	
	public static void main(String args[]){
		JFrame frame = new JFrame("Prueba");
		frame.setContentPane(new DetalleVenta());
		frame.pack();
		frame.setVisible(true);	
	}

}
