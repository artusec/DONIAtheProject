package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Controlador.ControlCancion;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

public class ToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	private JDialog Perfil; 
	
	public ToolBar(VentanaPrincipal mainWindow, ControlCancion controlCancion, ControlGenero controlGenero,
			ControlLista controlLista, ControlUsuario controlUsuario)
	{
		super();	
		dialogPerfil();
		JButton perfil = new JButton();
		perfil.setToolTipText("Account");
		perfil.setIcon(new ImageIcon("src\\icons\\perfil.png"));
		perfil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Perfil.setVisible(true);
			

			}
		 });
		
		this.add(perfil);
		
		
		JButton verGustos = new JButton();
		verGustos.setToolTipText("See genre");
		verGustos.setIcon(new ImageIcon("src\\icons\\gustos.png"));
		verGustos.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(verGustos);
		

		
		
		JButton aniadirCancion = new JButton();
		aniadirCancion.setToolTipText("Add new song");
		aniadirCancion.setIcon(new ImageIcon("src\\icons\\addCancion.png"));
		aniadirCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(aniadirCancion);
		
		
		JButton eliminarCancion = new JButton();
		eliminarCancion.setToolTipText("Delete song");
		eliminarCancion.setIcon(new ImageIcon("src\\icons\\eliminarCancion.png"));
		eliminarCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(eliminarCancion);
		
		
		JButton modifCancion = new JButton();
		modifCancion.setToolTipText("Modify song");
		modifCancion.setIcon(new ImageIcon("src\\icons\\modificarCancion.png"));
		modifCancion.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		 });
		
		this.add(modifCancion);
		
		
		JButton salir = new JButton();
		salir.setToolTipText("Exit");
		salir.setIcon(new ImageIcon("src\\icons\\exit.png"));
		salir.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "Do you really want to exit?", "EXIT",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}
		 });
		
		this.add(salir);
	}

	private void dialogPerfil() {
		Perfil = new JDialog(new Frame(),"Account", true);
		JPanel fondo = new JPanel(new GroupLayout(Perfil));
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		
		/*((GroupLayout) fondo.getLayout()).setHorizontalGroup(
				((GroupLayout) fondo.getLayout()).createParallelGroup(Alignment.LEADING)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
			);
		((GroupLayout) fondo.getLayout()).setVerticalGroup(
				((GroupLayout) fondo.getLayout()).createParallelGroup(Alignment.LEADING)
					.addGroup(((GroupLayout) fondo.getLayout()).createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
			);
		*/
		
		fondo.add(panel);
		fondo.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(39, 47, 56, 16);
		panel_1.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(39, 100, 56, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(39, 150, 75, 16);
		panel_1.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(256, 44, 116, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(256, 97, 116, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField("hola");
		passwordField.setBounds(256, 147, 91, 22);
		panel_1.add(passwordField);
		passwordField.setEchoChar('*');
		
		JRadioButton radioButton = new JRadioButton();
		radioButton.setToolTipText("Show Password");
		radioButton.setBounds(355, 144, 25, 25);
		panel_1.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField.setEchoChar((char) 0);
				
			}
		});
		radioButton.setEnabled(true);
		
		JButton btnEditarNombre = new JButton("Edit Name");
		btnEditarNombre.setBounds(78, 183, 126, 25);
		panel_1.add(btnEditarNombre);
		btnEditarNombre.setEnabled(true);
		
		
		
		JButton btnEtitarContrasenia = new JButton("Edit Password");
		btnEtitarContrasenia.setBounds(216, 183, 116, 25);
		panel_1.add(btnEtitarContrasenia);
		btnEtitarContrasenia.setEnabled(true);
		
		
		Perfil.setSize(450, 500);
		Perfil.setLocationRelativeTo(null);
	}
}
