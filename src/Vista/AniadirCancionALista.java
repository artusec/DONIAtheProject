package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import Controlador.ControlCancion;
import Controlador.ControlLista;
import Model.Objetos.Cancion;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class AniadirCancionALista extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private ControlCancion ctrlCancion;
	private ControlLista ctrlLista;

	/**
	 * Create the panel.
	 */
	public AniadirCancionALista(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00F1adir canci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setVerticalAlignment(SwingConstants.BOTTOM);
		
		textField = new JTextField();
		textField.setColumns(10);

		
		JButton btnAadir = new JButton("A\u00F1adir");
		
		
		JLabel lblNewLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAadir)))
					.addGap(106))
		);
		
		ctrlCancion = new ControlCancion(ventanaPrincipal.getUsuarioActual());
		ctrlLista = new ControlLista(ventanaPrincipal.getUsuarioActual());
		
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cancion aAniadir = ctrlCancion.consultaCancion(textField.getText());
				if (aAniadir != null) {
					ctrlLista.anadirCancion(aAniadir, ventanaPrincipal.getPanelListas().getModelo().listaSel());
					ventanaPrincipal.getPanelCanciones().getModelo().lista.add(aAniadir);
				}
				else
					lblNewLabel.setText("Canci�n no encontrada");
			}
		});
		

		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAadir)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addGap(46)
					.addComponent(lblNewLabel)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNombre, textField, btnAadir}));

	}

}
