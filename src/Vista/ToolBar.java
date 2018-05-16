package Vista;

import java.awt.BorderLayout;
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
	
	private JButton perfil;
	private JButton verGustos;
	private JButton aniadirCancion;
	private JButton eliminarCancion;
	private JButton verBiblioteca;
	private JButton salir;
	
	public ToolBar(VentanaPrincipal mainWindow) {
		super();	

		perfil = new JButton();
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
		
		verGustos = new JButton();
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
		
		aniadirCancion = new JButton();
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
		
		
		eliminarCancion = new JButton();
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
		
		
		
		salir = new JButton();
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


	public void desactivarBotones() {
		
		aniadirCancion.setEnabled(false);
		eliminarCancion.setEnabled(false);
	}
}
