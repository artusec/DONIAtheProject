package Vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import Model.Objetos.Usuario;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;

public class Account_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private VentanaPrincipal view;
	/**
	 * Create the panel.
	 */

	public Account_panel(VentanaPrincipal view) {
		this.view = view;
		setBorder(new TitledBorder(null, "PERFIL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[445.00,grow]", "[][206.00,grow][84.00][grow]"));

		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, "cell 0 0,grow");
		panel_5.setLayout(new MigLayout("", "[99px][111px,grow][163px][148px,grow][116px]", "[][25px,grow][][][][][][][][][]"));
		
		JPanel panel = new JPanel();
		panel_5.add(panel, "cell 2 0,grow");
		panel.setLayout(null);


		PanelImagen panelimg = new PanelImagen(false);
		panelimg.setBounds(0, 0, panel.getWidth(),panel.getHeight());
		panel.add(panelimg);

		JButton btnEditarPerfil = new JButton("Editar perfil");
	
		JLabel lblPrimeroEditaLos = new JLabel("Primero edita los campos de");
		panel_5.add(lblPrimeroEditaLos, "cell 1 6,alignx left,aligny center");
		
				

		panel_5.add(btnEditarPerfil, "cell 3 6,growx,aligny top");
		JLabel lblDebajoYDespus = new JLabel("debajo y después pulsa el");
		panel_5.add(lblDebajoYDespus, "cell 1 7,alignx left,aligny center");
		JLabel lblBotneditarPerfil = new JLabel("botón \"Editar perfil\".");
		panel_5.add(lblBotneditarPerfil, "cell 1 8,alignx left,aligny center");
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
		panel_5.add(btnCerrarSesin, "cell 3 8,alignx left,aligny top");
		
				btnCerrarSesin.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						view.setUsuarioActual(null);
						view.setVisible(false);
						Login lgn = new Login(view);
						lgn.setVisible(true);
					}
				});
		
		JSeparator separator = new JSeparator();
		panel_2.add(separator, "cell 0 2");
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, "cell 0 3,grow");
		panel_6.setLayout(new MigLayout("", "[12px][49px,grow][80px][][116px][][116px][6px]", "[22px][][25.00,center][][21.00][][][]"));
		
		
			
		JLabel lblId = new JLabel("ID");
		panel_6.add(lblId, "cell 3 1,alignx left,aligny center");
		textField = new JTextField();
		textField.setColumns(10);
		panel_6.add(textField, "cell 5 1,alignx left,aligny top");
		
		JSeparator separator_1 = new JSeparator();
		panel_6.add(separator_1, "cell 2 2 5 1");
		JLabel lblNombre = new JLabel("NOMBRE");
		panel_6.add(lblNombre, "cell 3 3,alignx left,aligny center");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_6.add(textField_1, "cell 5 3,alignx left,aligny top");
		
		JSeparator separator_2 = new JSeparator();
		panel_6.add(separator_2, "cell 0 4 7 1");
		JLabel lblContrasea = new JLabel("CONTRASEÑA");
		panel_6.add(lblContrasea, "cell 3 5,alignx left,aligny center");
		
		passwordField = new JPasswordField();

		panel_6.add(passwordField, "cell 5 5,growx,aligny top");


	}
	
	public void setDatosUsuario(Usuario user) {
		
		this.passwordField.setText(user.getClave());
		this.textField.setText(user.getId());
		this.textField_1.setText(user.getNombre());
	}
}
