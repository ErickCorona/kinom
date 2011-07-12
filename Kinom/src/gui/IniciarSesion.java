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

import utils.ImageUtils;

import bd.Conexion;
import classes.Usuario;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class IniciarSesion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPass;
	private Usuario user;
	private boolean logged;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	
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
		setBounds(100, 100, 454, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][56px][150px,grow]", "[20px,grow][20px,grow][23px,grow]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageUtils().createImageIcon("../imagen/computer.png", ""));
		contentPane.add(lblNewLabel, "cell 0 0 1 3");
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNombre, "cell 1 0,alignx right,aligny bottom");
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(txtNombre, "cell 2 0,growx,aligny bottom");
		txtNombre.setColumns(10);
		txtNombre.addActionListener(this);
		txtNombre.setActionCommand("Enter");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblContrasea, "cell 1 1,alignx center,aligny top");
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(txtPass, "cell 2 1,growx,aligny top");
		txtPass.addActionListener(this);
		txtPass.setActionCommand("Enter");
		
		btnAceptar = new JButton("Aceptar");
		contentPane.add(btnAceptar, "flowx,cell 2 2,alignx center,aligny top");
		btnAceptar.setActionCommand("Aceptar");
		
		btnSalir = new JButton("Cancelar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir, "cell 2 2,aligny top");
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
