package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Controlador.ControlCancion;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EliminarCancion_panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private ControlCancion ctrlC;

	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public EliminarCancion_panel(VentanaPrincipal ventanaPrincipal) {
		
		ctrlC = new ControlCancion(ventanaPrincipal.getUsuarioActual());
		setBorder(new TitledBorder(null, "ELIMINAR CANCION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Introduce el ID de la Cancion");
		
		JButton btnEliminarCancion = new JButton("Eliminar Cancion");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblNewLabel)
							.addGap(34)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(175)
							.addComponent(btnEliminarCancion)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(176, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnEliminarCancion)
					.addGap(313))
		);
		btnEliminarCancion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals(ctrlC.consultaCancion(textField.getText().trim()).getId())) {
					ctrlC.eliminaCancion(ctrlC.consultaCancion(textField.getText().trim()));
				}
				
			}
		});
		panel.setLayout(gl_panel);
		
		

	}
}
