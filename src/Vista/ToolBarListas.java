package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import Controlador.Controlador;

public class ToolBarListas extends JToolBar implements ObservadorAplicacion {

	private static final long serialVersionUID = 1L;

	public ToolBarListas(VentanaPrincipal mainWindow, Controlador controlador)
	{
		super();
		controlador.addObservador(this);
		
		setLayout(new GridLayout(1, 3));
		
		JButton nuevLista = new JButton();
		nuevLista.setToolTipText("Crea una nueva lista vacia");
		nuevLista.setIcon(new ImageIcon(("src\\icons\\add.png")));
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
		eliminarLista.setIcon(new ImageIcon(("src\\icons\\delete.png")));
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
		listaAuto.setIcon(new ImageIcon(("src\\icons\\auto.png")));
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
