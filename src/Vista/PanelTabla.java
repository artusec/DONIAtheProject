package Vista;

import javax.swing.JPanel;

public class PanelTabla<T> extends JPanel
{
	private static final long serialVersionUID = 1L;
	private ModeloTabla<T> modelo;
	 
	 public PanelTabla(String bordeId, ModeloTabla<T> modelo)
	 {
		 
	 }
	 
	 public ModeloTabla<T> getModelo()
	 {
		 return modelo;
	 }
}
