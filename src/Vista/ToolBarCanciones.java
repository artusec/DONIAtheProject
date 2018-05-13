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
		eliminarCancion.setToolTipText("Borra una cancion de la lista");
		eliminarCancion.setIcon(new ImageIcon("src/icons/delete.png"));
		eliminarCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controlLista.eliminarCancion(mainWindow.getPanelCanciones().getModelo().cancionSel(), mainWindow.getPanelListas().getModelo().listaSel());
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
				controlGenero.Anadir(mainWindow.getPanelCanciones().getModelo().cancionSel().getGenero());
			}
		 });
		this.add(meGusta);

		
		JButton verLetra = new JButton();
		verLetra.setToolTipText("Ver letra");
		verLetra.setIcon(new ImageIcon("src/icons/flecha.png"));
		verLetra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.verPanelLetras();
			}
		});		
		this.add(verLetra);
	}
}
