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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.util.Calendar;

public class FrmAdmFuncion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCapacidad;
	private JList lstPeliculas;

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
	 */
	public FrmAdmFuncion() {
		setTitle("Cartelera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		pnSalas.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		pnSalas.add(verticalStrut, "cell 1 0");
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnSalas.add(lblSala, "cell 0 1,alignx trailing");
		
		JComboBox cmbSala = new JComboBox();
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
		scrollPane.setViewportView(lstPeliculas);
		
		JButton btnAgregar = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAgregar.anchor = GridBagConstraints.SOUTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 0;
		pnPeliculas.add(btnAgregar, gbc_btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 1;
		pnPeliculas.add(btnEliminar, gbc_btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
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
		
		JButton btnAgregarmodificar = new JButton("Agregar/Modificar");
		panel_1.add(btnAgregarmodificar);
		
		JButton btnGuardar = new JButton("Guardar");
		panel_1.add(btnGuardar);
		
		JPanel panel_2 = new PnHorario(Calendar.getInstance());
		panel.add(panel_2, BorderLayout.CENTER);
	}
	
	public void llenarPeliculas(){
		
		
	}

	public JList getLstPeliculas() {
		return lstPeliculas;
	}
}
