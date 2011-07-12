package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import javax.swing.JTextPane;

import classes.Cartelera;

import com.lowagie.text.pdf.Barcode;

public class cgdgff {
	
	public  void print(JTextPane text) throws PrinterException{
		Printable printable = text.getPrintable(null, null);
		PrinterJob job = PrinterJob.getPrinterJob();
		Book book = new Book();
		book.append(printable, job.defaultPage());
        job.setPageable(book);
		//PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
		if(job.printDialog())
		//System.out.println(job.getPrintService().getName());
		job.print(/*attr*/);
	}
	
	public  void print(String s) throws PrinterException{
		JTextPane t = new JTextPane();
		t.setText(s);
		print(t);
	}



	private static BufferedWriter salida;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cgdgff.Foo.imprimir();
	}

	
     
	    public static class Foo{
	    	public Foo(){
	    		
	    	}
	    	
	    	public static void main(String args[]){
	    		imprimir();
	    	}
	    	
	    	public static void imprimir(){
	    		try {
	    			new cgdgff().print("hello!");
	    		} catch (PrinterException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	}
	    }
  
}