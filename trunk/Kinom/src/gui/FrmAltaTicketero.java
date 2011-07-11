package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import utils.ImageUtils;

import bd.Conexion;

import classes.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Component;
import javax.swing.Box;


public class FrmAltaTicketero extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JPasswordField txtRePass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAltaTicketero frame = new FrmAltaTicketero();
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
	public FrmAltaTicketero() {
		setResizable(false);
		setTitle("Alta Ticketero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAltaTicketero = new JLabel("Alta Ticketero");
		lblAltaTicketero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblAltaTicketero);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][117.00,fill][][][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("");
		ImageUtils utils = new ImageUtils();
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut, "cell 0 0");
		lblNewLabel.setIcon(utils.createImageIcon("../imagen/ticket128.png", "inicio"));
		panel_1.add(lblNewLabel, "cell 1 0 1 4");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1, "cell 2 0");
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNombre, "cell 3 0,alignx trailing");
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtNombre, "cell 4 0,growx");
		txtNombre.setColumns(10);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblUsuario, "cell 3 1,alignx trailing");
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtUsuario, "cell 4 1,growx");
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblContrasea, "cell 3 2,alignx trailing");
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtPass, "cell 4 2,growx");
		
		JLabel lblRecontrasea = new JLabel("Repetir Contrase\u00F1a:");
		lblRecontrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblRecontrasea, "cell 3 3,alignx trailing");
		
		txtRePass = new JPasswordField();
		txtRePass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtRePass, "cell 4 3,growx");
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String usuario = txtUsuario.getText();
				String pass = new String(txtPass.getPassword());
				String repass = new String(txtRePass.getPassword());
				
				if(!pass.equals(repass)){
					JOptionPane.showMessageDialog(FrmAltaTicketero.this, "Las contraseñas no coinciden");
					return;
				}else if(nombre.equals("") || usuario.equals("")||pass.equals("")){
					JOptionPane.showMessageDialog(FrmAltaTicketero.this, "No puedes dejar campos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}else if(Usuario.existeUsr(usuario)){
					JOptionPane.showMessageDialog(FrmAltaTicketero.this, "El nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				Conexion conn  = new Conexion();
				try {
					conn.insert("usuarios", "null,'"+nombre+"','"+usuario+"','"+pass+"',1");
					JOptionPane.showMessageDialog(FrmAltaTicketero.this, "Agregado correctamente");
					borrarCampos();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(FrmAltaTicketero.this, "Verifique los campos");
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		panel_2.add(btnNewButton_1);
	}

	protected void borrarCampos() {
		txtNombre.setText("");
		txtPass.setText("");
		txtRePass.setText("");
		txtUsuario.setText("");
		
	}

}
