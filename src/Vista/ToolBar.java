package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

public class ToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	public ToolBar(VentanaPrincipal mainWindow, ControlCancion controlCancion, ControlGenero controlGenero,
			ControlLista controlLista, ControlUsuario controlUsuario)
	{
		super();	

		JButton perfil = new JButton();
		perfil.setToolTipText("Account");
		perfil.setIcon(new ImageIcon("src\\icons\\perfil.png"));
		perfil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// Usuario user = controlador.getUserData();
				

				Usuario user = null;
				try {
					user = new Usuario("idPrueba", "namePrueba", "passPrueba");
				} catch (ErrorCreacionObjeto e) {
					e.printStackTrace();
				}
				
				JDialog diag = new JDialog(new JFrame(), false);
				diag.setLayout(new GridLayout(2, 1));
				
				JPanel arriba = new JPanel(new BorderLayout());
				JButton foto = new JButton();
				foto.setBorderPainted(true);
				foto.setFocusPainted(true);
				foto.setIcon(new ImageIcon("src\\icons\\perfilLogo.png"));
				foto.setMaximumSize(getMaximumSize());
				arriba.add(foto);
				
				JPanel abajo = new JPanel();
				abajo.setLayout(new GridLayout(3, 2));
				
				JLabel nombre = new JLabel();
				nombre.setText('\b' + "NOMBRE");
				
				JLabel id = new JLabel();
				id.setText('\b' + "ID");
		
				JLabel pass = new JLabel();
				pass.setText('\b' + "PASS");
				
				JTextArea areaNombre = new JTextArea();

				
				
				
				
				
				diag.add(arriba);
				diag.add(abajo);
				
				
				diag.setTitle("YOUR ACCOUNT");
				diag.setLocationRelativeTo(null);
				diag.setPreferredSize(new Dimension(400, 300));
				diag.pack();
				diag.setVisible(true);

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
				// TODO Auto-generated method stub
				
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
