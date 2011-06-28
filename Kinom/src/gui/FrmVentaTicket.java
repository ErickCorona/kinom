package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

public class FrmVentaTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmVentaTicket frame = new FrmVentaTicket();
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
	public FrmVentaTicket() {
		setTitle("Venta de Tickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel PnVentaPanel = new PnDetalleTicket();
		GridBagLayout gridBagLayout = (GridBagLayout) PnVentaPanel.getLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 135, 0};
		contentPane.add(PnVentaPanel, BorderLayout.WEST);
		
		JPanel pnSuperior = new PnEncabezadoVen();
		contentPane.add(pnSuperior, BorderLayout.NORTH);
		
		JPanel pnCentral = new PnCartelera();
		contentPane.add(pnCentral, BorderLayout.CENTER);
	}

}
