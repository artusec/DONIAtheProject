package Vista;

import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Model.Objetos.Cancion;

/**
 * Clase que gestiona el panel de canciones.
 */
public class PanelCanciones extends PanelDePaneles<Cancion> {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructora. Crea el panel de canciones e implementa la acción al seleccionar una fila de la lista.
	 * @param nombre Título del Titled border.
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	public PanelCanciones(String nombre, VentanaPrincipal ventanaPrincipal) {
		
		super(nombre);
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
		if (!objList.isSelectionEmpty())
			this.objList.clearSelection();
	}
}