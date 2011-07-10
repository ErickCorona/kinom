package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

import utils.ImageUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;

public class FrmAdministrador extends JFrame {

	private JPanel contentPane;
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdministrador frame = new FrmAdministrador();
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
	public FrmAdministrador() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 0;
		contentPane.add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 0;
		gbc_horizontalStrut_2.gridy = 1;
		contentPane.add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{36, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblImagen.gridx = 0;
		gbc_lblImagen.gridy = 0;
		panel.add(lblImagen, gbc_lblImagen);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_3.gridx = 2;
		gbc_horizontalStrut_3.gridy = 1;
		contentPane.add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_2.add(lblAdministrador);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.fill = GridBagConstraints.VERTICAL;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 0;
		panel_3.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JButton btnAdministrarFunciones = new JButton("Administrar Funciones");
		btnAdministrarFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmAdmFuncion frame;
				try {
					frame = new FrmAdmFuncion();
					frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAdministrarFunciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				llenar("funciones");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salir();
			}
		});
		btnAdministrarFunciones.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_btnAdministrarFunciones = new GridBagConstraints();
		gbc_btnAdministrarFunciones.fill = GridBagConstraints.BOTH;
		gbc_btnAdministrarFunciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdministrarFunciones.gridx = 1;
		gbc_btnAdministrarFunciones.gridy = 0;
		panel_3.add(btnAdministrarFunciones, gbc_btnAdministrarFunciones);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.fill = GridBagConstraints.VERTICAL;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 0;
		panel_3.add(horizontalStrut, gbc_horizontalStrut);
		
		JButton btnAltaTicketero = new JButton("Alta Ticketero");
		btnAltaTicketero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				llenar("ticket");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salir();
			}
		});
		btnAltaTicketero.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_btnAltaTicketero = new GridBagConstraints();
		gbc_btnAltaTicketero.fill = GridBagConstraints.BOTH;
		gbc_btnAltaTicketero.insets = new Insets(0, 0, 5, 5);
		gbc_btnAltaTicketero.gridx = 1;
		gbc_btnAltaTicketero.gridy = 1;
		panel_3.add(btnAltaTicketero, gbc_btnAltaTicketero);
		
		JButton btnCambiarPrecio = new JButton("Cambiar Precio");
		btnCambiarPrecio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				llenar("precio");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salir();
			}
		});
		btnCambiarPrecio.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_btnCambiarPrecio = new GridBagConstraints();
		gbc_btnCambiarPrecio.fill = GridBagConstraints.BOTH;
		gbc_btnCambiarPrecio.insets = new Insets(0, 0, 0, 5);
		gbc_btnCambiarPrecio.gridx = 1;
		gbc_btnCambiarPrecio.gridy = 2;
		panel_3.add(btnCambiarPrecio, gbc_btnCambiarPrecio);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 2;
		contentPane.add(verticalStrut, gbc_verticalStrut);
		salir();
	}
	
	public void llenar(String accion){
		ImageUtils util = new ImageUtils();
		ImageIcon imagen = util.createImageIcon("../imagen/"+accion+".png", accion);
		lblImagen.setIcon(imagen);
		validate();
	}
	
	public void salir(){
		ImageUtils util = new ImageUtils();
		ImageIcon imagen = util.createImageIcon("../imagen/cinema.png", "inicio");
		lblImagen.setIcon(imagen);
		validate();
	}

	public JLabel getLblImagen() {
		return lblImagen;
	}
}
