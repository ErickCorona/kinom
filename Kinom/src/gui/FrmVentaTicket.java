package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Cartelera;
import classes.Funcion;
import classes.Usuario;

public class FrmVentaTicket extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PnEncabezadoVen pnSuperior;
	private PnCartelera pnCentral;
	private PnDetalleTicket PnVentaPanel;
	private Usuario user;
	Cartelera car;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVentaTicket frame = new FrmVentaTicket(new Usuario("tick","tick","Omar Bermúdez",0));
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
	public FrmVentaTicket(Usuario user) {
		this.user = user;

		setTitle("Venta de Tickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 PnVentaPanel = new PnDetalleTicket();
		GridBagLayout gridBagLayout = (GridBagLayout) PnVentaPanel.getLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 135, 0};
		contentPane.add(PnVentaPanel, BorderLayout.WEST);
		
		pnSuperior = new PnEncabezadoVen();
		contentPane.add(pnSuperior, BorderLayout.NORTH);
		
	
		
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		Calendar fecha = Calendar.getInstance();
		SimpleDateFormat fecha_h = new SimpleDateFormat("EEE, MMM d, ''yy ");
		for(int i=0;i<7;i++){
			model.addElement(fecha_h.format(fecha.getTime()));
			fecha.set(Calendar.DATE, fecha.get(Calendar.DATE)+1);
		}
		
		pnSuperior.setModelFecha(model);
		
	
		try {
			car = new Cartelera();
			pnCentral = new PnCartelera(car.getPeliculas(Calendar.getInstance()));
			contentPane.add(pnCentral, BorderLayout.CENTER);
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
		
		pnSuperior.getCmbFecha().addActionListener(this);
		eventoBtn();
		PnVentaPanel.getBtnCancelar().addActionListener(this);
		pnSuperior.getTxtNombre().setText(user.getNombre());
	}
	
	private void eventoBtn(){
		ArrayList<BtnPelicula> botones = pnCentral.getBotones();
		for (BtnPelicula btnPelicula : botones) {
			btnPelicula.addActionListener(this);
			btnPelicula.setActionCommand("pelicula");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cmbFecha") || e.getActionCommand().equals("cancel")){
			try {
				Calendar fecha = Calendar.getInstance();
				if(!e.getActionCommand().equals("cancel")){
					SimpleDateFormat format = new SimpleDateFormat("EEE, MMM d, ''yy ");
					JComboBox cfecha = (JComboBox) e.getSource();
					fecha.setTime(format.parse(cfecha.getSelectedItem().toString()));
				}else{
					pnSuperior.getCmbFecha().setSelectedIndex(0);
				}
				contentPane.remove(pnCentral);
				if(fecha.get(Calendar.DAY_OF_YEAR)==Calendar.getInstance().get(Calendar.DAY_OF_YEAR))
					fecha = Calendar.getInstance();
				pnCentral = new PnCartelera(car.getPeliculas(fecha));
				contentPane.add(pnCentral, BorderLayout.CENTER);
				contentPane.validate();
				eventoBtn();
				PnVentaPanel.llenar(new ArrayList<Funcion>());
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}else if(e.getActionCommand().equals( "pelicula")){
			System.out.println("Purbe");
			BtnPelicula btn = (BtnPelicula) e.getSource();
			
			try {
				PnVentaPanel.llenar(car.getFunciones(btn.getPeli(), btn.getSala()));
				btn.getPeli().desplegarInfo(pnCentral.getTxtInformacion(),btn.getSala());
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
		
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	
}
