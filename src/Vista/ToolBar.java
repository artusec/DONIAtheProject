package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	
	public ToolBar(VentanaPrincipal mainWindow) {
		super();	

		JButton perfil = new JButton();
		perfil.setToolTipText("Perfil");
		perfil.setIcon(new ImageIcon("src/icons/perfil.png"));
		perfil.setText("Perfil");
		perfil.setHorizontalTextPosition( SwingConstants.CENTER );
		perfil.setVerticalTextPosition( SwingConstants.BOTTOM );
		perfil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				mainWindow.verPerfil();
			}
		 });
		
		this.add(perfil);
		
		JButton verGustos = new JButton();
		verGustos.setToolTipText("Gustos");
		verGustos.setIcon(new ImageIcon("src/icons/gustos.png"));
		verGustos.setText("Gustos");
		verGustos.setHorizontalTextPosition( SwingConstants.CENTER );
		verGustos.setVerticalTextPosition( SwingConstants.BOTTOM );
		verGustos.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.verFavoritos();
			}
		 });
		
		this.add(verGustos);
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Añadir cancion");
		aniadirCancion.setIcon(new ImageIcon("src/icons/addCancion.png"));
		aniadirCancion.setText("Añadir cancion");
		aniadirCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		aniadirCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.verAniadirCancion();
			}
		 });
		
		this.add(aniadirCancion);
		
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Borrar cancion");
		eliminarCancion.setIcon(new ImageIcon("src/icons/eliminarCancion.png"));
		eliminarCancion.setText("Borrar cancion");
		eliminarCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		eliminarCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.eliminarCancion();
			}
		 });
		
		this.add(eliminarCancion);
		
		/* Los shiavales dicen que lo quitamos NO SERIA MUY DIFICIL DE HACER EH
		JButton modifCancion = new JButton();
		modifCancion.setToolTipText("Modificar cancion");
		modifCancion.setIcon(new ImageIcon("src/icons/modificarCancion.png"));
		modifCancion.setText("Modificar cancion");
		modifCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		modifCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		modifCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				mainWindow.verModificarCancion();
			}
		 });
		
		this.add(modifCancion);
		*/
		
		JButton salir = new JButton();
		salir.setToolTipText("Salir");
		salir.setIcon(new ImageIcon("src/icons/exit.png"));
		salir.setText("Salir");
		salir.setHorizontalTextPosition( SwingConstants.CENTER );
		salir.setVerticalTextPosition( SwingConstants.BOTTOM );
		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "Do you really want to exit?", "EXIT",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}
		 });
		
		this.add(salir);
	}
}
