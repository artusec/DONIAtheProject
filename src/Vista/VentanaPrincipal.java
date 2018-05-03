package Vista;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Modelo.Objetos.Cancion;
import Modelo.Objetos.Lista;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static private final String[] columnCanciones = {"#", "Titulo", "Artista", "Genero"};
	static private final String[] columnLista = {"#", "Nombre", "Duracion", "Genero"};

	private PanelAreaTexto panelDeLetras;
	private PanelAreaTexto buscador;
	private PanelTabla<Lista> listas;
	private PanelTabla<Cancion> canciones;
	private PanelAreaTexto informacion; // Esto podria ser un PabelBarraEstado
	
	public VentanaPrincipal ()
	{
		super("Donia");
		
		
		this.initGUI();
	}
	
	private void initGUI()
	{
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "¿Seguro que quieres salir?", "SALIR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		
		 });
		
		 
		 this.pack();
		 this.setVisible(true);
	}

	
	
	
}
