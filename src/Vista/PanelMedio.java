package Vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelMedio extends JPanel {

	/**
	 * Create the panel.
	 * @param panelCanciones 
	 * @param barCanciones 
	 */
	public PanelMedio(ToolBarCanciones barCanciones, PanelCanciones panelCanciones) {
		
		
		
		this.setLayout(new BorderLayout());
		panelCanciones.setAutoscrolls(true);
		this.add(panelCanciones);
		barCanciones.setFloatable(false);
		this.add(barCanciones, BorderLayout.SOUTH);
	}

}
