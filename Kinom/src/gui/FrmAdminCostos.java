package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import bd.Conexion;

import utils.ImageUtils;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAdminCostos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrecioBase;
	private JComboBox cmb2x1;
	private JComboBox cmbDesEstudiantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminCostos frame = new FrmAdminCostos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAdminCostos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblModificarPrecios = new JLabel("Modificar Precios");
		lblModificarPrecios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblModificarPrecios);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[153.00][][grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageUtils().createImageIcon("../imagen/money.png", "Cobro"));
		panel_1.add(lblNewLabel_1, "cell 0 0 1 3,alignx center,aligny center");
		
		JLabel lblPrecioBase = new JLabel("Precio Base:");
		lblPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblPrecioBase, "cell 1 0,alignx trailing");
		
		txtPrecioBase = new JTextField();
		txtPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtPrecioBase, "cell 2 0,growx");
		txtPrecioBase.setColumns(10);
		
		JLabel lblDiax = new JLabel("Dia 2x1:");
		lblDiax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblDiax, "cell 1 1,alignx trailing");
		
		cmb2x1 = new JComboBox();
		cmb2x1.setModel(new DefaultComboBoxModel(new String[] {"Domingo", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"}));
		cmb2x1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(cmb2x1, "cell 2 1,growx");
		
		JLabel lblNewLabel = new JLabel("Descuento estudiantes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel, "cell 1 2,alignx trailing");
		
		cmbDesEstudiantes = new JComboBox();
		cmbDesEstudiantes.setModel(new DefaultComboBoxModel(new String[] {"Domingo", "Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"}));
		cmbDesEstudiantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(cmbDesEstudiantes, "cell 2 2,growx");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					float precioBase = Float.parseFloat(txtPrecioBase.getText());
					int dosx1 = cmb2x1.getSelectedIndex() + 1;
					int dest = cmbDesEstudiantes.getSelectedIndex() + 1;
					
					Conexion conn = new Conexion();
					conn.update("precios", "dosx1_pre = "+dosx1+", base_pre = "+precioBase+",dest_pre = "+dest, "id_pre = 1");
					JOptionPane.showMessageDialog(FrmAdminCostos.this, "Precios cambiados correctamente");
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(FrmAdminCostos.this,"Precio base invalido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_2.add(btnCancelar);
		llenar();
	}
	
	public void llenar(){
		Conexion conn = new Conexion();
		try {
			ResultSet rs = conn.select("precios");
			if(rs.next()){
				txtPrecioBase.setText(rs.getString("base_pre"));
				cmb2x1.setSelectedIndex(rs.getInt("dosx1_pre")-1);
				cmbDesEstudiantes.setSelectedIndex(rs.getInt("dest_pre") - 1);
				
				
				
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
