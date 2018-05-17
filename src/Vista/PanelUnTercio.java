package Vista;

import javax.swing.JPanel;
import Model.Objetos.Cancion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class PanelUnTercio extends JPanel {

	private PanelAreaTexto panelDeLetra;
	private DatosCancion_panel panelDeDatos;
	private Enlaces_panel panelDeEnlaces;
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
		this.panelDeEnlaces = null;
		
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
	
	/**
	 * @wbp.parser.constructor
	 */
	public PanelUnTercio(Enlaces_panel panelDeEnlaces, DatosCancion_panel panelDatos) {
		this.panelDeDatos = panelDatos;
		this.panelDeLetra = null;
		this.panelDeEnlaces = panelDeEnlaces;
		this.setLayout(new GridLayout(2, 1));
		this.add(panelDatos, BorderLayout.SOUTH);
		this.add(panelDeEnlaces, BorderLayout.NORTH);
	}

	public void setDatos(Cancion cancion) {
		
		panelDeDatos.setDatos(cancion);
		if (panelDeLetra != null)
			panelDeLetra.setTexto(cancion);
		if (panelDeEnlaces != null)
			panelDeEnlaces.setDatos(cancion);
	}
	
	public void vaciaElPanel() {
		
		panelDeDatos.vaciarCampos();
		if (panelDeLetra != null)
			panelDeLetra.setTexto("");
		if (panelDeEnlaces != null)
			panelDeEnlaces.vaciarCampos();
	}
}