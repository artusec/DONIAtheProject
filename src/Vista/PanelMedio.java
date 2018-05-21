package Vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * Panel que ocupa la posición central de la ventana principal. Contiene una lista de canciones y una barra de tareas.
 */
public class PanelMedio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param panelCanciones Panel con las canciones de una lista de reproducción.
	 * @param barCanciones ToolBar con las operaciones disponibles para canciones.
	 */
	public PanelMedio(ToolBarCanciones barCanciones, PanelCanciones panelCanciones) {
		
		this.setLayout(new BorderLayout());
		panelCanciones.setAutoscrolls(true);
		this.add(panelCanciones);
		barCanciones.setFloatable(false);
		this.add(barCanciones, BorderLayout.SOUTH);
	}
}