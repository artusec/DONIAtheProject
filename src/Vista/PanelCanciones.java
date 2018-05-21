package Vista;

import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

/**
 * Clase que gestiona el panel de canciones.
 */
public class PanelCanciones extends PanelDePaneles<Cancion> {

	private static final long serialVersionUID = 1L;

	private String nombre = "";

	private VentanaPrincipal ventanaPrincipal;
	
	/**
	 * Constructora. Crea el panel de canciones e implementa la acción al seleccionar una fila de la lista.
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	public PanelCanciones(VentanaPrincipal ventanaPrincipal) {
		super("");
		this.ventanaPrincipal = ventanaPrincipal;
		this.actualizarNombre();
		objList.addListSelectionListener(new ListSelectionListener() {
				
	         @Override
	         public void valueChanged(ListSelectionEvent e) {
	        	 
	             if (!e.getValueIsAdjusting()) {
	                	
	                ventanaPrincipal.verPanelLetras();
	                if (objList.getSelectedValue() != null)
	                	ventanaPrincipal.setCancion(objList.getSelectedValue());
	             }
	         }
	     });
	}
	
	/**
	 * Establece la lista de canciones del panel a partir del parámetro.
	 * @param lista Lista de canciones a la cual se actualiza nuestro parametro lista.
	 */
	@Override
	public void setList(ArrayList<Cancion> lista) {
		super.setList(lista);
		this.actualizarNombre();
		if (!objList.isSelectionEmpty())
			this.objList.clearSelection();
	}

	private void actualizarNombre() {
		if (ventanaPrincipal.getListaSelecccionada() != null && !ventanaPrincipal.getListaSelecccionada().isEmpty()) {
			Lista listaSel = ventanaPrincipal.getListaSelecccionada().get(0);
			this.nombre = "Canciones de " + listaSel.getNombre();
		} else {
			nombre = "Canciones";
		}
		super.setBorder(new TitledBorder(nombre));
	}
}