package Vista;

import javax.swing.JPanel;
import Model.Objetos.Cancion;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Clase que gestiona el panel que contiene el panel de letras y el panel de información de una canción.
 */
public class PanelUnTercio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelAreaTexto panelDeLetra;
	private DatosCancion_panel panelDeDatos;
	private Enlaces_panel panelDeEnlaces;
	

	/**
	 * Constructora. Crea el panel.
	 * @param panelDeLetra Panel con la letra de una canción.
	 * @param panelDeDatos Panel con los datos principales de una canción.
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
		panelDeDatos.verBoton();

	}
	
	/**
	 * 
	 * @param panelDeEnlaces Panel con los enlaces al video y de descarga.
	 * @param panelDatos Panel con los datos principales de una canción.
	 */
	public PanelUnTercio(Enlaces_panel panelDeEnlaces, DatosCancion_panel panelDatos) {
		
		this.panelDeDatos = panelDatos;
		this.panelDeLetra = null;
		this.panelDeEnlaces = panelDeEnlaces;
		this.setLayout(new GridLayout(2, 1));
		this.add(panelDeEnlaces, BorderLayout.NORTH);
		panelDeDatos.ocultarBoton();
		this.add(panelDatos, BorderLayout.SOUTH);
	}

	/**
	 * Establece la letra y los datos de la cancion en sus respectivos campos.
	 * @param cancion Canción que contiene los datos con los que se rellenan los campos. 
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	public void setDatos(Cancion cancion, VentanaPrincipal ventanaPrincipal) {
		
		panelDeDatos.setDatos(cancion);
		if (panelDeLetra != null)
			panelDeLetra.setTexto(cancion, ventanaPrincipal);
		if (panelDeEnlaces != null)
			panelDeEnlaces.setDatos(cancion, ventanaPrincipal);
	}
	
	/**
	 * Vacía los campos del panel.
	 */
	public void vaciaElPanel() {
		
		panelDeDatos.vaciarCampos();
		if (panelDeLetra != null)
			panelDeLetra.setTexto("");
		if (panelDeEnlaces != null)
			panelDeEnlaces.vaciarCampos();
	}
}