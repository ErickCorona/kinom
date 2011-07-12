package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import classes.Funcion;
import classes.Pelicula;
import classes.Sala;
import classes.Ticket;
import classes.Usuario;

import utils.cgdgff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class Impresion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Impresion frame = new Impresion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Impresion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cgdgff.Foo.imprimir();

				Funcion fun= new Funcion(new Pelicula("2"));
				fun.setSala(new Sala(1,100));
				fun.setHorario(Calendar.getInstance());
				DgConfirmacionCambio dialog = new DgConfirmacionCambio(null, false, 1, new Ticket(fun, new Usuario("Algo ", "Algo")));
			}
		});
		contentPane.add(btnImprimir, BorderLayout.CENTER);
	}

}
