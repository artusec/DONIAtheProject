package Vista;

import java.awt.BorderLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private Boolean correcto;
	
	private SingUp singUp;
	

	public class SingUp extends JDialog {

		private static final long serialVersionUID = 1L;
		
		private final JPanel contentPanel = new JPanel();
		private JTextField textField;
		private JTextField textField_1;
		private JPasswordField passwordField;

		private Login login;
		/**
		 * Create the dialog.
		 * @param login 
		 * @param ctrlU 
		 */
		public SingUp(Login login, ControlUsuario ctrlU) {
			this.login = login;
			initGui(ctrlU);
			setVisible(false);
		}
		private void initGui(ControlUsuario ctrlU) {
			
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
						//Registrar usuario
						Usuario yo = null;
						try {
							yo = new Usuario(textField.getText().trim(), textField_1.getText().trim(), String.valueOf(passwordField.getPassword()));
							if (yo != null) {
								ctrlU.registro(yo);
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
	 * Create the dialog.
	 */
	public Login(ControlUsuario ctrlU, VentanaPrincipal ventanaPrincipal) {
		correcto = false;
		singUp = new SingUp(this, ctrlU);
		initGui(ctrlU, ventanaPrincipal);
	}

	private void initGui(ControlUsuario ctrlU, VentanaPrincipal ventanaPrincipal) {
		setBounds(100, 100, 501, 616);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Screen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(197, 360, 107, 28);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
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
		
		ControlLista ctrlLista = new ControlLista(ventanaPrincipal.getUsuarioActual());
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				//si existe y es correcto
				Usuario accesor = ctrlU.ingreso(textField.getText().trim(), String.valueOf(passwordField.getPassword()));
				if (accesor != null) {
					correcto = true;
					ventanaPrincipal.setUsuarioActual(accesor);
					
					//Habria que cargar todas las listas del usuario
					ArrayList<Lista> listas = ctrlLista.getListasUsuario(ventanaPrincipal.getUsuarioActual());
					if (listas != null)
						ventanaPrincipal.getPanelListas().getModelo().lista.addAll(listas);

					setVisible(false);
					ventanaPrincipal.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(258, 516, 97, 25);
		contentPanel.add(btnLogin);
		
		PanelImagen panel = new PanelImagen(false);
		panel.setBounds(10, 11, 475, 318);
		panel.setOpaque(false);
		contentPanel.add(panel, Alignment.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Donia");
	}

	public Boolean getCorrecto() {
		return correcto;
	}
}
