package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.Conexion;
import classes.Usuario;

public class IniciarSesion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPass;
	private Usuario user;
	private boolean logged;
	private JButton btnAceptar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread t = new Thread(){
						IniciarSesion frame;
						public void run(){
							frame = new IniciarSesion();
							synchronized(frame){
								try {
									frame.wait();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println(""+frame.getUser().getTipo());
							frame.dispose();
						}
					};
					t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IniciarSesion() {
		setTitle("Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Usuario");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		contentPane.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addActionListener(this);
		txtNombre.setActionCommand("Enter");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 1;
		contentPane.add(lblContrasea, gbc_lblContrasea);
		
		txtPass = new JPasswordField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 2;
		gbc_txtPass.gridy = 1;
		contentPane.add(txtPass, gbc_txtPass);
		txtPass.addActionListener(this);
		txtPass.setActionCommand("Enter");
		
		btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 2;
		contentPane.add(btnAceptar, gbc_btnAceptar);
		btnAceptar.setActionCommand("Aceptar");
		btnAceptar.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Aceptar")){
			Conexion c = new Conexion();
			try {
				ResultSet rs = c.executeQ("SELECT * FROM usuarios WHERE usr_usr='" + txtNombre.getText() + "'");
				if(rs.next() && rs.getString("pass_usr").equals(new String(txtPass.getPassword()))){
					user = new Usuario(rs.getString("usr_usr"),rs.getString("pass_usr"),rs.getString("nom_usr"),rs.getInt("tipo_usr"));
					logged = true;
					synchronized (this) {
						this.notifyAll();	
					}
				}else{
					JOptionPane.showMessageDialog(this, "El nombre de usuario y/o contraseña son incorrectos.", "Error al iniciar sesión.", JOptionPane.ERROR_MESSAGE);
					txtPass.setText("");
					txtNombre.grabFocus();
					txtNombre.selectAll();
				}
				c.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getActionCommand().equals("Enter")){
			btnAceptar.doClick();
		}
	}

	public boolean isLogged() {
		return logged;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	
}
