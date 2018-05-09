package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

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

import Controlador.ControlUsuario;
import Controlador.Controlador;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;

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
	private ControlUsuario ctrlU;
	
	private JDialog Login;
	private JDialog SingUp;
	

	public VentanaPrincipal (Controlador controlador) throws ErrorCreacionObjeto
	{
		super("Donia");
		this.controlador = controlador;
		Login = new JDialog(new JFrame(),"Inciciar Sesion", true);
		SingUp = new JDialog(new JFrame(), "Registrarse", true);
		this.initGUI();
	}
	
	private void initGUI() throws ErrorCreacionObjeto
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
				int a = JOptionPane.showOptionDialog(new JFrame(), "�Seguro que quieres salir?", "SALIR",
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
		setVisible(false);
		this.login();
		this.singUp();
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

		JLabel titleLabel = new JLabel("Sing Up Screen");
		titleLabel.setLocation(0, 0);
		titleLabel.setSize(290, 30);
		titleLabel.setHorizontalAlignment(0);
		SingUp.add(titleLabel);

		// Creation of a Panel to contain the JLabels
		JPanel textPanel = new JPanel();
		textPanel.setLayout(null);
		textPanel.setLocation(10, 35);
		textPanel.setSize(70, 160);
		SingUp.add(textPanel);

		// Username Label
		JLabel idLabel = new JLabel("ID");
		idLabel.setLocation(0, 0);
		idLabel.setSize(70, 40);
		idLabel.setHorizontalAlignment(4);
		textPanel.add(idLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setLocation(0, 40);
		usernameLabel.setSize(70, 40);
		usernameLabel.setHorizontalAlignment(4);
		textPanel.add(usernameLabel);

		// Login Label
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setLocation(0, 80);
		passwordLabel.setSize(70, 40);
		passwordLabel.setHorizontalAlignment(4);
		textPanel.add(passwordLabel);

		// TextFields Panel Container
		JPanel panelForTextFields = new JPanel();
		panelForTextFields.setLayout(null);
		panelForTextFields.setLocation(110, 40);
		panelForTextFields.setSize(160, 70);
		SingUp.add(panelForTextFields);

		// Username Textfield		
		JTextField idField = new JTextField(8);
		idField.setLocation(0, 0);
		idField.setSize(120, 30);
		panelForTextFields.add(idField);
		
		JTextField usernameField = new JTextField(8);
		usernameField.setLocation(0, 40);
		usernameField.setSize(120, 30);
		panelForTextFields.add(usernameField);

		// Login Textfield
		JPasswordField loginField = new JPasswordField(8);
		loginField.setEchoChar('*');
		loginField.enableInputMethods(true);
		loginField.setLocation(0, 80);
		loginField.setSize(120, 30);
		panelForTextFields.add(loginField);

		// Button for Logging in
		JButton singup = new JButton("SingUp");
		singup.setLocation(110, 180);
		singup.setSize(80, 30);
		singup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ctrlU.registro(idField.getText().trim(), usernameField.getText().trim(), String.valueOf(loginField.getPassword()));
				SingUp.setVisible(false);
				Login.setVisible(true);
			}
		});
		SingUp.add(singup);

		
		SingUp.setSize(310, 280);
		SingUp.setLocationRelativeTo(null);
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
		setFont(new Font("MyStyle", 1, 20));
		String titulo = "Listas de reproduccion";
		panelListas = new PanelTabla<Lista>(titulo, new ModeloTablaListas(columnLista, controlador));
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
		panelDeLetras.areatexto.setText("�Elige una cancion para ver su letra!");
		panelCentral.add(panelDeLetras);
	}
	
	public void muestraError(Exception e)
	{
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
}
