package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

public class ToolBarCanciones extends JToolBar {

	private static final long serialVersionUID = 1L;

	public ToolBarCanciones(VentanaPrincipal mainWindow)
	{
		super();
		
		setLayout(new GridLayout(1, 4));
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Añade una cancion");
		aniadirCancion.setIcon(new ImageIcon("src/icons/add.png"));
		aniadirCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.verAniadirCancionALista();
			}
		});
		this.add(aniadirCancion);
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Borra canciones seleccionadas de las listas seleccionadas");
		eliminarCancion.setIcon(new ImageIcon("src/icons/delete.png"));
		eliminarCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Cancion> selC = mainWindow.getCancionSelecccionada();
				ArrayList<Lista> selL = mainWindow.getListaSelecccionada();
				if (selC != null && !selC.isEmpty() && selL != null && !selL.isEmpty() ) {
					for (Cancion c : selC) {
						for (Lista l : selL) {
							ControlLista control = new ControlLista(mainWindow.getUsuarioActual());
							control.eliminarCancion(c, l);
						}
					}
				}
			}
		});		
		this.add(eliminarCancion);
		
		
		JButton meGusta = new JButton();
		meGusta.setToolTipText("Me gusta!");
		meGusta.setIcon(new ImageIcon(("src/icons/hand.png")));
		meGusta.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cancion> sel = mainWindow.getCancionSelecccionada();
				if (sel != null && !sel.isEmpty()) {
					for (Cancion c : sel) {
						ControlGenero control = new ControlGenero(mainWindow.getUsuarioActual());
						control.Anadir(c.getGenero());
					}
				}
			}
		 });
		this.add(meGusta);
		
		/*JButton verLetra = new JButton(); ESTO ES COSA CUTRE DEL PASADO!!
		verLetra.setToolTipText("Ver letra");
		verLetra.setIcon(new ImageIcon("src/icons/flecha.png"));
		verLetra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.verPanelLetras();
			}
		});		
		this.add(verLetra);*/
	}
}
