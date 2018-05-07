package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar implements ObservadorAplicacion {
	
	private static final long serialVersionUID = 1L;
	
	public ToolBar(VentanaPrincipal mainWindow /*Controlador contr*/)
	{
		super();
		// contr.addObserver(this);
		

		JButton perfil = new JButton();
		perfil.setToolTipText("Ver tu perfil");
		perfil.setIcon(new ImageIcon(("src/Vista/iconos Donia/perfil.png")));
		perfil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(perfil);
		
		
		JButton verGustos = new JButton();
		verGustos.setToolTipText("Ver gustos musicales");
		verGustos.setIcon(new ImageIcon(("src\\Vista\\iconos Donia\\gustos.png")));
		verGustos.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(verGustos);
		

		
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Añadir nueva cancion");
		aniadirCancion.setIcon(new ImageIcon(("src\\Vista\\iconos Donia\\addCancion.png")));
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(aniadirCancion);
		
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Eliminar cancion");
		eliminarCancion.setIcon(new ImageIcon(("src\\Vista\\iconos Donia\\eliminarCancion.png")));
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarCancion);
		
		
		JButton modifCancion = new JButton();
		modifCancion.setToolTipText("Modificar cancion");
		modifCancion.setIcon(new ImageIcon(("src\\Vista\\iconos Donia\\modificarCancion.png")));
		modifCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(modifCancion);
		
		
		JButton salir = new JButton();
		salir.setToolTipText("Salir");
		salir.setIcon(new ImageIcon(("src\\Vista\\iconos Donia\\exit.png")));
		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "¿Seguro que quieres salir?", "SALIR",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}
		 });
		
		this.add(salir);
		
		this.setFloatable(false);
	}
}
