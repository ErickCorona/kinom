package gui;

import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

public class PnHorario extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnHorario(Calendar fecha) {
		setBorder(new TitledBorder(null, "Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		llenar(fecha);
		
		
	}
	
	public void llenar(Calendar fecha){
		for(int i=0; i< 7; i++){
			pnDiaHorario pnHorario = new pnDiaHorario(fecha);
			this.add(pnHorario);
			fecha.add(Calendar.DAY_OF_YEAR, 1);
		}
		
	}

}
