package Vista;

import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controlador.ControlLista;
import Model.Objetos.Lista;

public class PanelListas extends PanelDePaneles<Lista> {

	private static final long serialVersionUID = 1L;

	private VentanaPrincipal ventanaPrincipal;
	
	public PanelListas(String nombre, VentanaPrincipal ventanaPrincipal) {
		super(nombre);
		this.ventanaPrincipal = ventanaPrincipal;
		objList.addListSelectionListener(
			new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                		ventanaPrincipal.setLista(objList.getSelectedValue());
	                }
	            }
	        }
		);
	}
	
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
