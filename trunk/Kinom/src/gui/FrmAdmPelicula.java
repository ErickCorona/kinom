package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;

import utils.ImageUtils;

import bd.Conexion;

import classes.Funcion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.FlowLayout;

public class FrmAdmPelicula extends JFrame implements ActionListener {
	
	JComboBox comboIdio;
	JTextArea txSinpel;
	JButton btnGuardar;
	JButton btnCancelar;
	JButton btnAbrir = new JButton("Abrir");
	JLabel lblpic;
	private ImageIcon imgThumb;

	public FrmAdmPelicula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Administrar Pelicula");
		setBounds(100, 100, 594, 480);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 138, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 3.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 8.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		txtNompel = new JTextField();
		txtNompel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_txtNompel = new GridBagConstraints();
		gbc_txtNompel.insets = new Insets(0, 0, 5, 5);
		gbc_txtNompel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNompel.gridx = 2;
		gbc_txtNompel.gridy = 1;
		getContentPane().add(txtNompel, gbc_txtNompel);
		txtNompel.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen*");
		lblImagen.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 3;
		getContentPane().add(lblImagen, gbc_lblImagen);
		
		txImgpel = new JTextField();
		GridBagConstraints gbc_txImgpel = new GridBagConstraints();
		gbc_txImgpel.insets = new Insets(0, 0, 5, 5);
		gbc_txImgpel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txImgpel.gridx = 2;
		gbc_txImgpel.gridy = 3;
		getContentPane().add(txImgpel, gbc_txImgpel);
		txImgpel.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 3;

		btnAbrir.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(btnAbrir,gbc_btnNewButton);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 5;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		txDurpel = new JTextField();
		GridBagConstraints gbc_txDurpel = new GridBagConstraints();
		gbc_txDurpel.insets = new Insets(0, 0, 5, 5);
		gbc_txDurpel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txDurpel.gridx = 2;
		gbc_txDurpel.gridy = 5;
		getContentPane().add(txDurpel, gbc_txDurpel);
		txDurpel.setColumns(10);
		
		lblpic = new JLabel("Imagen");
		GridBagConstraints gbc_lblpic = new GridBagConstraints();
		gbc_lblpic.anchor = GridBagConstraints.EAST;
		gbc_lblpic.gridheight = 7;
		gbc_lblpic.insets = new Insets(0, 0, 5, 5);
		gbc_lblpic.gridx = 4;
		gbc_lblpic.gridy = 5;
		getContentPane().add(lblpic, gbc_lblpic);
		
		JLabel lblClasificacion = new JLabel("Clasificacion");
		lblClasificacion.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblClasificacion = new GridBagConstraints();
		gbc_lblClasificacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasificacion.gridx = 1;
		gbc_lblClasificacion.gridy = 7;
		getContentPane().add(lblClasificacion, gbc_lblClasificacion);
		
		txClaspel = new JTextField();
		txClaspel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_txClaspel = new GridBagConstraints();
		gbc_txClaspel.insets = new Insets(0, 0, 5, 5);
		gbc_txClaspel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txClaspel.gridx = 2;
		gbc_txClaspel.gridy = 7;
		getContentPane().add(txClaspel, gbc_txClaspel);
		txClaspel.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 3;
		gbc_horizontalStrut_2.gridy = 7;
		getContentPane().add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		JLabel lblNewLabel = new JLabel("Idioma");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		comboIdio = new JComboBox();
		comboIdio.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "Subtitulada"}));
		comboIdio.setSelectedIndex(0);
		comboIdio.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 9;
		getContentPane().add(comboIdio, gbc_comboBox);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 10;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 11;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblSinopsis = new JLabel("Sinopsis:");
		lblSinopsis.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblSinopsis = new GridBagConstraints();
		gbc_lblSinopsis.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinopsis.gridx = 1;
		gbc_lblSinopsis.gridy = 11;
		getContentPane().add(lblSinopsis, gbc_lblSinopsis);
		
		txSinpel = new JTextArea();
		txSinpel.setColumns(2);
		txSinpel.setRows(1);
		txSinpel.setTabSize(6);
		txSinpel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 12;
		getContentPane().add(txSinpel, gbc_textArea);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 12;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 13;
		getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);
		btnGuardar.setFont(new Font("Verdana", Font.BOLD, 14));
			
		btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 14));

		eventoBtn();
	}
	
	private void eventoBtn()
	{
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("Guardar");
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("Cancelar");
		btnAbrir.addActionListener(this);
		btnAbrir.setActionCommand("Abrir");
	}
	private static final long serialVersionUID = 1L;
	private JTextField txtNompel;
	private JTextField txImgpel;
	private JTextField txDurpel;
	private JTextField txClaspel;
	File file1;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdmPelicula frame = new FrmAdmPelicula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Abrir")){
			System.out.println("Bla");
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
                file1 = fc.getSelectedFile();
			}
			txImgpel.setText(file1.getAbsolutePath());
			ImageIcon img = new ImageIcon(txImgpel.getText());
			Image nueva = img.getImage(); 
			
			BufferedImage tempBuff = new BufferedImage(nueva.getWidth(null),nueva.getHeight(null), BufferedImage.TYPE_INT_RGB); //Buffered image		
			
			Graphics2D g2 = tempBuff.createGraphics(); //Obtemeos la instancia grafica
		    g2.drawImage(nueva, 0, 0,null); //La pintamos
		    
			BufferedImage scaled = new BufferedImage(130, 180, BufferedImage.TYPE_INT_RGB);
			
			scaled = ImageUtils.getScaledInstance(tempBuff, 130, 180, RenderingHints.VALUE_INTERPOLATION_BILINEAR,false);
			
			imgThumb = new ImageIcon(scaled);
			lblpic.setIcon(imgThumb);
			lblpic.setText("");

			
		}
		else if(e.getActionCommand().equals("Guardar")){
				System.out.println("Bla");
				String Idiom;
				Idiom= comboIdio.getSelectedItem().toString();
				try {
					 Conexion c = new Conexion();
					 c.GuardaPelicula(file1,txtNompel.getText(), txClaspel.getText(), txDurpel.getText(), txSinpel.getText(), Idiom);
					 c.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				byte[] person_image = null;
				
				
				File image = new File(file);
			    FileInputStream fis = null;
			    
				fis = new FileInputStream(image);
				
				File image = new File(file);
				
				FileInputStream   fis = new FileInputStream(image);
				
				
				stmt.setBinaryStream(1, fis, (int) image.length());
				stmt.execute();
				
					*/
					//Creamos una cadena para después prepararla
					//File imagen = new File(ruta);
					//ruta puede ser: "/home/cmop/Desktop/1.jpg"
					//FileInputStream   fis = new FileInputStream(imagen);
					//Lo convertimos en un Stream
					//Asignamos el Stream al Statement
				
					

			//} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
		//		e2.printStackTrace();
			
		}
		else if(e.getActionCommand().equals( "Cancelar")){
				txtNompel.setText("");
				txImgpel.setText("");
				txDurpel.setText("");
				txClaspel.setText("");
				txSinpel.setText("");
				comboIdio.setSelectedIndex(0);
				lblpic.setText("Imagen");
				lblpic.setIcon(null);
		}
	}
}
