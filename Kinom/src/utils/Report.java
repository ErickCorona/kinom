package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import bd.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

public class Report {
	
	public static void main(String args[]){
		check();
	}

	public static void check(){
		Calendar today = Calendar.getInstance();
		Calendar archs = Calendar.getInstance();
		Calendar archm = Calendar.getInstance();
		DateFormat df = DateFormat.getInstance();
		try {
			archs.setTime(df.parse(readDate("semanal")));
		} catch (Exception e) {
			archs.set(Calendar.DATE, archs.get(Calendar.DATE)-1);
		}
		try {
			archm.setTime(df.parse(readDate("mensual")));
		} catch (Exception e) {
			archm.set(Calendar.DATE, archm.get(Calendar.DATE)-1);
		}
		if(today.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY && today.get(Calendar.DAY_OF_YEAR)!=archs.get(Calendar.DAY_OF_YEAR))
			semanal();
		if(today.get(Calendar.DAY_OF_MONTH)==1 && today.get(Calendar.DAY_OF_YEAR)!=archm.get(Calendar.DAY_OF_YEAR))
			mensual();
	}
	
	public static void diario(String dir){
		Report r = new Report();
		Conexion c = new Conexion();
		try {
			String ruta = r.getClass().getResource("../").toURI().getPath()+"../Reportes/diario.jasper";
			
			c.open();
			JasperPrint print = JasperFillManager.fillReport(ruta, new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, dir);
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void semanal(){
		Report r = new Report();
		Conexion c = new Conexion();
		try {
			String ruta = r.getClass().getResource("../").toURI().getPath()+"../Reportes/Semanal.jasper";
			File f = new File("C:\\reportes");
			f.mkdirs();
			
			c.open();
			JasperPrint print = JasperFillManager.fillReport(ruta, new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\semanal.pdf");
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> arc = new ArrayList<String>();
		arc.add("C:\\reportes\\semanal.pdf");
		MailService.send("Reporte Semanal","Reporte Semanal Adjunto",arc);
		File f = new File("c:\\reportes\\semanal.pdf");
		f.delete();
		writeDate("semanal");
	}
	
	public static void mensual(){
		Report r = new Report();
		Conexion c = new Conexion();
		try {
			String ruta = r.getClass().getResource("../").toURI().getPath()+"../Reportes/Mensual.jasper";
			File f = new File("c:\\reportes");
			f.mkdirs();
			c.open();
			
			JasperPrint print = JasperFillManager.fillReport(ruta, new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\mensual.pdf");
			ruta = r.getClass().getResource("../").toURI().getPath()+"../Reportes/MensualPelicula.jasper";
			
			print = JasperFillManager.fillReport(ruta, new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\mensualpelicula.pdf");
			ruta = r.getClass().getResource("../").toURI().getPath()+"../Reportes/MensualporSemana.jasper";
			
			print = JasperFillManager.fillReport(ruta, new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\MensualporSemana.pdf");
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> arc = new ArrayList<String>();
		arc.add("C:\\reportes\\mensual.pdf");
		arc.add("C:\\reportes\\mensualpelicula.pdf");
		arc.add("C:\\reportes\\MensualporSemana.pdf");
		MailService.send("Reporte Mensual","Reporte Mensual Adjunto",arc);
		File f = new File("c:\\reportes\\mensual.pdf");
		f.delete();
		f = new File("c:\\reportes\\mensualpelicula.pdf");
		f.delete();
		f = new File("c:\\reportes\\MensualporSemana.pdf");
		f.delete();
		writeDate("mensual");
	}
	
	public static void writeDate(String r){
		File f = new File(r);
		if(f.exists())
			f.delete();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(DateFormat.getInstance().format(Calendar.getInstance().getTime()));
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readDate(String r){
		File f = new File(r);
		String res = null;
		if(!f.exists())
			return res;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			res = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}

