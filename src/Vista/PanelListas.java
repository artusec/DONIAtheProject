package Vista;

import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controlador.ControlLista;
import Model.Objetos.Lista;

/**
 * Clase que gestiona el panel de listas.
 */
public class PanelListas extends PanelDePaneles<Lista> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal ventanaPrincipal;
	
	/**
	 * Constructora. Crea el panel de listas de reproducción e implementa la acción al seleccionar una fila de la lista.
	 * @param nombre Título del Titled border.
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	public PanelListas(String nombre, VentanaPrincipal ventanaPrincipal) {
		super(nombre);
		this.ventanaPrincipal = ventanaPrincipal;
		objList.addListSelectionListener(
			new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                		
	                		ventanaPrincipal.vaciaPanelCanciones();
	                		ventanaPrincipal.verPanelLetras();
	                		ventanaPrincipal.setLista(objList.getSelectedValue());
	                }
	            }
	        }
		);
	}
	

	/**
	 * Establece la lista de listas de reproducción del panel a partir del parámetro.
	 * @param lista  Lista de listas de reproducción a la cual se actualiza nuestro atributo lista.
	 */
	@Override
	public void setList(ArrayList<Lista> lista) {
		//mostrar siempre la biblioteca
		ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
		Lista bib = control.consulta("l0");
		if (lista != null) lista.add(0, bib);
		super.setList(lista);
		this.objList.clearSelection();
	}
}