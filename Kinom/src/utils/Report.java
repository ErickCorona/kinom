package utils;

import java.io.File;
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
		semanal();
		
	}

	public static void check(){
		Calendar today = Calendar.getInstance();
		if(today.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)
			semanal();
		if(today.get(Calendar.DAY_OF_MONTH)==today.getMaximum(Calendar.DAY_OF_MONTH)-1)
			mensual();
	}
	
	public static void semanal(){
		Conexion c = new Conexion();
		try {
			File f = new File("c:\\reportes");
			f.mkdir();
			
			c.open();
			JasperPrint print = JasperFillManager.fillReport("Reportes\\Semanal.jasper", new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\semanal.pdf");
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> arc = new ArrayList<String>();
		arc.add("C:\\reportes\\semanal.pdf");
		MailService.send("Reporte Semanal","Reporte Semanal Adjunto",arc);
	}
	
	public static void mensual(){
		Conexion c = new Conexion();
		try {
			File f = new File("c:\\reportes");
			f.mkdir();
			c.open();
			JasperPrint print = JasperFillManager.fillReport("Reportes\\Mensual.jasper", new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\mensual.pdf");
			print = JasperFillManager.fillReport("Reportes\\MensualPelicula.jasper", new HashMap(), c.getConeccion());
			JasperExportManager.exportReportToPdfFile(print, "C:\\reportes\\mensualpelicula.pdf");
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ArrayList<String> arc = new ArrayList<String>();
		arc.add("C:\\reportes\\mensual.pdf");
		arc.add("C:\\reportes\\mensualpelicula.pdf");
		MailService.send("Reporte Mensual","Reporte Mensual Adjunto",arc);
	}
	
}

