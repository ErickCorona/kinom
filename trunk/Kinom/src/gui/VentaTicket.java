package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentaTicket extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel main;
	
	public VentaTicket(){
		super("Venta de Tickets");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String args[]){
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new VentaTicket();
            }
        });
	}
}
