package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.Border;


import Excepciones.ErrorCreacionObjeto;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Border bordePorDefecto = BorderFactory.createLineBorder(Color.black, 2);

	static private final String[] columnCanciones = {"#", "Title", "Artist", "Genre", "Duration"};
	static private final String[] columnLista = {"#", "Name", "Duration", "Genre"};

	private PanelAreaTexto panelDeLetras;
	private PanelTabla<Lista> panelListas;
	private PanelTabla<Cancion> panelCanciones;
	private ToolBar toolBar;


	private ControlCancion controlCancion;
	private ControlGenero controlGenero;
	private ControlLista controlLista;
	private ControlUsuario controlUsuario;
	
	
	private Login Login;
	

	public VentanaPrincipal (ControlCancion controlCancion, ControlGenero controlGenero,
							ControlLista controlLista, ControlUsuario controlUsuario) throws ErrorCreacionObjeto {

	//public VentanaPrincipal () {

		super("Donia");
		initGUI();
		Login = new Login();
		

		
		this.controlCancion = new ControlCancion(null);
		this.controlGenero = new ControlGenero(null);
		this.controlLista = new ControlLista(null);
		this.controlUsuario = new ControlUsuario(null);
		

		this.setIconImage(new ImageIcon("src\\icons\\LOGO_DONIA.png").getImage()); 

		
		Login.setVisible(true);
		if(Login.getCorrecto()) {
			setVisible(true);
		}

	}
	
	private void initGUI() throws ErrorCreacionObjeto
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "Do you really want to exit?", "SALIR",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
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
		
		
		JPanel panelSupremo = creaPanelSupremo();
		setContentPane(panelSupremo);
		
		addToolBar(panelSupremo);
		
		JPanel panelCentral = createPanelCentral();
		panelSupremo.add(panelCentral, BorderLayout.CENTER);

		creaPanelListas(panelCentral);
		creaPanelCanciones(panelCentral);
		createPanelLetras(panelCentral);
		 
		pack();

		setVisible(false);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	}


	

	private JPanel creaPanelSupremo() {
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());
		return principal;
	}

	private void addToolBar(JPanel panelSupremo) {
		toolBar = new ToolBar(this, controlCancion, controlGenero, controlLista, controlUsuario);
		toolBar.setFloatable(false);
		toolBar.setLayout(new GridLayout(6, 1));
		panelSupremo.add(toolBar, BorderLayout.EAST);
		
	}
	
	private JPanel createPanelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,3));
		return panelCentral;
	}
	

	private void creaPanelListas(JPanel panelCentral) {
		JPanel izquierda = new JPanel();
		izquierda.setLayout(new BorderLayout());
		ToolBarListas barListas = new ToolBarListas(this, controlLista);
		barListas.setFloatable(false);
		setFont(new Font("MyStyle", 1, 20));
		panelListas = new PanelTabla<Lista>("Playlists", new ModeloTablaListas(columnLista, controlLista, controlUsuario));
		panelListas.setAutoscrolls(true);
		izquierda.add(panelListas);
		izquierda.add(barListas, BorderLayout.SOUTH);
		panelCentral.add(izquierda);	
	}
	
	private void creaPanelCanciones(JPanel panelCentral) {
		JPanel medio = new JPanel();
		medio.setLayout(new BorderLayout());
		panelCanciones = new PanelTabla<Cancion>("Songs", new ModeloTablaCanciones(columnCanciones, controlCancion, controlLista));
		panelCanciones.setAutoscrolls(true);
		medio.add(panelCanciones);
		ToolBarCanciones barCanciones = new ToolBarCanciones(this, controlCancion, controlLista);
		barCanciones.setFloatable(false);
		medio.add(barCanciones, BorderLayout.SOUTH);
		panelCentral.add(medio);
	}
	
	private void createPanelLetras(JPanel panelCentral) {
		panelDeLetras = new PanelAreaTexto("Lists", false);
		panelDeLetras.areatexto.setText("Choose a song to see its lyrics!");
		panelCentral.add(panelDeLetras);
	}
	
	public PanelTabla<Cancion> getPanelCanciones()
	{
		return panelCanciones;
	}

	public static void muestraError(Exception e) {
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
	
	public static void actualizaCanciones() {
		// TODO Auto-generated method stub
		
	}
	
	public static void actualizaGeneros() {
		// TODO Auto-generated method stub
		
	}

	public static void actualizaListas() {
		// TODO Auto-generated method stub
		
	}

	public static void actualizaUsuario() {
		// TODO Auto-generated method stub
		
	}
}
