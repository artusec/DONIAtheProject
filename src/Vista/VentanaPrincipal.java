package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

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
	
	
	private JDialog Login;
	

	public VentanaPrincipal (ControlCancion controlCancion, ControlGenero controlGenero,
							ControlLista controlLista, ControlUsuario controlUsuario) {
		super("Donia");
		
		this.controlCancion = controlCancion;
		this.controlGenero = controlGenero;
		this.controlLista = controlLista;
		this.controlUsuario = controlUsuario;
		
		this.setIconImage(new ImageIcon("src\\icons\\LOGO_DONIA.png").getImage()); 
		JFrame loginFrame = new JFrame("Login");
		loginFrame.setIconImage(new ImageIcon("src\\icons\\LOGO_DONIA.png").getImage());
		Login = new JDialog(loginFrame, true);

		initGUI();
	}
	
	private void initGUI()
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
		login();
		setVisible(true);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

	}

	
	private void login() {
		Login.setLayout(null);

		JLabel titleLabel = new JLabel("Login Screen");
		titleLabel.setLocation(0, 0);
		titleLabel.setSize(290, 30);
		titleLabel.setHorizontalAlignment(0);
		Login.add(titleLabel);

		// Creation of a Panel to contain the JLabels
		JPanel textPanel = new JPanel();
		textPanel.setLayout(null);
		textPanel.setLocation(10, 35);
		textPanel.setSize(70, 80);
		Login.add(textPanel);

		// Username Label
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setLocation(0, 0);
		usernameLabel.setSize(70, 40);
		usernameLabel.setHorizontalAlignment(4);
		textPanel.add(usernameLabel);

		// Login Label
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setLocation(0, 40);
		passwordLabel.setSize(70, 40);
		passwordLabel.setHorizontalAlignment(4);
		textPanel.add(passwordLabel);

		// TextFields Panel Container
		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setLayout(null);
		panelForTextFields.setLocation(110, 40);
		panelForTextFields.setSize(100, 70);
		Login.add(panelForTextFields);

		// Username Textfield
		JTextField usernameField = new JTextField(8);
		usernameField.setLocation(0, 0);
		usernameField.setSize(100, 30);
		panelForTextFields.add(usernameField);

		// Login Textfield
		JPasswordField loginField = new JPasswordField(8);
		loginField.setEchoChar('*');
		loginField.setLocation(0, 40);
		loginField.setSize(100, 30);
		panelForTextFields.add(loginField);

		// Creation of a Panel to contain the completion JLabels
		JPanel completionPanel = new JPanel();
		completionPanel.setLayout(null);
		completionPanel.setLocation(240, 35);
		completionPanel.setSize(70, 80);
		Login.add(completionPanel);

		// Button for Logging in
		JButton loginButton = new JButton("Login");
		loginButton.setLocation(130, 120);
		loginButton.setSize(80, 30);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("oeoee");
			}
		});
		Login.add(loginButton);
		Login.setSize(310, 200);
		Login.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2,
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);

		Login.setVisible(true);
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
		panelListas = new PanelTabla<Lista>("Playlists", new ModeloTablaListas(columnLista, controlLista));
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
	
	public static void muestraError(Exception e)
	{
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
	
	public PanelTabla<Cancion> getPanelCanciones()
	{
		return panelCanciones;
	}
}
