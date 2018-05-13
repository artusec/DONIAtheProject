package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Border bordePorDefecto = BorderFactory.createLineBorder(Color.black, 2);

	static private final String[] columnCanciones = {"#", "Title", "Artist", "Genre", "Duration"};
	static private final String[] columnLista = {"#", "Name", "Duration", "Genre"};

	// PANELES
	private PanelAreaTexto panelDeLetras;
	private PanelTabla<Lista> panelListas;
	private PanelTabla<Cancion> panelCanciones;
	private ToolBar toolBar;
	private JPanel panelCambiante;
	private JPanel panelCentral;


	// CONTROLADORES (se crean cuando se utilizan porque es una arquitectura web)
	private ControlCancion controlCancion;
	private ControlGenero controlGenero;
	private ControlLista controlLista;
	private ControlUsuario controlUsuario;
	
	// USUARIO
	private Usuario usuarioActual;

	private Login Login;

	public VentanaPrincipal () {
		super("Donia");
		//forzamos admin para pruebas
		try {
			usuarioActual = new Usuario("u0", "admin", "");
		} catch (ErrorCreacionObjeto e) {}
		initGUI();
		//Login = new Login(new ControlUsuario(usuarioActual), this);
		//Login.setVisible(true);
	}
	
	private void initGUI() {
		this.setIconImage(new ImageIcon("src/icons/LOGO_DONIA.png").getImage()); 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent e) {}

			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "Do you really want to exit?", "SALIR",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowOpened(WindowEvent e) {}
		
		 });
		
		
		JPanel panelSupremo = creaPanelSupremo();
		setContentPane(panelSupremo);
		
		addToolBar(panelSupremo);
		
		panelCentral = createPanelCentral();
		panelSupremo.add(panelCentral, BorderLayout.CENTER);

		creaPanelListas(panelCentral);
		creaPanelCanciones(panelCentral);
		createPanelCambiante();
		verPerfil();
		 
		pack();
		setVisible(true);
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
		panelListas = new PanelTabla<Lista>("Listas de reproduccion", new ModeloTablaListas(columnLista, controlLista, controlUsuario));
		panelListas.setAutoscrolls(true);
		izquierda.add(panelListas);
		izquierda.add(barListas, BorderLayout.SOUTH);
		panelCentral.add(izquierda);	
	}
	
	private void creaPanelCanciones(JPanel panelCentral) {
		JPanel medio = new JPanel();
		medio.setLayout(new BorderLayout());
		panelCanciones = new PanelTabla<Cancion>("Canciones", new ModeloTablaCanciones(columnCanciones, controlCancion, controlLista));
		panelCanciones.setAutoscrolls(true);
		medio.add(panelCanciones);
		ToolBarCanciones barCanciones = new ToolBarCanciones(this, controlCancion, controlLista, controlGenero);
		barCanciones.setFloatable(false);
		medio.add(barCanciones, BorderLayout.SOUTH);
		panelCentral.add(medio);
	}
	
	private void createPanelCambiante() {
		
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		panelCentral.add(panelCambiante);
	}
	
	private void resetearPanelCambiante() {
		
		panelCambiante.removeAll();
		panelCambiante.setVisible(false);
		panelCentral.remove(panelCambiante);
	}
	
	public void verPerfil() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		Account_panel account = new Account_panel();
		account.setVisible(true);
		account.setOpaque(false);
		panelCambiante.add(account);
		panelCentral.add(panelCambiante);
	}
	
	public void verAniadirCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		SongAdmin_panel songAdmin = new SongAdmin_panel(this);
		songAdmin.setVisible(true);
		songAdmin.setOpaque(false);
		panelCambiante.add(songAdmin);
		panelCentral.add(panelCambiante);
	}
	
	public void verPanelLetras() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		panelDeLetras = new PanelAreaTexto("Letra", false);
		panelDeLetras.areatexto.setText("Elige una cancion para ver su letra!");
		panelDeLetras.setVisible(true);
		panelDeLetras.setOpaque(false);
		panelCambiante.add(panelDeLetras);
		panelCentral.add(panelCambiante);
	}
	
	public void verModificarCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		
		
		ModificarCancion_panel modificar = new ModificarCancion_panel();
		modificar.setVisible(true);
		modificar.setOpaque(false);
		panelCambiante.add(modificar);
		panelCentral.add(panelCambiante);
		
	}
	
	public void verEliminarCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		
		EliminarCancion_panel eliminar = new EliminarCancion_panel(this);
		eliminar.setVisible(true);
		eliminar.setOpaque(false);
		panelCambiante.add(eliminar);
		panelCentral.add(panelCambiante);
	}
	
	
	public PanelTabla<Cancion> getPanelCanciones()
	{
		return panelCanciones;
	}
	
	public PanelTabla<Lista> getPanelListas()
	{
		return panelListas;
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

	public void setLetra(String letra) {
		panelDeLetras.setTexto(letra);
	}

	public void setUsuarioActual(Usuario accesor) {
		this.usuarioActual = accesor;
	}

	public JPanel getPanelCambiante() {
		return panelCambiante;
	}

	public void setPanelCambiante(JPanel panelCambiante) {
		this.panelCambiante = panelCambiante;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public Usuario getUsuarioActual() {
		return this.usuarioActual;
	}
	
	/**
	 * Genera un id de forma aleatoria y presuntamente unica para
	 * los objetos nuevos
	 * @return id
	 */
	public String generaId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * Calcula si una entrada del usuario es valida o no
	 * @param entrada texto a validar
	 * @return si es valido
	 */
	public boolean entradaValida(String entrada) {
		return entrada.matches("[a-zA-Z0-9]*");
	}
	
	
}
