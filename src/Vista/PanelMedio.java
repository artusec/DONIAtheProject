package Vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelMedio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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