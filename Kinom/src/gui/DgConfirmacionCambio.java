package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.Conexion;
import classes.Cartelera;
import classes.Funcion;
import classes.Ticket;
import classes.Usuario;

import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DgConfirmacionCambio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPelicula;
	private JTextField txtHora;
	private JTextField txtNumero;
	private JTextField txtTotal;
	private JTextField txtRecibido;
	private JTextField txtCambio;
	private Ticket ticket;
	private int numBoletos;
	private boolean dosx1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DgConfirmacionCambio dialog = new DgConfirmacionCambio(null, false, 1, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DgConfirmacionCambio(Frame owner, boolean modal, int total, Ticket tick) {
		super(owner, modal);
		setBounds(100, 100, 450, 281);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblConfirmacion = new JLabel("Confirmaci\u00F3n");
				lblConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
				panel.add(lblConfirmacion);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 31, 95, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
				gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
				gbc_horizontalGlue.gridx = 0;
				gbc_horizontalGlue.gridy = 0;
				panel.add(horizontalGlue, gbc_horizontalGlue);
			}
			{
				JLabel lblPelicula = new JLabel("Pel\u00EDcula");
				lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblPelicula = new GridBagConstraints();
				gbc_lblPelicula.insets = new Insets(0, 0, 5, 5);
				gbc_lblPelicula.gridx = 1;
				gbc_lblPelicula.gridy = 0;
				panel.add(lblPelicula, gbc_lblPelicula);
			}
			{
				JLabel lblHora = new JLabel("Hora");
				lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblHora = new GridBagConstraints();
				gbc_lblHora.insets = new Insets(0, 0, 5, 5);
				gbc_lblHora.gridx = 3;
				gbc_lblHora.gridy = 0;
				panel.add(lblHora, gbc_lblHora);
			}
			{
				JLabel lblNumero = new JLabel("N\u00FAmero");
				lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblNumero = new GridBagConstraints();
				gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumero.gridx = 5;
				gbc_lblNumero.gridy = 0;
				panel.add(lblNumero, gbc_lblNumero);
			}
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
				gbc_horizontalGlue.insets = new Insets(0, 0, 5, 0);
				gbc_horizontalGlue.gridx = 6;
				gbc_horizontalGlue.gridy = 0;
				panel.add(horizontalGlue, gbc_horizontalGlue);
			}
			{
				txtPelicula = new JTextField();
				txtPelicula.setHorizontalAlignment(SwingConstants.CENTER);
				txtPelicula.setEditable(false);
				txtPelicula.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_txtPelicula = new GridBagConstraints();
				gbc_txtPelicula.insets = new Insets(0, 0, 5, 5);
				gbc_txtPelicula.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPelicula.gridx = 1;
				gbc_txtPelicula.gridy = 1;
				panel.add(txtPelicula, gbc_txtPelicula);
				txtPelicula.setColumns(10);
			}
			{
				txtHora = new JTextField();
				txtHora.setHorizontalAlignment(SwingConstants.CENTER);
				txtHora.setEditable(false);
				txtHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_txtHora = new GridBagConstraints();
				gbc_txtHora.insets = new Insets(0, 0, 5, 5);
				gbc_txtHora.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtHora.gridx = 3;
				gbc_txtHora.gridy = 1;
				panel.add(txtHora, gbc_txtHora);
				txtHora.setColumns(10);
			}
			{
				txtNumero = new JTextField();
				txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
				txtNumero.setEditable(false);
				txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_txtNumero = new GridBagConstraints();
				gbc_txtNumero.insets = new Insets(0, 0, 5, 5);
				gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNumero.gridx = 5;
				gbc_txtNumero.gridy = 1;
				panel.add(txtNumero, gbc_txtNumero);
				txtNumero.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.gridwidth = 5;
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 2;
				panel.add(panel_1, gbc_panel_1);
				panel_1.setLayout(new MigLayout("", "[146.00][grow]", "[][][]"));
				{
					JLabel lblTotal = new JLabel("Total:");
					lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblTotal, "cell 0 0,alignx trailing");
				}
				{
					txtTotal = new JTextField();
					txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
					txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtTotal, "cell 1 0,alignx left");
					txtTotal.setColumns(10);
				}
				{
					JLabel lblRecibido = new JLabel("Recibido:");
					lblRecibido.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblRecibido, "cell 0 1,alignx trailing");
				}
				{
					txtRecibido = new JTextField();
					txtRecibido.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {
							JTextField recib = (JTextField) arg0.getSource();
							try{
								float total = Float.parseFloat(txtTotal.getText());
								float dinero = Float.parseFloat(recib.getText() + arg0.getKeyChar());
								//System.out.println("Recibido: " + dinero);
								txtCambio.setText(""+(dinero-total));
								
							}catch (Exception e) {

							}
						}
					});
					txtRecibido.setHorizontalAlignment(SwingConstants.RIGHT);
					txtRecibido.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtRecibido, "cell 1 1");
					txtRecibido.setColumns(10);
				}
				{
					JLabel lblCambio = new JLabel("Cambio:");
					lblCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblCambio, "cell 0 2,alignx trailing");
				}
				{
					txtCambio = new JTextField();
					txtCambio.setHorizontalAlignment(SwingConstants.RIGHT);
					txtCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtCambio, "cell 1 2");
					txtCambio.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Conexion c = new Conexion();
						try {
							int i;
							for(i=0; i<numBoletos; i++){
									c.insert("ventas", "null," + ticket.getFuncion().getId() + ",(SELECT base_pre FROM precios)," + (dosx1?1:0) + ",null");
									c.executeU("UPDATE funciones SET ocu_fun=ocu_fun+1 WHERE id_fun=" + ticket.getFuncion().getId());
									if(!dosx1 || i%2==0){
										ticket.imprimir(c.getLasID("ventas"));
									}
									//DONE Aumentar oucpados en funcion.
									//DONE Decrementar los 4 en caso de que compren 3 en dia 2x1
									//TODO Cargar el descuento de estudiante.
								
							}
							if(i%2!=0)
								c.executeU("UPDATE funciones SET ocu_fun=ocu_fun+1 WHERE id_fun=" + ticket.getFuncion().getId());
							c.close();
						}catch(Exception ex){
							ex.printStackTrace();
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenar(tick, total);
		setVisible(true);
	}
	
	public void llenar(Ticket tick, int num){
		this.ticket = tick;
		this.numBoletos = num;
		txtHora.setText(tick.getFuncion().toString());
		txtPelicula.setText(tick.getFuncion().getPelicula().getNombre());
		txtNumero.setText(""+num);
		
		if(Cartelera.is2x1(tick.getFuncion().getHorario())){
			//Se contabilizan como 2x1
			double total = Math.round(num/2.0) * Cartelera.getPrecio();
			txtTotal.setText(""+total);
			dosx1 = true;
		}else if(/*Cartelera.isEstudianteDes(tick.getFuncion().getHorario()) && */tick.isDescuento()){
			//Se venden los boletos con descuento de estudiantes
			double total = num * Cartelera.getPrecioDesc();
			txtTotal.setText(""+total);
			dosx1 = false;
		}else{
			//No es 2x1
			double total = num * Cartelera.getPrecio();
			txtTotal.setText(""+total);
			dosx1 = false;
		}
	}

}
