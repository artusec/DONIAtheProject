package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
import Excepciones.ErrorCreacionObjeto;
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

	// PANELES
	private PanelAreaTexto panelDeLetras;
	private PanelTabla<Lista> panelListas;
	private PanelTabla<Cancion> panelCanciones;
	private ToolBar toolBar;

	// CONTROLADORES
	private ControlCancion controlCancion;
	private ControlGenero controlGenero;
	private ControlLista controlLista;
	private ControlUsuario controlUsuario;
	
	// CUADROS DE DIALOGO
	private JDialog Login;
	private JDialog SingUp;
	

	public VentanaPrincipal (ControlCancion controlCancion, ControlGenero controlGenero,
							ControlLista controlLista, ControlUsuario controlUsuario) throws ErrorCreacionObjeto {

		super("Donia");

		Login = new JDialog(new JFrame(),"Inciciar Sesion", true);
		SingUp = new JDialog(new JFrame(), "Registrarse", true);

		controlCancion = new ControlCancion(null);
		controlGenero = new ControlGenero(null);
		controlLista = new ControlLista(null);
		controlUsuario = new ControlUsuario(null);
		
		this.setIconImage(new ImageIcon("src\\icons\\LOGO_DONIA.png").getImage()); 
		
		JFrame loginFrame = new JFrame("Login");
		loginFrame.setIconImage(new ImageIcon("src\\icons\\LOGO_DONIA.png").getImage());
		Login = new JDialog(loginFrame, true);

		initGUI();
	}
	
	private void initGUI() throws ErrorCreacionObjeto
	{
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
		
		JPanel panelCentral = createPanelCentral();
		panelSupremo.add(panelCentral, BorderLayout.CENTER);

		creaPanelListas(panelCentral);
		creaPanelCanciones(panelCentral);
		createPanelLetras(panelCentral);
		 
		pack();
		setVisible(false);
		
		login();
		singUp();

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
		panelForTextFields.setSize(120, 70);
		Login.add(panelForTextFields);

		// Username Textfield
		JTextField usernameField = new JTextField(8);
		usernameField.setLocation(0, 0);
		usernameField.setSize(120, 30);
		panelForTextFields.add(usernameField);

		// Login Textfield
		JPasswordField loginField = new JPasswordField(8);
		loginField.setEchoChar('*');
		loginField.setLocation(0, 40);
		loginField.setSize(120, 30);
		panelForTextFields.add(loginField);


		// Button for Logging in
		JButton loginButton = new JButton("Login");
		loginButton.setLocation(180, 120);
		loginButton.setSize(80, 30);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ctrlU.ingreso(usernameField.getText().trim(), String.valueOf(loginField.getPassword()));
				Login.setVisible(false);
				setVisible(true);
			}
		});
		Login.add(loginButton);
		
		JButton singup = new JButton("SingUp");
		singup.setLocation(80, 120);
		singup.setSize(80, 30);
		singup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Login.setVisible(false);
				SingUp.setVisible(true);
			}
		});
		
		Login.add(singup);
		Login.setSize(310, 200);
		Login.setLocationRelativeTo(null);

		Login.setVisible(true);
	}

	public void singUp() throws ErrorCreacionObjeto {
		
		SingUp.setLayout(null);		
		
		JLabel lblSingUpScreen = new JLabel("Sing Up Screen");
		lblSingUpScreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSingUpScreen.setBounds(150, 13, 132, 22);
		SingUp.add(lblSingUpScreen);
	
	
		JButton btnSingUp = new JButton("Sing Up");
		btnSingUp.setBounds(168, 215, 97, 25);
		SingUp.add(btnSingUp);
		btnSingUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ctrlU.registro(idField.getText().trim(), usernameField.getText().trim(), String.valueOf(loginField.getPassword()));
				SingUp.setVisible(false);
				Login.setVisible(true);
			}
		});
		
		
		JTextField textField = new JTextField();
		textField.setBounds(232, 67, 116, 22);
		SingUp.add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(232, 113, 116, 22);
		SingUp.add(textField_1);
		textField_1.setColumns(10);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(232, 158, 116, 22);
		SingUp.add(passwordField);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(59, 70, 56, 16);
		SingUp.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(59, 116, 56, 16);
		SingUp.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(59, 161, 72, 16);
		SingUp.add(lblNewLabel_2);

		
		SingUp.setSize(450, 300);
		SingUp.setLocationRelativeTo(null);
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
	
	public PanelTabla<Cancion> getPanelCanciones()
	{
		return panelCanciones;
	}

	public static void muestraError(Exception e) {
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
	
	public static void actualizaCanciones() {
		

		
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
