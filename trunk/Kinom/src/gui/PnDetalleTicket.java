package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import classes.Funcion;
import classes.Sala;
import classes.Ticket;
import classes.Usuario;
import javax.swing.ListSelectionModel;

public class PnDetalleTicket extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JList lstHorarios;
	private JButton btnCancelar;
	private JButton btnImprimir;
	
	/**
	 * Create the panel.
	 */
	public PnDetalleTicket() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 119, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 312, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDetallesDeVental = new JLabel("Detalles de Venta");
		lblDetallesDeVental.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblDetallesDeVental = new GridBagConstraints();
		gbc_lblDetallesDeVental.insets = new Insets(0, 0, 5, 5);
		gbc_lblDetallesDeVental.gridwidth = 2;
		gbc_lblDetallesDeVental.gridx = 1;
		gbc_lblDetallesDeVental.gridy = 0;
		add(lblDetallesDeVental, gbc_lblDetallesDeVental);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue_1 = new GridBagConstraints();
		gbc_horizontalGlue_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue_1.gridx = 0;
		gbc_horizontalGlue_1.gridy = 1;
		add(horizontalGlue_1, gbc_horizontalGlue_1);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.EAST;
		gbc_lblNumero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumero.gridx = 1;
		gbc_lblNumero.gridy = 2;
		add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumero.fill = GridBagConstraints.BOTH;
		gbc_txtNumero.gridx = 2;
		gbc_txtNumero.gridy = 2;
		add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalGlue.gridx = 3;
		gbc_horizontalGlue.gridy = 2;
		add(horizontalGlue, gbc_horizontalGlue);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 3;
		add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblHorario = new JLabel("Horarios:");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHorario = new GridBagConstraints();
		gbc_lblHorario.insets = new Insets(0, 0, 5, 5);
		gbc_lblHorario.gridwidth = 2;
		gbc_lblHorario.gridx = 1;
		gbc_lblHorario.gridy = 4;
		add(lblHorario, gbc_lblHorario);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		lstHorarios = new JList();
		lstHorarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstHorarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(lstHorarios);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnImprimir = new GridBagConstraints();
		gbc_btnImprimir.fill = GridBagConstraints.BOTH;
		gbc_btnImprimir.gridwidth = 2;
		gbc_btnImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimir.gridx = 1;
		gbc_btnImprimir.gridy = 6;
		btnImprimir.addActionListener(this);
		btnImprimir.setActionCommand("print");
		add(btnImprimir, gbc_btnImprimir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 1;
		gbc_btnCancelar.gridy = 7;
		btnCancelar.setActionCommand("cancel");
		add(btnCancelar, gbc_btnCancelar);

	}
	
	public void llenar(ArrayList<Funcion> funciones){
		/*
		Object[] horas = new String[20];		
		SimpleDateFormat fecha_h = new SimpleDateFormat("h:mm a");
		int ocu;
		for(int i=0;i<funciones.size();i++){
			ocu=100-(funciones.get(i).getOcupados());
			horas[i]=fecha_h.format(funciones.get(i).getHorario().getTime())+"  Disp: "+ ocu;
			System.out.println(horas[i]);
		}
		DefaultComboBoxModel model1 = new DefaultComboBoxModel(horas);
		*/
		DefaultComboBoxModel model = new DefaultComboBoxModel(funciones.toArray());
		lstHorarios.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("print")){
			if(lstHorarios.getSelectedIndex()==-1)
				lstHorarios.setSelectedIndex(0);
			int total;
			if(txtNumero.getText().equals("")){
				total = 1;
				txtNumero.setText("1");
				btnImprimir.doClick();
				
			}
			else
				try{
					total = Integer.parseInt(txtNumero.getText());
					if(((Funcion)lstHorarios.getSelectedValue()).getLibres()>=total){
						Ticket tick = new Ticket((Funcion)lstHorarios.getSelectedValue(),((FrmVentaTicket)this.getParent().getParent().getParent().getParent()).getUser());
						new DgConfirmacionCambio((Frame)this.getParent().getParent().getParent().getParent(),true, total, tick);
						btnCancelar.doClick();
					}
					else{
						JOptionPane.showMessageDialog(this, "No hay tantos boletos disponibles");
					}
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(this, "No es valido ese numero de tickets");
					txtNumero.setText("");
				}
		}
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	
}
