package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarCanciones extends JToolBar implements ObservadorAplicacion {

	private static final long serialVersionUID = 1L;

	public ToolBarCanciones(VentanaPrincipal mainWindow /*Controlador contr*/)
	{
		super();
		// contr.addObserver(this);
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Añadir cancion");
		aniadirCancion.setIcon(new ImageIcon(("------------")));
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(aniadirCancion);
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Eliminar cancion de la lista");
		eliminarCancion.setIcon(new ImageIcon(("------------")));
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarCancion);
		
		
		JButton meGusta = new JButton();
		meGusta.setToolTipText("Me gusta esta cancion");
		meGusta.setIcon(new ImageIcon(("------------")));
		meGusta.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(meGusta);
	}
}
