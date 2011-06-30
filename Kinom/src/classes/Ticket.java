package classes;

import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JTextPane;
import javax.swing.text.*;

public class Ticket {

	public static final int NORMAL = 0;
	public static final int CORTESIA = 1;
	
	private Funcion funcion;
	private double precio;
	private int tipo;
	private String descripcion;
	private Usuario ticketero;
	
	public Ticket(Funcion funcion, Usuario ticketero) {
		this.funcion = funcion;
		this.precio = Cartelera.getPrecio();
		this.ticketero = ticketero;
		this.tipo = NORMAL;
	}
	
	public void imprimir(){
		StringBuffer info = new StringBuffer();
		info.append("Sala ");
		info.append(funcion.getSala().getNumero());
		info.append(" $");
		info.append((int)precio);
		info.append("\n");
		
		info.append(funcion.getPelicula().getNombre());
		info.append("\n");
		
		SimpleDateFormat fecha_h = new SimpleDateFormat("d MMM hh:mm");
		info.append(fecha_h.format(funcion.getHorario().getTime()));
		info.append(" Clas. ");
		info.append(funcion.getPelicula().getClasificacion()==null?"s/c":funcion.getPelicula().getClasificacion());
		info.append("\n");
		if(Cartelera.is2x1(funcion.getHorario()))
			info.append("\t- 2x1 -\n");
		info.append(ticketero.getNombre());
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
		doc.setCharacterAttributes(7, 3, text.getStyle("18"), true);
		doc.setCharacterAttributes(info.length()-ticketero.getNombre().length(), ticketero.getNombre().length(), text.getStyle("8"), true);
		try{
			Printable printable = text.getPrintable(null, null);
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(printable);
			PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
			/*boolean printAccepted = job.printDialog(attr);
			if(printAccepted)*/
				job.print(attr);
		}catch(Exception ex){
			ex.printStackTrace();
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
