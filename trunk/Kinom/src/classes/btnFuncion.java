package classes;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class btnFuncion extends JPanel{
	private static final long serialVersionUID = 1L;
	private int idFuncion;
	private String nombre;
	private ImageIcon img;
	private JToggleButton btnPeli;
	
	public btnFuncion(Funcion funcion){
		idFuncion = funcion.getPelicula().getId();
		nombre = funcion.getPelicula().getNombre();
		img = funcion.getPelicula().getImagen();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		btnPeli = new JToggleButton(this.img);
		btnPeli.setAlignmentX(CENTER_ALIGNMENT);
		JLabel titulo = new JLabel(this.nombre);
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		this.add(titulo);
		this.add(btnPeli);
	
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public JToggleButton getBtnPeli() {
		return btnPeli;
	}

	public void setBtnPeli(JToggleButton btnPeli) {
		this.btnPeli = btnPeli;
	}

}
