package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private Boolean correcto;
	
	private SingUp singUp;
	public class SingUp extends JDialog {

		private final JPanel contentPanel = new JPanel();
		private JTextField textField;
		private JTextField textField_1;
		private JPasswordField passwordField;

		private Login login;
		/**
		 * Create the dialog.
		 * @param login 
		 */
		public SingUp(Login login) {
			this.login = login;
			initGui();
			setVisible(false);
		}
		private void initGui() {
			
			addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					setVisible(false);
					login.setVisible(true);	
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
									
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
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
	public Login() {
		
		correcto = false;
		singUp = new SingUp(this);
		initGui();
		
	}

	private void initGui() {
		setBounds(100, 100, 450, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Screen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(161, 13, 107, 28);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(74, 70, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(74, 113, 67, 16);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(236, 67, 116, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 110, 116, 22);
		contentPanel.add(passwordField);
		
		JButton btnSingUp = new JButton("Sing Up");
		btnSingUp.setBounds(104, 164, 97, 25);
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
				correcto = true;
				setVisible(false);
				
				//si no error
			}
		});
		btnLogin.setBounds(225, 164, 97, 25);
		contentPanel.add(btnLogin);
		
		setLocationRelativeTo(null);
		
	}

	public Boolean getCorrecto() {
		return correcto;
	}
	
	
}
