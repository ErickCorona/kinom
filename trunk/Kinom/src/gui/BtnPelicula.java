package gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import utils.ImageUtils;

import classes.Funcion;
import classes.Pelicula;

public class BtnPelicula extends JToggleButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sala;
	private Pelicula peli;
	private ImageIcon imgThumb;
	
	public BtnPelicula(){
		super();
		
	}
	
	public BtnPelicula(Funcion func){
		super();

		peli = func.getPelicula();
		this.sala = func.getSala().getNumero();
		
		Image tempImage = peli.getImagen().getImage();
		BufferedImage tempBuff = new BufferedImage(tempImage.getWidth(null),tempImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = tempBuff.createGraphics();
	    g2.drawImage(tempImage, 0, 0,null);
		
		BufferedImage scaled = new BufferedImage(200, 300, BufferedImage.TYPE_INT_RGB);
		scaled = ImageUtils.getScaledInstance(tempBuff, 200, 300, RenderingHints.VALUE_INTERPOLATION_BILINEAR,true);
		
		
		//Graphics2D g2 = scaled.createGraphics();
		//g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                //RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		//g2.drawImage(tempImage, 0,0,200,300,null);
		
		imgThumb = new ImageIcon(scaled);
		
		setIcon(imgThumb);
		setText("");
		
	}
	
	public void upImage(){
		Image tempImage = peli.getImagen().getImage(); //Obtemeos el objeto imagen del ImageIcon 
		//Creamos un buffered para contenerlo
		BufferedImage tempBuff = new BufferedImage(tempImage.getWidth(null),tempImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = tempBuff.createGraphics();
	    g2.drawImage(tempImage, 0, 0,null);//Lo escrimos
		int h = (int) (this.getHeight()* (.5));
		int w = (int) (this.getWidth()* (.5));
		BufferedImage scaled = new BufferedImage(w,h , BufferedImage.TYPE_INT_RGB);
		scaled = ImageUtils.getScaledInstance(tempBuff,w,h, RenderingHints.VALUE_INTERPOLATION_BILINEAR,true);
		this.imgThumb = new ImageIcon(scaled);
		setIcon(imgThumb);
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public Pelicula getPeli() {
		return peli;
	}

	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}

}
