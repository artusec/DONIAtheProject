package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarCanciones extends JToolBar implements ObservadorAplicacion {

	private static final long serialVersionUID = 1L;

	public ToolBarCanciones(VentanaPrincipal mainWindow , Controlador controlador)
	{
		super();
		controlador.addObservador(this);
		
		setLayout(new GridLayout(1, 3));
		
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
	}
}
