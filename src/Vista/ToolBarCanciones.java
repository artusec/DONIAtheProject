package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;

public class ToolBarCanciones extends JToolBar {

	private static final long serialVersionUID = 1L;

	public ToolBarCanciones(VentanaPrincipal mainWindow , ControlCancion controlCancion, ControlLista controlLista, ControlGenero controlGenero)
	{
		super();
		
		setLayout(new GridLayout(1, 4));
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Add song");
		aniadirCancion.setIcon(new ImageIcon("src\\icons\\add.png"));
		aniadirCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//controlLista.anadirCancion(/*cancion que metes*/, /*lista seleccionada*/ mainWindow.getPanelListas().getModelo().listaSel());
			}
		});
		this.add(aniadirCancion);
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Delete song from the list");
		eliminarCancion.setIcon(new ImageIcon("src\\icons\\delete.png"));
		eliminarCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controlLista.eliminarCancion(mainWindow.getPanelCanciones().getModelo().cancionSel(), mainWindow.getPanelListas().getModelo().listaSel());
			}
		});		
		this.add(eliminarCancion);
		
		
		JButton meGusta = new JButton();
		meGusta.setToolTipText("I like this song");
		meGusta.setIcon(new ImageIcon(("src\\icons\\hand.png")));
		meGusta.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				controlGenero.Anadir(mainWindow.getPanelCanciones().getModelo().cancionSel().getGenero());
			}
		 });
		this.add(meGusta);

		
		JButton verLetra = new JButton();
		verLetra.setToolTipText("See the lyrics");
		verLetra.setIcon(new ImageIcon("src\\icons\\flecha.png"));
		verLetra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.setLetra(mainWindow.getPanelCanciones().getModelo().cancionSel().toString());				
			}
		});		
		this.add(verLetra);
	}
}
