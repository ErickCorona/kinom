package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Conexion;

import net.miginfocom.swing.MigLayout;
import classes.Pelicula;
import classes.Sala;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class FrmCorteDiario extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbSala;
	private JComboBox cmbPeliculas;
	private JTextField txtSala;
	private JTextField txtTitulo;
	private JTextField txtVendidos;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCorteDiario frame = new FrmCorteDiario();
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
	public FrmCorteDiario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Recorte Diario");
		setBounds(100, 100, 450, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("", "[][grow][][grow]", "[]"));
		
		JLabel lblSala = new JLabel("Sala:");
		panel_2.add(lblSala, "cell 0 0,alignx trailing");
		
		cmbSala = new JComboBox();
		cmbSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox box = (JComboBox) arg0.getSource();
				Sala sala = (Sala) box.getSelectedItem();
				llenarPelicula(sala.getNumero());
			}
		});
		panel_2.add(cmbSala, "cell 1 0,growx");
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		panel_2.add(lblPelicula, "cell 2 0,alignx trailing");
		
		cmbPeliculas = new JComboBox();
		cmbPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox combo = (JComboBox) e.getSource();
				Pelicula peli = (Pelicula) combo.getSelectedItem();
				llenarCampos(peli.getId());
				
			}
		});
		panel_2.add(cmbPeliculas, "cell 3 0,growx");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][]"));
		
		JLabel lblSala_1 = new JLabel("Sala");
		lblSala_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblSala_1, "cell 0 0,alignx center");
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblTitulo, "cell 1 0,alignx center");
		
		JLabel lblVendidos = new JLabel("Vendidos");
		lblVendidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblVendidos, "cell 2 0,alignx center");
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblTotal, "cell 3 0,alignx center");
		
		txtSala = new JTextField();
		txtSala.setEditable(false);
		panel_3.add(txtSala, "cell 0 1,growx");
		txtSala.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		panel_3.add(txtTitulo, "cell 1 1,growx");
		txtTitulo.setColumns(10);
		
		txtVendidos = new JTextField();
		txtVendidos.setEditable(false);
		panel_3.add(txtVendidos, "cell 2 1,growx");
		txtVendidos.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		panel_3.add(txtTotal, "cell 3 1,growx");
		txtTotal.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblCorteDiario = new JLabel("Corte Diario");
		panel_1.add(lblCorteDiario);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnSalir);
		
		llenarSalas();
		llenarPelicula(cmbSala.getSelectedIndex() + 1);
		Pelicula pel = (Pelicula) cmbPeliculas.getSelectedItem();
		if(pel != null)
			llenarCampos(pel.getId());
		
		
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void llenarPelicula(int id_pel){
		//System.out.println(""+id_pel);
		Conexion conn = new Conexion();
		DefaultComboBoxModel model = new DefaultComboBoxModel();

		try {
			String stm = "SELECT DISTINCT " +
					"peliculas.id_pel,peliculas.nom_pel " +
					"FROM peliculas,funciones,salas " +
					"WHERE funciones.id_sala = salas.id_sala " +
					"AND peliculas.id_pel = funciones.id_pel " +
					"AND date(funciones.hro_fun) = date('now', 'localtime') " +
					"AND salas.id_sala = 1 ";
			//System.out.println(stm);
			ResultSet rs = conn.executeQ(stm);
			while(rs.next()){
				Pelicula pel = new Pelicula();
				pel.setNombre(rs.getString("nom_pel"));
				pel.setId(rs.getInt("id_pel"));
				model.addElement(pel);
			}
			cmbPeliculas.setModel(model);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void llenarCampos(int id_pel){
		Conexion conn = new Conexion();
		try {
			ResultSet rs = conn.executeQ("SELECT " +
											"peliculas.nom_pel,COUNT(ventas.id_ven) as venta,SUM(ventas.prec_ven) as total " +
										"FROM  ventas,funciones,peliculas  " +
										"WHERE  ventas.id_fun = funciones.id_fun  " +
										"AND funciones.id_pel = peliculas.id_pel  " +
										"AND date(funciones.hro_fun)=date('now','localtime')  " +
										"AND funciones.id_pel = 1");
			if(rs.next()){
				Sala sala = (Sala) cmbSala.getSelectedItem();
				txtSala.setText(""+sala.getNumero());
				txtTitulo.setText(rs.getString("nom_pel"));
				txtVendidos.setText(rs.getString("venta"));
				txtTotal.setText(rs.getString("total"));
				
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

	public JComboBox getCmbSala() {
		return cmbSala;
	}
	public JComboBox getCmbPeliculas() {
		return cmbPeliculas;
	}
}
