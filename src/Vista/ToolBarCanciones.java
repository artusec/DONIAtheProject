package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

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
		aniadirCancion.setText("Añadir cancion");
		aniadirCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		aniadirCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		aniadirCancion.setIcon(new ImageIcon("src/icons/add.png"));
		aniadirCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.verAniadirCancionALista();
			}
		});
		this.add(aniadirCancion);
		
		JButton eliminarCancion = new JButton();

		eliminarCancion.setToolTipText("Borra una cancion de la lista");
		eliminarCancion.setText("Borrar cancion");
		eliminarCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		eliminarCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
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
		meGusta.setToolTipText("Añadir el genero de la cancion a tus gustos");
		meGusta.setText("Me gusta!");
		meGusta.setHorizontalTextPosition( SwingConstants.CENTER );
		meGusta.setVerticalTextPosition( SwingConstants.BOTTOM );
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
		
		JButton verLetra = new JButton();
		verLetra.setToolTipText("Ver la letra de la cancion");
		verLetra.setText("Ver letra");
		verLetra.setHorizontalTextPosition( SwingConstants.CENTER );
		verLetra.setVerticalTextPosition( SwingConstants.BOTTOM );
		verLetra.setIcon(new ImageIcon("src/icons/VerLetra.png"));
		verLetra.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.verPanelLetras();
				//establece la cancion a la seleccionada
				mainWindow.setCancion();
			}
		 });
		this.add(verLetra);
	}
}
