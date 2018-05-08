package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import Controlador.Controlador;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Border bordePorDefecto = BorderFactory.createLineBorder(Color.black, 2);

	static private final String[] columnCanciones = {"#", "Titulo", "Artista", "Genero", "Duracion"};
	static private final String[] columnLista = {"#", "Nombre", "Duracion", "Genero"};

	private PanelAreaTexto panelDeLetras;
	private PanelTabla<Lista> panelListas;
	private PanelTabla<Cancion> panelCanciones;
	private ToolBar toolBar;
	private Controlador controlador;
	
	private JDialog Login;
	

	public VentanaPrincipal (Controlador controlador)
	{
		super("Donia");
		this.controlador = controlador;
		Login = new JDialog(new JFrame("Login"), true);
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
				int a = JOptionPane.showOptionDialog(new JFrame(), "¿Seguro que quieres salir?", "SALIR",
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
		this.setContentPane(panelSupremo);
		
		addToolBar(panelSupremo);
		
		JPanel panelCentral = createPanelCentral();
		panelSupremo.add(panelCentral, BorderLayout.CENTER);

		creaPanelListas(panelCentral);
		creaPanelCanciones(panelCentral);
		createPanelLetras(panelCentral);
		 
		pack();
		this.login();
		setVisible(true);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	
	private void login() {
		JLabel usuario = new JLabel("Usuario:");
		JTextField user = new JTextField("Usuario");
		JLabel contra = new JLabel("Contrasea:");
		JPasswordField pass = new JPasswordField("Contrasea");
		JPanel textos = new JPanel(new FlowLayout());
		
		textos.setPreferredSize(new Dimension(400, 200));
		textos.add(usuario,CENTER_ALIGNMENT);
		textos.add(user, CENTER_ALIGNMENT);
		textos.add(contra,CENTER_ALIGNMENT);
		textos.add(pass,CENTER_ALIGNMENT);
	
		
		Login.setLayout(new BorderLayout());
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO ///COMPROBAR EN LA BASE DE DATOS SI EXISTE
				//Ctrl.usuarioExiste();
				
			}
		});
		Login.add(textos,BorderLayout.CENTER);
		Login.add(login, BorderLayout.PAGE_END);
		Login.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
		Login.pack();
		Login.setVisible(true);
		
		
	}

	private JPanel creaPanelSupremo() {
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());
		return principal;
	}

	private void addToolBar(JPanel panelSupremo) {
		toolBar = new ToolBar(this, controlador);
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
		ToolBarListas barListas = new ToolBarListas(this, controlador);
		barListas.setFloatable(false);
		panelListas = new PanelTabla<Lista>("Listas de reproduccion", new ModeloTablaListas(columnLista, controlador));
		panelListas.setAutoscrolls(true);
		izquierda.add(panelListas);
		izquierda.add(barListas, BorderLayout.SOUTH);
		panelCentral.add(izquierda);	
	}
	
	private void creaPanelCanciones(JPanel panelCentral) {
		JPanel medio = new JPanel();
		medio.setLayout(new BorderLayout());
		panelCanciones = new PanelTabla<Cancion>("Canciones", new ModeloTablaCanciones(columnCanciones, controlador));
		panelCanciones.setAutoscrolls(true);
		medio.add(panelCanciones);
		ToolBarCanciones barCanciones = new ToolBarCanciones(this, controlador);
		barCanciones.setFloatable(false);
		medio.add(barCanciones, BorderLayout.SOUTH);
		panelCentral.add(medio);
	}
	
	private void createPanelLetras(JPanel panelCentral) {
		JPanel derecha = new JPanel();
		PanelBarraEstado barra = new PanelBarraEstado("svjknvjndvkjsndkjv", controlador);
		derecha.add(barra, BorderLayout.NORTH);
		panelDeLetras = new PanelAreaTexto("Letra", false);
		panelDeLetras.areatexto.setText("¡Elige una cancion para ver su letra!");
		panelCentral.add(panelDeLetras);
	}
	
	public void muestraError(Exception e)
	{
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
}
