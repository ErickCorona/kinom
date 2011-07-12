package classes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Pelicula {
	private int id;


	private String nombre;
	private ImageIcon imagen;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private String idioma;
	private int status=0;
	
	public Pelicula() {
		
	}
	
	public Pelicula(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Pelicula(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Pelicula(int id, String nombre, ImageIcon imagen,
			String clasificacion, int duracion, String sinopsis, String idioma,int stus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.clasificacion = clasificacion;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.idioma = idioma;
		this.status = stus;
	}
	
	public void desplegarInfo(JTextPane text, int sala){
		String info = nombre + " " + idioma + "\nSala: " + sala + "\nDuración: " + duracion + "\nClas. " + (clasificacion==null?"s/c":clasificacion) + "\nSinopsis: \n" + sinopsis;
		int lon = info.length();
		text.setText(info);
		StyledDocument doc = text.getStyledDocument();
		
		doc.setCharacterAttributes(0, info.indexOf('\n'), text.getStyle("24bold"), true);
		int prev = info.length();
		info = info.substring(info.indexOf('\n')+1);
		int fsala = info.indexOf('\n');
		doc.setCharacterAttributes(prev-info.length(), fsala, text.getStyle("Red18bold"), true);
		int cosatam=(prev-info.length())+fsala;
		//System.out.println(""+(prev-info.length()));
		//System.out.println(""+lon);
		doc.setCharacterAttributes(cosatam,lon-cosatam, text.getStyle("12"), true);
	}

	public String getShortNombre(){
		return null;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
