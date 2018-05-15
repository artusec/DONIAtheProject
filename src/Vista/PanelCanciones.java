package Vista;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Objetos.Cancion;

public class PanelCanciones extends PanelDePaneles<Cancion> {

	private static final long serialVersionUID = 1L;

	public PanelCanciones(String nombre, VentanaPrincipal ventanaPrincipal) {
		super(nombre);
		objList.addListSelectionListener(
			new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                		ventanaPrincipal.setCancion(objList.getSelectedValue());
	                }
	            }
	        }
		);
	}
}