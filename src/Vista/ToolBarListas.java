package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import Controlador.ControlLista;
import Model.Objetos.Lista;

public class ToolBarListas extends JToolBar {

	private static final long serialVersionUID = 1L;

	
	/**
	 * Crea y añade una barra herramientas con funciones sobre las listas a la ventana principal.
	 * @param mainWindow Ventana principal a la qeu se añade la barra de herramientas sobre listas.
	 */
	public ToolBarListas(VentanaPrincipal ventanaPrincipal){
		super();
		
		setLayout(new GridLayout(1, 3));
		
		JButton nuevLista = new JButton();
		nuevLista.setToolTipText("Crea una nueva lista vacia");
		nuevLista.setText("Nueva lista");
		nuevLista.setHorizontalTextPosition( SwingConstants.CENTER );
		nuevLista.setVerticalTextPosition( SwingConstants.BOTTOM );
		nuevLista.setIcon(new ImageIcon(("src/icons/add.png")));
		nuevLista.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.verCrearLista();
			}
		 });
		
		this.add(nuevLista);
		
		
		JButton eliminarLista = new JButton();
		eliminarLista.setToolTipText("Borra una lista");
		eliminarLista.setText("Borrar lista");
		eliminarLista.setHorizontalTextPosition( SwingConstants.CENTER );
		eliminarLista.setVerticalTextPosition( SwingConstants.BOTTOM );
		eliminarLista.setIcon(new ImageIcon(("src/icons/delete.png")));
		eliminarLista.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					ArrayList<Lista> listas =  ventanaPrincipal.getListaSelecccionada();
					if (listas != null && !listas.isEmpty()) {
						for (Lista l : listas) {
							ControlLista controlador = new ControlLista(ventanaPrincipal.getUsuarioActual());
							controlador.eliminar(l);
						}
					}
				}
			}
		);
		
		this.add(eliminarLista);
		
		JButton listaAuto = new JButton();
		listaAuto.setToolTipText("Crea una lista de forma automatica");
		listaAuto.setText("Lista automatica");
		listaAuto.setHorizontalTextPosition( SwingConstants.CENTER );
		listaAuto.setVerticalTextPosition( SwingConstants.BOTTOM );
		listaAuto.setIcon(new ImageIcon(("src/icons/auto.png")));
		listaAuto.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.verCrearListaAuto();
			}
		 });
		
		this.add(listaAuto);
		
		JButton cambiarNombre = new JButton();
		cambiarNombre.setToolTipText("Modificar el nombre de la lista seleccionada");
		cambiarNombre.setText("Cambiar nombre");
		cambiarNombre.setHorizontalTextPosition( SwingConstants.CENTER );
		cambiarNombre.setVerticalTextPosition( SwingConstants.BOTTOM );
		cambiarNombre.setIcon(new ImageIcon(("src/icons/modificarCancion.png")));
		cambiarNombre.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.verModificarLista();
			}
		 });
		this.add(cambiarNombre);
	}
}
