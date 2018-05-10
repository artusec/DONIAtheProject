package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Controlador.ControlCancion;
import Controlador.ControlLista;

public class ToolBarCanciones extends JToolBar {

	private static final long serialVersionUID = 1L;

	public ToolBarCanciones(VentanaPrincipal mainWindow , ControlCancion controlCancion, ControlLista controlLista)
	{
		super();
		
		setLayout(new GridLayout(1, 4));
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Add song");
		aniadirCancion.setIcon(new ImageIcon("src\\icons\\add.png"));
		aniadirCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
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
				
			}
		 });
		this.add(meGusta);

		
		JButton verLetra = new JButton();
		verLetra.setToolTipText("See the lyrics");
		verLetra.setIcon(new ImageIcon("src\\icons\\flecha.png"));
		verLetra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Falta hacer cositas
				mainWindow.getPanelCanciones().getModelo().cancionSel();
				
				
			}
		});		
		this.add(verLetra);
	}
}
