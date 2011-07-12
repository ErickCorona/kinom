package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.ImageUtils;
import bd.Conexion;
import classes.Pelicula;
import javax.swing.SwingConstants;

public class FrmAdmPelicula extends JFrame implements ActionListener {
	
	JComboBox comboIdio;
	JTextArea txSinpel;
	JButton btnGuardar;
	JButton btnCancelar;
	JButton btnAbrir = new JButton("Abrir");
	JLabel lblpic;
	JComboBox comboClas;
	private ImageIcon imgThumb;
	private Pelicula peli;
	boolean cambioimagen=false;

	public FrmAdmPelicula(Pelicula p){
		peli=p;
		init();
	}
	
	public FrmAdmPelicula(){
		peli= new Pelicula(0,"",null,"",0,"","Español",1);
		init();
	}
	
	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Administrar Pelicula");
		setBounds(100, 100, 594, 480);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 138, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		txImgpel.setEditable(false);
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
		lblClasificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacion.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblClasificacion = new GridBagConstraints();
		gbc_lblClasificacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblClasificacion.gridx = 1;
		gbc_lblClasificacion.gridy = 7;
		getContentPane().add(lblClasificacion, gbc_lblClasificacion);
		
		comboClas = new JComboBox();
		comboClas.setModel(new DefaultComboBoxModel(new String[] {"AA", "A", "B", "B-15", "C", "D"}));
		comboClas.setSelectedIndex(0);
		GridBagConstraints gbc_comboClas = new GridBagConstraints();
		gbc_comboClas.insets = new Insets(0, 0, 5, 5);
		gbc_comboClas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboClas.gridx = 2;
		gbc_comboClas.gridy = 7;
		getContentPane().add(comboClas, gbc_comboClas);
		
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
		GridBagConstraints gbc_comboClas1 = new GridBagConstraints();
		gbc_comboClas1.insets = new Insets(0, 0, 5, 5);
		gbc_comboClas1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboClas1.gridx = 2;
		gbc_comboClas1.gridy = 9;
		getContentPane().add(comboIdio, gbc_comboClas1);
		
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
		txSinpel.setTabSize(6);
		txSinpel.setFont(new Font("Arial", Font.BOLD, 12));
		txSinpel.setLineWrap(true);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(txSinpel);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 12;
		
		getContentPane().add(scroll, gbc_textArea);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_1.gridx = 5;
		gbc_horizontalStrut_1.gridy = 12;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JLabel lblsonObligatorios = new JLabel("*Campos Obligatorios");
		lblsonObligatorios.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblsonObligatorios = new GridBagConstraints();
		gbc_lblsonObligatorios.insets = new Insets(0, 0, 0, 5);
		gbc_lblsonObligatorios.gridx = 1;
		gbc_lblsonObligatorios.gridy = 13;
		getContentPane().add(lblsonObligatorios, gbc_lblsonObligatorios);
		
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
		llena();
		setVisible(true);
	}
	
	private void llena()
	{
		txtNompel.setText(peli.getNombre());
		txDurpel.setText(""+peli.getDuracion());
		txSinpel.setText(peli.getSinopsis());
		txImgpel.setText("");
		
		if(peli.getImagen()!=null){
			Image nueva = peli.getImagen().getImage(); 
			BufferedImage tempBuff = new BufferedImage(nueva.getWidth(null),nueva.getHeight(null), BufferedImage.TYPE_INT_RGB); //Buffered image		
			Graphics2D g2 = tempBuff.createGraphics(); //Obtemeos la instancia grafica
		    g2.drawImage(nueva, 0, 0,null); //La pintamos
			BufferedImage scaled = new BufferedImage(130, 180, BufferedImage.TYPE_INT_RGB);
			scaled = ImageUtils.getScaledInstance(tempBuff, 130, 180, RenderingHints.VALUE_INTERPOLATION_BILINEAR,false);
			imgThumb = new ImageIcon(scaled);
			lblpic.setIcon(imgThumb);
			lblpic.setText("");
		}
		if(peli.getIdioma().equals("Subtitulada")){
			comboIdio.setSelectedIndex(1);
		}
		else{
			comboIdio.setSelectedIndex(0);
		}
		if(peli.getClasificacion().equals("AA")){
			comboClas.setSelectedIndex(0);
		}
		if(peli.getClasificacion().equals("A")){
			comboClas.setSelectedIndex(1);
		}
		if(peli.getClasificacion().equals("B")){
			comboClas.setSelectedIndex(2);
		}
		if(peli.getClasificacion().equals("B-15")){
			comboClas.setSelectedIndex(3);
		}
		if(peli.getClasificacion().equals("C")){
			comboClas.setSelectedIndex(4);
		}
		if(peli.getClasificacion().equals("D")){
			comboClas.setSelectedIndex(5);
		}
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
			cambioimagen=true;
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
			String Idiom;
			System.out.println(peli.getId());
			try{
				//para ver si es numero
				int nume = Integer.parseInt(txDurpel.getText());  
			}
			catch(Exception e2){
				JOptionPane.showMessageDialog(FrmAdmPelicula.this, "La duracion debe ser un numero");
			}
			if(peli.getId()==0){
				System.out.println("Bla");
				Idiom= comboIdio.getSelectedItem().toString();
				try {
					if(txImgpel.getText().equals("")||txtNompel.getText().equals("")){
						JOptionPane.showMessageDialog(FrmAdmPelicula.this, "Los campos Nombre e Imagen son Obligatorios");
					}else{
					 Conexion c = new Conexion();
					 c.GuardaPelicula(file1,txtNompel.getText(), comboClas.getSelectedItem().toString(), txDurpel.getText(), txSinpel.getText(), Idiom);
					 c.close();
					 JOptionPane.showMessageDialog(FrmAdmPelicula.this, "Pelicula Guardada Exitosamente");
					 this.dispose();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				System.out.println("Bla Modificar");
				if(txtNompel.getText().equals("")){
					JOptionPane.showMessageDialog(FrmAdmPelicula.this, "Los campos Nombre e Imagen son Obligatorios");
				}
				Idiom= comboIdio.getSelectedItem().toString();
				 try {
					 Conexion c = new Conexion();
					 if(!cambioimagen){
						 System.out.println("nulo");

						 c.ModificaPelicula(peli.getId(),null,txtNompel.getText(), comboClas.getSelectedItem().toString(), txDurpel.getText(), txSinpel.getText(), Idiom);
					 }else{
						 System.out.println("no nulo");
						 c.ModificaPelicula(peli.getId(),file1,txtNompel.getText(), comboClas.getSelectedItem().toString(), txDurpel.getText(), txSinpel.getText(), Idiom);
					 }
					 c.close();
					 JOptionPane.showMessageDialog(FrmAdmPelicula.this, "Se ha efecutado la modificacion");
					 this.dispose();
				 } catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			synchronized(this){
				this.notifyAll();
			}
		}
		else if(e.getActionCommand().equals( "Cancelar")){
				this.dispose();
		}
	}
}
