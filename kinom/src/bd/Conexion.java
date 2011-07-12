package bd;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import org.sqlite.SQLite;

import classes.Pelicula;

import utils.ImageUtils;


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
	
	public void open() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		String urljdbc = "jdbc:sqlite:src\\bd\\" + this.database + ".sqlite";
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
		String ste = "SELECT * FROM "+nomTab+" WHERE " + filtro;
		//System.out.println(ste);
		ResultSet rs = stm.executeQuery(ste);
		
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
		//System.out.println(consulta);
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
		//System.out.println(updte);
		stm.executeUpdate(updte);
	}
	
	public int getLasID() throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ROWID()");
		rs.next();
		int last = rs.getInt(1);
		
		return last;
	}
	
	public int getLasID(String tabla) throws SQLException, ClassNotFoundException{
		if(!enabled)
			open();
		Statement stm = this.conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT LAST_INSERT_ROWID() FROM " + tabla);
		rs.next();
		int last = rs.getInt(1); 
		return last;
	}
	
	public void GuardaPelicula(File file1,  String nombre, String clas, String dura, String sino, String idio) throws Exception
	{
		if(!enabled)
			open();
		FileInputStream fis = null;
        PreparedStatement ps = null;
       	fis = new FileInputStream(file1);
		System.out.println("Ya entre1");
		System.out.println(file1.getAbsolutePath());
		ps = conn.prepareStatement("INSERT INTO peliculas(id_pel,nom_pel, img_pel, clas_pel, dur_pel, sin_pel, idm_pel,stus_pel) VALUES (null , ?, ?, ?, ?, ?, ?,?)");
        System.out.println("Ya entre2");
		ps.setString(1, nombre);
		ps.setBytes(2,ImageUtils.getBytesFromFile(file1) );
        ps.setString(3, clas);
        ps.setString(4, dura);
        ps.setString(5, sino);
        ps.setString(6, idio);
        ps.setInt(7, 1);
        ps.executeUpdate();
        ps.close();
		fis.close();
               
	}
	
	public void ModificaPelicula(int idpel,File file1,  String nombre, String clas, String dura, String sino, String idio) throws Exception
	{
		if(!enabled)
			open();
		FileInputStream fis = null;
        PreparedStatement ps = null;
        if(file1!=null){
	       	fis = new FileInputStream(file1);
			System.out.println("Ya entre1 Modificar");		
			ps = conn.prepareStatement("UPDATE peliculas SET nom_pel=? ,img_pel=?,clas_pel=?,dur_pel=?,sin_pel=?, idm_pel=? WHERE id_pel = "+idpel);
	        System.out.println("Ya entre2 Modificar");
			ps.setString(1, nombre);
			ps.setBytes(2,ImageUtils.getBytesFromFile(file1) );
	        ps.setString(3, clas);
	        ps.setString(4, dura);
	        ps.setString(5, sino);
	        ps.setString(6, idio);
	        ps.executeUpdate();
	        ps.close();
			fis.close();
	    }
        else{
			System.out.println("Ya entre1 Modificar2");		
			ps = conn.prepareStatement("UPDATE peliculas SET nom_pel=? ,clas_pel=?,dur_pel=?,sin_pel=?, idm_pel=? WHERE id_pel = "+idpel);
	        System.out.println("Ya entre2 Modificar");
			ps.setString(1, nombre);
	        ps.setString(2, clas);
	        ps.setString(3, dura);
	        ps.setString(4, sino);
	        ps.setString(5, idio);
	        ps.executeUpdate();
	        ps.close();
        }
               
	}
	
	public void EliminarPelicula(Pelicula pel) throws Exception
	{
		if(!enabled)
			open();
		System.out.println("Eliminar");		
        PreparedStatement ps = null;
        ps = conn.prepareStatement("UPDATE peliculas SET stus_pel=0  WHERE id_pel = "+pel.getId());
        pel.setStatus(0);
		ps.executeUpdate();
        ps.close();
	}
	
	public void reset() throws SQLException{
		this.conn.setAutoCommit(true);
		
	}
	
	public Connection getConeccion(){
		return this.conn;
	}

}
