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
import Controlador.ControlCancion;
import Controlador.ControlLista;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;
import net.miginfocom.swing.MigLayout;

/**
 * Clase que crea el panel que contiene los campos para borrar una canción de la base de datos.
 */
public class SongBorrarAdmin_panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelDePaneles<Cancion> panelCanciones;
	
	/**
	 * Constructora. Crea un panel con la lista de todas las canciones de la base de datos. Al pulsar el botón se borrarán las
	 * canciones seleccionadas por el usuario en la lista. Dicho botón sólo estará activo si eres el administrador.
	 * @param ventanaPrincipal
	 */
	public SongBorrarAdmin_panel(VentanaPrincipal ventanaPrincipal) {
		String titulo = "Eliminar canciones de la base de datos";
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JButton btnAadir = new JButton("Eliminar");
		
		JLabel lblNewLabel = new JLabel("");
		
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cancion> sel = panelCanciones.getSelectedItems();
				ControlCancion control = new ControlCancion(ventanaPrincipal.getUsuarioActual());
				for (Cancion c : sel) {
					control.eliminaCancion(c);
				}
			}
		});
		setLayout(new MigLayout("", "[1px][406.00px,grow]", "[1px][199.00,grow][20.00px]"));
		add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		add(btnAadir, "cell 1 2,alignx center,aligny bottom");
		
		JPanel panelLista = new JPanel();
		add(panelLista, "cell 1 1,grow");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnAadir}));
		panelCanciones = new PanelDePaneles<Cancion>("Biblioteca");
		ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
		Lista bib = control.consulta("l0");
		panelLista.setLayout(new GridLayout(0, 1, 0, 0));
		panelCanciones.setList(bib.getCanciones());
		panelLista.add(panelCanciones);
	}
}