package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.lowagie.text.Image;

import utils.MailService;
import bd.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmSuperAdm extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPasswordField txtPass;
	private JLabel image;
	private JPanel panel_1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSuperAdm frame = new FrmSuperAdm();
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
	public FrmSuperAdm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Cambiar contrase\u00F1a de Administrador");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPass = new JPasswordField();
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.insets = new Insets(0, 0, 5, 0);
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.gridx = 0;
		gbc_txtPass.gridy = 1;
		panel.add(txtPass, gbc_txtPass);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAceptar.anchor = GridBagConstraints.EAST;
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 2;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnEnviar = new JButton("Enviar mi contrase\u00F1a al correo");
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				image.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnviar.gridx = 0;
		gbc_btnEnviar.gridy = 0;
		panel_1.add(btnEnviar, gbc_btnEnviar);
		
		image = new JLabel("");
		image.setIcon(new ImageIcon(FrmSuperAdm.class.getResource("/imagen/load.gif")));
		GridBagConstraints gbc_image = new GridBagConstraints();
		gbc_image.gridx = 1;
		gbc_image.gridy = 0;
		panel_1.add(image, gbc_image);
		image.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmSuperAdm.class.getResource("/imagen/usb-icon.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("Aceptar");
		btnEnviar.addActionListener(this);
		btnEnviar.setActionCommand("Enviar");
	}

	private ResultSet rs;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Aceptar")){
			if(txtPass.getPassword().length==0){
				JOptionPane.showMessageDialog(this, "La contraseña no puede ser vacía.");
				return;
			}
			Conexion c = new Conexion();
			try {
				c.executeU("UPDATE usuarios SET pass_usr='" + new String(txtPass.getPassword()) + "' WHERE tipo_usr=0");
				c.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "La contraseña del administrador fue cambiada.");
			txtPass.setText("");
		}else if(e.getActionCommand().equals("Enviar")){
			final Conexion c = new Conexion();
			try {
				rs = c.executeQ("SELECT pass_usr FROM usuarios WHERE tipo_usr=2");
				Thread t = new Thread(){
					public void run(){
						try {
							MailService.send("Contraseña - Kinom", "Su contraseña para acceder al sistema es <b>" + rs.getString("pass_usr") + "</b>", new ArrayList<String>());
							image.setVisible(false);
							c.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
