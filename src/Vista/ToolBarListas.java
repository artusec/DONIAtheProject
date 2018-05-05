package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarListas extends JToolBar implements ObservadorAplicacion {

	private static final long serialVersionUID = 1L;

	public ToolBarListas(VentanaPrincipal mainWindow /*Controlador contr*/)
	{
		super();
		// contr.addObserver(this);
		
		JButton nuevLista = new JButton();
		nuevLista.setToolTipText("Crea una nueva lista vacia");
		nuevLista.setIcon(new ImageIcon(("-----------------")));
		nuevLista.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(nuevLista);
		
		
		JButton eliminarLista = new JButton();
		eliminarLista.setToolTipText("Eliminar una lista");
		eliminarLista.setIcon(new ImageIcon(("-----------------")));
		eliminarLista.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarLista);
		
		JButton listaAuto = new JButton();
		listaAuto.setToolTipText("Crear automaticamente una lista");
		listaAuto.setIcon(new ImageIcon(("-----------------")));
		listaAuto.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(listaAuto);
	}
	

}
