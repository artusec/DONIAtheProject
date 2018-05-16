package Vista;

import javax.swing.JPanel;
import Model.Objetos.Cancion;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelUnTercio extends JPanel {

	private PanelAreaTexto panelDeLetra;
	private DatosCancion_panel panelDeDatos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelUnTercio(PanelAreaTexto panelDeLetra, DatosCancion_panel panelDeDatos) {
		

		this.panelDeDatos = panelDeDatos;
		this.panelDeLetra = panelDeLetra;
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDeLetra, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
						.addComponent(panelDeDatos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDeLetra, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelDeDatos, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		

	}
	
	public void setDatos(Cancion cancion) {
		
		panelDeLetra.setTexto(cancion.getLetra().getTexto());
		panelDeDatos.setDatos(cancion);
	}
	
}