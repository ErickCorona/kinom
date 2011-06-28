package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion{
	
	private String host;
	private String user;
	private String pass;
	private String database;
	private Connection conn;
	private boolean enabled;
	
	public Conexion(){
		this.host="localhost";
		this.user="root";
		this.pass="pass";
		this.database="kinom";
	}
	
	public Conexion(String user, String pass, String database){
		this.user = user;
		this.pass = pass;
		this.database = database;
	}
	
	private void open() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		String urljdbc = "jdbc:sqlite:bin\\bd\\" + this.database + ".sqlite";
		this.conn = DriverManager.getConnection(urljdbc);
		enabled = true;
	}
	
	public void close() throws SQLException{
		this.conn.close();
		enabled = false;
	}
	
	public ResultSet executeQ(String consulta) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery(consulta);
		
		return rs;
	}
	
	public ResultSet selectSpecificRecs(String nomTab, String filtro) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM "+nomTab+" WHERE " + filtro);
		
		return rs;
	}
	
	public ResultSet selectSpecificField(String campo, String nomTab, String filtro) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT "+campo+" FROM "+nomTab+" WHERE " + filtro);
	
		return rs;
	}
	
	public ResultSet selectField(String campo, String nomTab) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT "+campo+" FROM "+nomTab);
	
		return rs;
	}
	
	public ResultSet selectInOrder(String nomTab, String orden) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + nomTab+ " ORDER BY "+ orden);
	
		
		return rs;
	}
	
	public ResultSet select(String nomTab) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM " + nomTab);
	
		return rs;
	}
	
	public void executeU(String sentencia) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		stm.executeUpdate(sentencia);
		
	}
	
	public int recCount(String nombreTabla) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		ResultSet rs = this.executeQ("SELECT COUNT(*) FROM " + nombreTabla);
		rs.next();
		int count = rs.getInt(1);
		
		return count;
	}
	
	public void insert(String tabla, String valores) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		String consulta = "INSERT INTO "+tabla+" VALUES ("+valores+");";
		stm.executeUpdate(consulta);
	}
	
	public void delete(String tabla,String condicion) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		String consulta = "DELETE FROM "+tabla+" WHERE "+condicion;
		stm.executeUpdate(consulta);
	}
	
	public void update(String tabla,String valores,String condicion) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		String updte = "UPDATE "+tabla+" SET "+valores+" WHERE "+condicion;
		stm.executeUpdate(updte);
	}
	
	public int getLasID() throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID()");
		rs.next();
		int last = rs.getInt(1);
		
		return last;
	}
	
	public int getLasID(String tabla) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ID() FROM " + tabla);
		rs.next();
		int last = rs.getInt(1); 
		
		return last;
	}
	
	public void reset() throws SQLException{
		this.conn.setAutoCommit(true);
		
	}
	
	public Connection getConeccion(){
		return this.conn;
	}

}
