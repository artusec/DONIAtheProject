package Vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import Controlador.ControlLista;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;
import net.miginfocom.swing.MigLayout;

/**
 * Clase que crea el panel que contiene los campos para añadir una cancion a la base de datos.
 */
public class AniadirCancionALista extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDePaneles<Cancion> panelCanciones;
	private Lista listaSel = null;
	
	/**
	 * Constructora. Crea el panel.
	 * @param ventanaPrincipal
	 */
	public AniadirCancionALista(VentanaPrincipal ventanaPrincipal) {
		ArrayList<Lista> listas = ventanaPrincipal.getListaSelecccionada();
		if (listas != null && !listas.isEmpty()) {
			listaSel = listas.get(0);
		}
		
		String titulo;
		String aviso;
		if (listaSel == null){
			titulo = "No hay lista seleccionada";
			aviso = "Selecciona primero una lista";
		} else if (listaSel.getId().equals("l0")){
			titulo = "No hay lista seleccionada";
			aviso = "No se puede modificar la biblioteca";
		} else {
			titulo = "A\u00F1adir canciones a la lista " + listaSel.getNombre();
			aviso = "";
		}
			
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton botonAnadir = new JButton("A\u00F1adir");
		
		botonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cancion> sel = panelCanciones.getSelectedItems();
				if (sel != null && !sel.isEmpty() && listaSel != null) {
					ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
					for (Cancion c : sel) {
						control.anadirCancion(c, listaSel);
					}
				}
			}
		});
		setLayout(new MigLayout("", "[1px][406.00px,grow]", "[1px][199.00,grow][20.00px]"));
		
		JLabel lblNewLabel = new JLabel(aviso);
		add(lblNewLabel, "cell 1 0,alignx center,aligny top");
		add(botonAnadir, "cell 1 2,alignx center,aligny bottom");
		
		// ---------------- panel con la lista de canciones
		JPanel panelLista = new JPanel();
		add(panelLista, "cell 1 1,grow");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{botonAnadir}));
		panelCanciones = new PanelDePaneles<Cancion>("Biblioteca");
		ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
		Lista bib = control.consulta("l0");
		panelLista.setLayout(new GridLayout(0, 1, 0, 0));
		panelCanciones.setList(bib.getCanciones());
		panelLista.add(panelCanciones);
		
		if (listaSel == null || listaSel.getId().equals("l0")) botonAnadir.setEnabled(false);
		else botonAnadir.setEnabled(true);	
	}
}
