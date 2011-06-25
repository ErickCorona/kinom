package classes;

public class Usuario {
	
	public static final int TICKETERO = 0;
	public static final int ADMINISTRADOR = 1;
	public static final int SUPER_ADMINISTADOR = 2;

	private String user;
	private String password;
	private String nombre;
	private int tipo;
	
	public Usuario(String user, String password, String nombre, int tipo) {
		super();
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public Usuario(String user, String password, int tipo) {
		super();
		this.user = user;
		this.password = password;
		this.tipo = tipo;
	}

	public Usuario(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
