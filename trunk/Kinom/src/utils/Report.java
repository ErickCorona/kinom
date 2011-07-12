package utils;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import bd.Conexion;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;

public class Report {
	
	public static void main(String args[]){
		mensual();
	}

	public static void check(){
		Calendar today = Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)
			semanal();
		if(today.get(Calendar.DAY_OF_MONTH)==today.getMaximum(Calendar.DAY_OF_MONTH)-1)
			mensual();
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
	}
	
}

