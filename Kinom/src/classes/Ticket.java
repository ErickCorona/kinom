package classes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.StreamPrintServiceFactory;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import utils.ImageUtils;

public class Ticket {

	public static final int NORMAL = 0;
	public static final int CORTESIA = 1;

	public static void main(String args[]){
		try {
			new Ticket().imprimirLogo();
		} catch (PrintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Funcion funcion;
	private double precio;
	private boolean descuento;
	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

	private int tipo;
	private String descripcion;
	private Usuario ticketero;
	
	public Ticket(){
		
	}
	
	public Ticket(Funcion funcion, Usuario ticketero) {
		this.funcion = funcion;
		this.precio = Cartelera.getPrecio();
		this.ticketero = ticketero;
		this.tipo = NORMAL;
	}
	
	public void imprimir(int id){
		//Quitar comentarios de este método para que se muestre el precio
		StringBuffer info = new StringBuffer();
		info.append("Sala ");
		info.append(funcion.getSala().getNumero());
		//info.append(" $");
		//info.append((int)precio);
		info.append("\n");
		
		info.append(funcion.getPelicula().getNombre());
		info.append("\n");
		
		SimpleDateFormat fecha_h = new SimpleDateFormat("d MMM hh:mm a");
		info.append(fecha_h.format(funcion.getHorario().getTime()));
		info.append(" Clas. ");
		info.append(funcion.getPelicula().getClasificacion()==null?"s/c":funcion.getPelicula().getClasificacion());
		info.append("\n");
		if(Cartelera.is2x1(funcion.getHorario()))
			info.append("\t- 2x1 -\n");
		info.append(ticketero.getNombre());
		info.append("\nID"+id);
		
		JTextPane text = new JTextPane();
		text.setText(info.toString());
		
		StyledDocument doc = text.getStyledDocument();
		
		Style style = text.addStyle("24", null);
		StyleConstants.setFontSize(style, 24);
		style = text.addStyle("18", null);
		StyleConstants.setFontSize(style, 18);
		style = text.addStyle("8", null);
		StyleConstants.setFontSize(style, 8);
		
		doc.setCharacterAttributes(0, 7, text.getStyle("24"), true);
		//doc.setCharacterAttributes(7, 3, text.getStyle("18"), true);
		doc.setCharacterAttributes(info.length()-ticketero.getNombre().length()-("\nID"+id).length(), ticketero.getNombre().length()+("\nID"+id).length(), text.getStyle("8"), true);
		if(info.indexOf("2x1")!=-1)
			doc.setCharacterAttributes(info.indexOf("2x1"), 3, text.getStyle("18"), true);
		
		try {
			 DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
			 String psMimeType = DocFlavor.BYTE_ARRAY.POSTSCRIPT.getMimeType();
			    StreamPrintServiceFactory[] psfactories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(
			    		flavor, psMimeType);
			 PrintRequestAttributeSet attr_set = new HashPrintRequestAttributeSet();
			 attr_set.add(MediaSize.findMedia(100, 20, MediaSize.MM)); 
			 text.print(null, null, false, null, attr_set, true);
		} catch (PrinterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
	       try{
               Printable printable = text.getPrintable(null, null);
               PrinterJob job = PrinterJob.getPrinterJob();
               job.printDialog();
               job.setPrintable(printable);
               PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
               job.print(attr);
       }catch(Exception ex){
               ex.printStackTrace();
       }*/
/*
		try{
			//Ticket.print("Imprime!");
			//new cgdgff().print("Hola!! Ya funciono");
			//cgdgff.Foo.main(null);
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
	}
	
	public static void print(JTextPane text) throws PrinterException{
		Printable printable = text.getPrintable(null, null);
		PrinterJob job = PrinterJob.getPrinterJob();
		Book book = new Book();
		PageFormat pf = new PageFormat();
		Paper pap = new Paper();
		pap.setSize(72,72);
		pf.setPaper(pap);
		book.append(printable, job.defaultPage(pf));
        job.setPageable(book);
		//PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
		job.printDialog();
		//System.out.println(job.getPrintService().getName());
		job.print(/*attr*/);
	}
	
	public static void print(String s) throws PrinterException{
		JTextPane t = new JTextPane();
		t.setText(s);
		print(t);
	}
	
	public  void imprimirLogo() throws PrintException, IOException, URISyntaxException{
		try {
			
			PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			//pras.add(new Copies(1));
			pras.add(new MediaPrintableArea(0, 0,48 , 20, MediaPrintableArea.MM));
			//pras.add(MediaSize.findMedia(50, 200, MediaSize.MM)); 

			PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
			/*
			if (pss.length == 0)
			throw new RuntimeException("No printer services available.");
			 */
			//PrintService ps = pss[0];
			System.out.println("Printing to " + ps);

			DocPrintJob job = ps.createPrintJob();
			java.net.URL imgURL = getClass().getResource("../imagen/logocinemas.jpg");
			FileInputStream fin = new FileInputStream(new File(imgURL.toURI()));
			Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.GIF, null);
			
			job.print(doc, pras);

			fin.close();
			
			
			} catch (IOException ie) {
			ie.printStackTrace();
			} catch (PrintException pe) {
			pe.printStackTrace();
			}
	    
	    
	}
	
	public Funcion getFuncion() {
		return funcion;
	}
	
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void hacerCortesia(String descripcion){
		this.descripcion = descripcion;
		this.tipo = CORTESIA;
	}
	
	public void cancelarCortesia(){
		this.descripcion = "";
		this.tipo = NORMAL;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Usuario getTicketero() {
		return ticketero;
	}
	
	public void setTicketero(Usuario ticketero) {
		this.ticketero = ticketero;
	}
	
}
