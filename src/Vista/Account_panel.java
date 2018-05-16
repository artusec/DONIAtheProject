package Vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Model.Objetos.Usuario;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Account_panel() {
		setBorder(new TitledBorder(null, "PERFIL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPanel panel = new JPanel();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		
		PanelImagen panel_2 = new PanelImagen(true);
		
		
	
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(76)
									.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
									.addGap(63))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(123)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
							.addGap(130)))
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(203)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(62)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_4 = new JPanel();
		
		JPanel panel_5 = new JPanel();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JButton btnEditarPerfil = new JButton("Editar perfil");
		btnEditarPerfil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO recoger los datos que ha escrito el usuario y sobreescribir la base de datos
				
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
					.addContainerGap(61, Short.MAX_VALUE)
					.addComponent(btnEditarPerfil)
					.addGap(55))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(40)
					.addComponent(btnEditarPerfil)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		JLabel lblPrimeroEditaLos = new JLabel("Primero edita los campos de");
		
		JLabel lblDebajoYDespus = new JLabel("debajo y después pulsa el");
		
		JLabel lblBotneditarPerfil = new JLabel("botón \"Editar perfil\".");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrimeroEditaLos)
						.addComponent(lblDebajoYDespus)
						.addComponent(lblBotneditarPerfil))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPrimeroEditaLos)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDebajoYDespus)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblBotneditarPerfil)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNombre = new JLabel("NOMBRE");
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblId)
								.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
							.addGap(53))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblContrasea)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(textField_1)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(81)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(79)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		this.setSize(new Dimension(582, 759));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(panel);

	}
	
	public void setDatosUsuario(Usuario user) {
		
		this.passwordField.setText(user.getClave());
		this.textField.setText(user.getId());
		this.textField_1.setText(user.getNombre());
	}
}
