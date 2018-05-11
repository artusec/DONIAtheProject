package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;


public class ToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	private JDialog Perfil; 
	
	public ToolBar(VentanaPrincipal mainWindow, ControlCancion controlCancion, ControlGenero controlGenero,
			ControlLista controlLista, ControlUsuario controlUsuario)
	{
		super();	

		Account account = new Account();
		SongAdmin songAdmin = new SongAdmin();

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
				
				account.setVisible(true);
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
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(verGustos);
		

		
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Añadir canción");
		aniadirCancion.setIcon(new ImageIcon("src/icons/addCancion.png"));
		aniadirCancion.setText("Añadir canción");
		aniadirCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		aniadirCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				songAdmin.setVisible(true);
			}
		 });
		
		this.add(aniadirCancion);
		
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Borrar canción");
		eliminarCancion.setIcon(new ImageIcon("src/icons/eliminarCancion.png"));
		eliminarCancion.setText("Borrar canción");
		eliminarCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		eliminarCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarCancion);
		
		
		JButton modifCancion = new JButton();
		modifCancion.setToolTipText("Modificar canción");
		modifCancion.setIcon(new ImageIcon("src/icons/modificarCancion.png"));
		modifCancion.setText("Modificar canción");
		modifCancion.setHorizontalTextPosition( SwingConstants.CENTER );
		modifCancion.setVerticalTextPosition( SwingConstants.BOTTOM );
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
