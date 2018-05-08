package Vista;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTabla<T> extends JPanel
{
	private static final long serialVersionUID = 1L;
	private ModeloTabla<T> modelo;
	 
	 public PanelTabla(String bordeId, ModeloTabla<T> modelo)
	 {
		 setLayout(new GridLayout(1,1));
		 setBorder(BorderFactory.createTitledBorder(bordeId));
		 this.modelo = modelo;
		 JTable tabla = new JTable(this.modelo);
		 add(new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	 }
	 
	 public ModeloTabla<T> getModelo()
	 {
		 return modelo;
	 }
}
