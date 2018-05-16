package Vista;

import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlador.ControlLista;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

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
	
	@Override
	public void setList(ArrayList<Cancion> lista) {
		super.setList(lista);
		this.objList.clearSelection();
	}
}
