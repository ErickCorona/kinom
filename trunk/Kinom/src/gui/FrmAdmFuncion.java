package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;

import bd.Conexion;
import classes.Cartelera;
import classes.Funcion;
import classes.Pelicula;
import classes.Sala;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.xml.transform.OutputKeys;

public class FrmAdmFuncion extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCapacidad;
	private JList lstPeliculas;
	private JComboBox cmbSala;
	private PnHorario pnHorario;
	JButton btnAgregar;
	JButton btnModificar;
	JButton btnEliminar;
	private JScrollPane scrollPane_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdmFuncion frame = new FrmAdmFuncion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public FrmAdmFuncion() throws SQLException, ClassNotFoundException, ParseException {
		setTitle("Cartelera");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnEncabezado = new JPanel();
		contentPane.add(pnEncabezado, BorderLayout.NORTH);
		GridBagLayout gbl_pnEncabezado = new GridBagLayout();
		gbl_pnEncabezado.columnWidths = new int[]{306, 0, 0};
		gbl_pnEncabezado.rowHeights = new int[]{117, 0};
		gbl_pnEncabezado.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnEncabezado.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnEncabezado.setLayout(gbl_pnEncabezado);
		
		JPanel pnSalas = new JPanel();
		pnSalas.setBorder(new TitledBorder(null, "Salas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnSalas = new GridBagConstraints();
		gbc_pnSalas.insets = new Insets(0, 0, 0, 5);
		gbc_pnSalas.fill = GridBagConstraints.BOTH;
		gbc_pnSalas.gridx = 0;
		gbc_pnSalas.gridy = 0;
		pnEncabezado.add(pnSalas, gbc_pnSalas);
		pnSalas.setLayout(new MigLayout("", "[grow][grow]", "[][][][grow]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnSalas.add(verticalStrut, "cell 1 0");
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnSalas.add(lblSala, "cell 0 1,alignx trailing");
		
		cmbSala = new JComboBox();
		cmbSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbSala.getSelectedIndex() >= 0){
				JComboBox cmbSala = (JComboBox) arg0.getSource();
				Sala sala = (Sala) cmbSala.getSelectedItem();
				
					txtCapacidad.setText(""+sala.getCapacidad());
				}else{
					txtCapacidad.setText("");
				}
				
			}
		});
		cmbSala.setEditable(true);
		cmbSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnSalas.add(cmbSala, "cell 1 1,growx");
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnSalas.add(lblCapacidad, "cell 0 2,alignx trailing");
		
		txtCapacidad = new JTextField();
		txtCapacidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnSalas.add(txtCapacidad, "cell 1 2,growx");
		txtCapacidad.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		pnSalas.add(panel_2, "cell 0 3 2 1,grow");
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numSala = JOptionPane.showInputDialog("Ingresa la capacidad de la sala");
				if (numSala == null)
					return;
				
				
				
				try {
					int num = Integer.parseInt(numSala);
					Conexion conn = new Conexion();
					
					conn.insert("salas", "null, "+num);
					llenarSalas();
					conn.close();
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Agregado correctamente");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Numero invalido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sala sala = (Sala) cmbSala.getSelectedItem();
				Conexion conn = new Conexion();
				try {
					int cap = Integer.parseInt(txtCapacidad.getText());
					conn.update("salas", "cap_sala="+cap, "id_sala="+sala.getNumero());
					conn.close();
					llenarSalas();
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Cambiado correctamente");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Numero invalido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel_2.add(btnNewButton);
		
		JPanel pnPeliculas = new JPanel();
		pnPeliculas.setBorder(new TitledBorder(null, "Peliculas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnPeliculas = new GridBagConstraints();
		gbc_pnPeliculas.fill = GridBagConstraints.BOTH;
		gbc_pnPeliculas.gridx = 1;
		gbc_pnPeliculas.gridy = 0;
		pnEncabezado.add(pnPeliculas, gbc_pnPeliculas);
		GridBagLayout gbl_pnPeliculas = new GridBagLayout();
		gbl_pnPeliculas.columnWidths = new int[]{0, 0, 0};
		gbl_pnPeliculas.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnPeliculas.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnPeliculas.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		pnPeliculas.setLayout(gbl_pnPeliculas);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnPeliculas.add(scrollPane, gbc_scrollPane);
		
		lstPeliculas = new JList();
		lstPeliculas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstPeliculas);
		
		btnAgregar = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.anchor = GridBagConstraints.SOUTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 0;
		pnPeliculas.add(btnAgregar, gbc_btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 1;
		pnPeliculas.add(btnEliminar, gbc_btnEliminar);
		
		btnModificar = new JButton("Modificar");
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar.anchor = GridBagConstraints.NORTH;
		gbc_btnModificar.gridx = 1;
		gbc_btnModificar.gridy = 2;
		pnPeliculas.add(btnModificar, gbc_btnModificar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_1, BorderLayout.NORTH);
		
		final JButton btnAgregarmodificar = new JButton("Agregar/Modificar");
		btnAgregarmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Consultar si ya existe una funcion con esas caracteristicas
				Pelicula pel = (Pelicula) lstPeliculas.getSelectedValue(); //Se obtiene la pelicula
				Sala sala = (Sala) cmbSala.getSelectedItem(); //Se obtiene la sala
				ArrayList<Funcion> funciones = new ArrayList<Funcion>(); //Guardamos las funciones exitentes
				pnHorario.setPel(pel); //Asignamos al panel la busqueda
				pnHorario.setSala(sala); //Asignamos al panel la busqueda
				try {
					funciones = Cartelera.getFuncionDesdeHoy(pel, sala.getNumero()); //Llenamos el arreglo
					if(funciones.size() == 0){
						//Si el arreglo esta vacio por lo tanto no existe
						//Funciones
						Calendar cal = Calendar.getInstance(); //Creamos un calendar con la fecha actual
						//System.out.println("Prueba");
						pnHorario.llenar(cal);//Lenamos el panel 
						pnHorario.validate();//Recargamos el panel
						
					}else {
						//Ya existen funciones
						pnHorario.llenar(funciones, Calendar.getInstance());//Cargamos las funciones apartir del arreglo
						pnHorario.validate();//Recargamos los paneles
						
					}	
					scrollPane_1.validate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
			}
		});
		panel_1.add(btnAgregarmodificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pnHorario.guardar();
					btnAgregarmodificar.doClick();
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Cambios guardados exitosamente");
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(FrmAdmFuncion.this, "Hora invalida","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel_1.add(btnGuardar);
		
		pnHorario = new PnHorario();
		//panel.add(pnHorario, BorderLayout.CENTER);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportView(pnHorario);
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		
		llenarPeliculas();
		llenarSalas();
		eventoBtn();
	}
	


	public void llenarPeliculas(){
		try {
			lstPeliculas.removeAll();
			ArrayList<Pelicula> peliculas =  new Cartelera().getPeliculasE();
			DefaultListModel model = new DefaultListModel();
			for (Pelicula pelicula : peliculas) {
				System.out.println(pelicula.getStatus());
				System.out.println(pelicula.getDuracion());
				
				if(pelicula.getStatus()==1){
					model.addElement(pelicula);
				}
				//System.out.println("Hola");
			}
			
			this.lstPeliculas.setModel(model);
			lstPeliculas.setSelectedIndex(0);
			lstPeliculas.validate();
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
	
	public void llenarSalas(){
		ArrayList<Sala> salas;
		try {
			salas = Sala.getSalas();
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			//model.addElement("");
			for (Sala sala : salas) {
				model.addElement(sala);
				
			}
			this.cmbSala.setModel(model);
			this.txtCapacidad.setText(""+salas.get(0).getCapacidad());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void eventoBtn()
	{
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
	}

	public JList getLstPeliculas() {
		return lstPeliculas;
	}
	public JComboBox getCmbSala() {
		return cmbSala;
	}
	public JPanel getPnHorario() {
		return pnHorario;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")){
			Thread t = new Thread(){
				public void run(){
					FrmAdmPelicula pel = new FrmAdmPelicula();
					synchronized(pel){
						try {
							pel.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
					llenarPeliculas();
				}
			};
			t.start();
		}
		else if(e.getActionCommand().equals("Modificar")){
				int abc = lstPeliculas.getSelectedIndex();
				llenarPeliculas();
				lstPeliculas.setSelectedIndex(abc);
				new FrmAdmPelicula((Pelicula)lstPeliculas.getSelectedValue());
		}
		else if(e.getActionCommand().equals( "Eliminar")){
			Conexion c = new Conexion();
			try {
				int nume=JOptionPane.showConfirmDialog(FrmAdmFuncion.this, "¿Esta seguro de Eliminar la pelicula?");
				System.out.println(nume);
				if(nume==0){
					c.EliminarPelicula((Pelicula)(lstPeliculas.getSelectedValue()));
					llenarPeliculas();
				}
				c.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}
}
