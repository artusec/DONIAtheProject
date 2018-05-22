package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 * Clase que crea la barra de herramientas principal de la aplicación, la cual contiene los botones de ver perfil, 
 * ver gustos del usuario, añadir cancion a la base de datos (solo admin), eliminar canción de la base de datos
 * (solo admin), modificar canción de la base de datos (solo admin) y salir de la aplicación.
 */
public class ToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton perfil;
	private JButton verGustos;
	private JButton aniadirCancion;
	private JButton eliminarCancion;
	private JButton modifCancion;
	private JButton salir;
	
	/**
	 * Constructora. Crea la barra de herramientas y la añade a la Ventana Principal
	 * @param mainWindow Ventana Pricipal a la que se añade la Barra de herramientas
	 */
	public ToolBar(VentanaPrincipal mainWindow) {
		
		super();	

		perfil = new JButton();
		perfil.setToolTipText("Perfil");
		perfil.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/perfil.png")));
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
		verGustos.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/gustos.png")));
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
		aniadirCancion.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/addCancion.png")));
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
		eliminarCancion.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/eliminarCancion.png")));
		eliminarCancion.setText("Borrar cancion");
		eliminarCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		eliminarCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				mainWindow.verEliminarCancion();
			}
		 });
		
		this.add(eliminarCancion);
		
		
		modifCancion = new JButton();
		modifCancion.setToolTipText("Modificar cancion");
		modifCancion.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/modificarCancion.png")));
		modifCancion.setText("Modificar canción");
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
		
		
		salir = new JButton();
		salir.setToolTipText("Salir");
		salir.setIcon(new ImageIcon(ToolBar.class.getResource("/icons/exit.png")));
		salir.setText("Salir");
		salir.setHorizontalTextPosition( SwingConstants.CENTER );
		salir.setVerticalTextPosition( SwingConstants.BOTTOM );
		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int a = JOptionPane.showOptionDialog(new JFrame(), "¿Seguro que quieres salir?", "EXIT",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}
		 });
		
		this.add(salir);
	}


	/**
	 * Activa o desactiva los botones
	 * @param cual Booleano que define si los botones se activan o se desactivan
	 */
	public void configurarBotones(boolean cual) {
		
		aniadirCancion.setEnabled(cual);
		eliminarCancion.setEnabled(cual);
		modifCancion.setEnabled(cual);
	}
}
