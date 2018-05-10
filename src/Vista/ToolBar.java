package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
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
		perfil.setToolTipText("Account");
		perfil.setIcon(new ImageIcon("src\\icons\\perfil.png"));
		perfil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				account.setVisible(true);
			}
		 });
		
		this.add(perfil);
		
		
		JButton verGustos = new JButton();
		verGustos.setToolTipText("See genre");
		verGustos.setIcon(new ImageIcon("src\\icons\\gustos.png"));
		verGustos.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(verGustos);
		

		
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Add new song");
		aniadirCancion.setIcon(new ImageIcon("src\\icons\\addCancion.png"));
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				songAdmin.setVisible(true);
			}
		 });
		
		this.add(aniadirCancion);
		
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Delete song");
		eliminarCancion.setIcon(new ImageIcon("src\\icons\\eliminarCancion.png"));
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarCancion);
		
		
		JButton modifCancion = new JButton();
		modifCancion.setToolTipText("Modify song");
		modifCancion.setIcon(new ImageIcon("src\\icons\\modificarCancion.png"));
		modifCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(modifCancion);
		
		
		JButton salir = new JButton();
		salir.setToolTipText("Exit");
		salir.setIcon(new ImageIcon("src\\icons\\exit.png"));
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
