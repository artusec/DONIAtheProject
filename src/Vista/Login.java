package Vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Controlador.ControlUsuario;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

/**
 * Clase que crea una ventana para recoger los datos que el usuario introduce nada más iniciar la aplicación con los que
 * se identifica. Tiene una clase interna SingUp.
 */
public class Login extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private Boolean correcto;
	private SingUp singUp;

	/**
	 * Clase que crea una ventana, al pricipio oculta, para registrar un usuario nuevo en la aplicación. Contiene
	 * los campos de Id, nombre y contraseña para que el usuario los rellene con sus datos.
	 */
	public class SingUp extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private final JPanel contentPanel = new JPanel();
		private JTextField textField;
		private JTextField textField_1;
		private JPasswordField passwordField;
		private Login login;
		
		/**
		 * Crea la ventana de Registro
		 * @param login Ventana a la que te redirige despues de registrarte
		 */
		public SingUp(Login login) {
			
			this.login = login;
			initGui();
			setVisible(false);
		}
		
		/**
		 * Crea la parte visual de la ventana de registro
		 */
		private void initGui() {
			
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				setVisible(false);
				login.setVisible(true);	
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
			
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JLabel lblSingUpScreen = new JLabel("Sing Up Screen");
				lblSingUpScreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblSingUpScreen.setBounds(153, 13, 120, 22);
				contentPanel.add(lblSingUpScreen);
			}
			{
				textField = new JTextField();
				textField.setBounds(252, 57, 116, 22);
				contentPanel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(252, 103, 116, 22);
				contentPanel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(252, 148, 116, 22);
				contentPanel.add(passwordField);
			}
			{
				JButton btnSingUp = new JButton("Sing Up");
				btnSingUp.setBounds(165, 199, 97, 25);
				contentPanel.add(btnSingUp);
				btnSingUp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Usuario nuevoUsuario = null;
						try {
							String id = textField.getText().trim();
							String usuario = textField_1.getText().trim();
							String clave = String.valueOf(passwordField.getPassword());
							if (VentanaPrincipal.entradaValida(id) && 
								VentanaPrincipal.entradaValida(usuario) && 
								VentanaPrincipal.entradaValida(clave)) {
								nuevoUsuario = new Usuario(id, usuario, clave);
								if (nuevoUsuario != null) {
									ControlUsuario ctrlU = new ControlUsuario(null);
									ctrlU.registro(nuevoUsuario);
								}
							}
							else {
								JOptionPane.showMessageDialog(new JFrame(), "Caracteres invalidos", "ERROR", JOptionPane.ERROR_MESSAGE);
							}
						} catch (ErrorCreacionObjeto e1) {
							System.out.println("ERROR");
						}
						setVisible(false);
						login.setVisible(true);
						
					}
				});
			}
			{
				JLabel lblId = new JLabel("ID");
				lblId.setBounds(74, 60, 56, 16);
				contentPanel.add(lblId);
			}
			{
				JLabel lblName = new JLabel("Name");
				lblName.setBounds(74, 106, 56, 16);
				contentPanel.add(lblName);
			}
			{
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setBounds(74, 151, 70, 16);
				contentPanel.add(lblPassword);
			}
			setLocationRelativeTo(null);
		}
	
	}

	/**
	 * Constructora. Crea la ventana de Login.
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	public Login(VentanaPrincipal ventanaPrincipal) {
		correcto = false;
		singUp = new SingUp(this);
		initGui(ventanaPrincipal);
	}
	/**
	 * Crea la parte visual del Login.
	 * @param ventanaPrincipal Ventana Principal del programa que cargara tras hacer un login correcto
	 */
	private void initGui(VentanaPrincipal ventanaPrincipal) {
		setBounds(100, 100, 501, 616);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Screen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(197, 360, 107, 28);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(135, 419, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(135, 462, 67, 16);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(258, 416, 130, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(258, 459, 130, 22);
		passwordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                		in(ventanaPrincipal);
                }
		
			}
		});
		contentPanel.add(passwordField);
		
		JButton btnSingUp = new JButton("Sing Up");
		btnSingUp.setBounds(126, 516, 97, 25);
		contentPanel.add(btnSingUp);
		btnSingUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				singUp.setVisible(true);
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				//si existe y es correcto
				in(ventanaPrincipal);
			}
		});
		btnLogin.setBounds(258, 516, 97, 25);
		contentPanel.add(btnLogin);
		
		PanelImagen panel = new PanelImagen("Donia/icons/LOGO_DONIA_pequeno.png");
		panel.setBounds(10, 10, 475, 318);
		panel.setOpaque(false);
		contentPanel.add(panel, Alignment.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Donia");
	}
	
	/**
	 * Comprueba que los datos introducidos en el la ventana de Login son válidos y si existen en la base de datos.
	 * Si ambas suceden, introduce al usuario a la aplicacion que se hace visible.
	 * @param ventanaPrincipal Ventaana Principal a la que el usuario es introducido.
	 */
	public void in(VentanaPrincipal ventanaPrincipal) {
		ControlUsuario ctrlU = new ControlUsuario(ventanaPrincipal.getUsuarioActual());
		String id = textField.getText().trim();
		String clave = String.valueOf(passwordField.getPassword());
		if (VentanaPrincipal.entradaValida(id) && 
			VentanaPrincipal.entradaValida(clave)) 
		{
			Usuario accesor = ctrlU.ingreso(textField.getText().trim(), String.valueOf(passwordField.getPassword()));
			if (accesor != null) {
				correcto = true;
				ventanaPrincipal.setUsuarioActual(accesor);
				
				VentanaPrincipal.actualizaListas();
				VentanaPrincipal.actualizaCanciones("l0");
				
				if(!accesor.getId().equals("u0"))


					ventanaPrincipal.configurarBotones(false);
				else
					ventanaPrincipal.configurarBotones(true);

				
				setVisible(false);
				ventanaPrincipal.verPerfil();
				ventanaPrincipal.setVisible(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Caracteres invalidos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Devuelve si el login ha ocurrido con éxito.
	 * @return Devuelve el booleano que determina si el Login ha ocurrido con éxito.
	 */
	public Boolean getCorrecto() {
		return correcto;
	}
}
