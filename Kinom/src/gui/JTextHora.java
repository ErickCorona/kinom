package gui;

import javax.swing.JTextField;

public class JTextHora extends JTextField {
	private static final long serialVersionUID = 1L;
	int id;
	//String dia;
	
	
	public JTextHora(int id){
		super();
		setColumns("00:00".length());
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}
