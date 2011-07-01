package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class DgConfirmacionCambio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtTotal;
	private JTextField txtRecibido;
	private JTextField txtCambio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DgConfirmacionCambio dialog = new DgConfirmacionCambio(null, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DgConfirmacionCambio(Frame owner, boolean modal) {
		super(owner, modal);
		setBounds(100, 100, 450, 281);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblConfirmacion = new JLabel("Confirmaci\u00F3n");
				lblConfirmacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
				panel.add(lblConfirmacion);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 31, 95, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
				gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
				gbc_horizontalGlue.gridx = 0;
				gbc_horizontalGlue.gridy = 0;
				panel.add(horizontalGlue, gbc_horizontalGlue);
			}
			{
				JLabel lblPelicula = new JLabel("Pel\u00EDcula");
				lblPelicula.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblPelicula = new GridBagConstraints();
				gbc_lblPelicula.insets = new Insets(0, 0, 5, 5);
				gbc_lblPelicula.gridx = 1;
				gbc_lblPelicula.gridy = 0;
				panel.add(lblPelicula, gbc_lblPelicula);
			}
			{
				JLabel lblHora = new JLabel("Hora");
				lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblHora = new GridBagConstraints();
				gbc_lblHora.insets = new Insets(0, 0, 5, 5);
				gbc_lblHora.gridx = 3;
				gbc_lblHora.gridy = 0;
				panel.add(lblHora, gbc_lblHora);
			}
			{
				JLabel lblNumero = new JLabel("N\u00FAmero");
				lblNumero.setFont(new Font("Tahoma", Font.BOLD, 12));
				GridBagConstraints gbc_lblNumero = new GridBagConstraints();
				gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumero.gridx = 5;
				gbc_lblNumero.gridy = 0;
				panel.add(lblNumero, gbc_lblNumero);
			}
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
				gbc_horizontalGlue.insets = new Insets(0, 0, 5, 0);
				gbc_horizontalGlue.gridx = 6;
				gbc_horizontalGlue.gridy = 0;
				panel.add(horizontalGlue, gbc_horizontalGlue);
			}
			{
				textField = new JTextField();
				textField.setEditable(false);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 1;
				gbc_textField.gridy = 1;
				panel.add(textField, gbc_textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setEditable(false);
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 3;
				gbc_textField_1.gridy = 1;
				panel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setEditable(false);
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 5;
				gbc_textField_2.gridy = 1;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.gridwidth = 5;
				gbc_panel_1.insets = new Insets(0, 0, 0, 5);
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 2;
				panel.add(panel_1, gbc_panel_1);
				panel_1.setLayout(new MigLayout("", "[146.00][grow]", "[][][]"));
				{
					JLabel lblTotal = new JLabel("Total:");
					lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblTotal, "cell 0 0,alignx trailing");
				}
				{
					txtTotal = new JTextField();
					txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtTotal, "cell 1 0,alignx left");
					txtTotal.setColumns(10);
				}
				{
					JLabel lblRecibido = new JLabel("Recibido:");
					lblRecibido.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblRecibido, "cell 0 1,alignx trailing");
				}
				{
					txtRecibido = new JTextField();
					txtRecibido.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtRecibido, "cell 1 1");
					txtRecibido.setColumns(10);
				}
				{
					JLabel lblCambio = new JLabel("Cambio:");
					lblCambio.setFont(new Font("Tahoma", Font.BOLD, 16));
					panel_1.add(lblCambio, "cell 0 2,alignx trailing");
				}
				{
					txtCambio = new JTextField();
					txtCambio.setFont(new Font("Tahoma", Font.PLAIN, 16));
					panel_1.add(txtCambio, "cell 1 2");
					txtCambio.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
