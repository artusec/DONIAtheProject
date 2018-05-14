package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Controlador.ControlLista;
import Model.Objetos.Lista;

public class ToolBarListas extends JToolBar {

	private static final long serialVersionUID = 1L;

	public ToolBarListas(VentanaPrincipal ventanaPrincipal)
	{
		super();
		
		setLayout(new GridLayout(1, 3));
		
		JButton nuevLista = new JButton();
		nuevLista.setToolTipText("Crea una nueva lista vacia");
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
		eliminarLista.setIcon(new ImageIcon(("src/icons/delete.png")));
		eliminarLista.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Lista> aux =  ventanaPrincipal.getPanelListas().getSelectedItems();
				Lista selec = aux.get(0);

				if (selec != null) {
					ControlLista controlador = new ControlLista(ventanaPrincipal.getUsuarioActual());
					controlador.eliminar(selec);
					ventanaPrincipal.cargaListas();
				}
			}
		 });
		
		this.add(eliminarLista);
		
		JButton listaAuto = new JButton();
		listaAuto.setToolTipText("Crea una lista de forma automatica");
		listaAuto.setIcon(new ImageIcon(("src/icons/auto.png")));
		listaAuto.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.verCrearListaAuto();
			}
		 });
		
		this.add(listaAuto);
	}
}
