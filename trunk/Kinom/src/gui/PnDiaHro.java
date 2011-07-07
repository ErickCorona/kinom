package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PnDiaHro extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JLabel lblMartes;
	private JLabel lbljul_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public PnDiaHro() {
		setLayout(new MigLayout("", "[87.00][grow][grow][grow][grow][grow][grow][][]", "[][][][]"));
		
		JLabel lblLunes = new JLabel("Lunes");
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblLunes, "cell 0 0,alignx center");
		
		textField = new JTextField();
		add(textField, "cell 1 0 1 2,growx");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		add(textField_1, "cell 2 0 1 2,growx");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		add(textField_2, "cell 3 0 1 2,growx");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		add(textField_3, "cell 4 0 1 2,growx");
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		add(textField_4, "cell 5 0 1 2,growx");
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		add(textField_5, "cell 6 0 1 2,growx");
		textField_5.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		add(btnAgregar, "cell 7 0 1 2");
		
		JLabel lbljul = new JLabel("07/jul/11");
		lbljul.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbljul, "cell 0 1,alignx center");
		
		btnNewButton = new JButton("Eliminar");
		add(btnNewButton, "cell 8 0 1 2");
		
		lblMartes = new JLabel("Martes");
		lblMartes.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblMartes, "cell 0 2,alignx center");
		
		textField_6 = new JTextField();
		add(textField_6, "cell 1 2 1 2,growx");
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		add(textField_7, "cell 2 2 1 2,growx");
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		add(textField_8, "cell 3 2 1 2,growx");
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		add(textField_9, "cell 4 2 1 2,growx");
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		add(textField_10, "cell 5 2 1 2,growx");
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		add(textField_11, "cell 6 2 1 2,growx");
		textField_11.setColumns(10);
		
		btnNewButton_1 = new JButton("Agregar");
		add(btnNewButton_1, "cell 7 2 1 2");
		
		btnNewButton_2 = new JButton("Eliminar");
		add(btnNewButton_2, "cell 8 2 1 2");
		
		lbljul_1 = new JLabel("08/jul/11");
		lbljul_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbljul_1, "cell 0 3,alignx center");

	}

}
