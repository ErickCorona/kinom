package classes;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.JFrame;

import gui.FrmAdministrador;
import gui.FrmSuperAdm;
import gui.FrmVentaTicket;
import gui.IniciarSesion;

public class Main {

	public static void main(String args[]){
		JFrame ventana = new JFrame();
		while(true){
			IniciarSesion ini = new IniciarSesion();
			synchronized(ini){
				try {
					ini.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Usuario usr = ini.getUser();
			ini.dispose();
			switch(usr.getTipo()){
				case 0:
					ventana = new FrmAdministrador();
					ventana.setVisible(true);
					break;
				case 1:
					ventana = new FrmVentaTicket(usr);
					ventana.setVisible(true);
					break;
				case 2:
					ventana = new FrmSuperAdm();
					ventana.setVisible(true);
					break;
			}
			ventana.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					synchronized (e.getComponent()) {
						e.getComponent().notifyAll();
					}
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			synchronized(ventana){
				try {
					ventana.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
