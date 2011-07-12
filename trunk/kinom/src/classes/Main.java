package classes;

import gui.IniciarSesion;

public class Main {

	public static void main(String args[]){
		IniciarSesion frame;
		frame = new IniciarSesion();
		synchronized(frame){
			try {
				frame.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(""+frame.getUser().getTipo());
		frame.dispose();
	}
}
