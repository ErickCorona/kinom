package classes;

import javax.swing.ImageIcon;

public class Pelicula {
	private int id;


	private String nombre;
	private ImageIcon imagen;
	private String clasificacion;
	private int duracion;
	private String sinopsis;
	private String idioma;
	
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
			String clasificacion, int duracion, String sinopsis, String idioma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.clasificacion = clasificacion;
		this.duracion = duracion;
		this.sinopsis = sinopsis;
		this.idioma = idioma;
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
}
