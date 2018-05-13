package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Controlador.ControlLista;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.ListaNormal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearLista extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField entradaNombre;

	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public CrearLista(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(null, "Crear lista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		
		entradaNombre = new JTextField();
		entradaNombre.setColumns(10);
		entradaNombre.setText("");
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListaNormal lista;
					String nombre = "Nueva lista";
					if (entradaNombre.getText() != null && !entradaNombre.getText().equals(""))
						nombre = entradaNombre.getText();
					lista = new ListaNormal(ventanaPrincipal.generaId(), nombre);
					ControlLista controlador = new ControlLista(ventanaPrincipal.getUsuarioActual());
					controlador.crearLista(lista);
				} catch (ErrorCreacionObjeto e1) {
					VentanaPrincipal.muestraError(e1);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(196)
							.addComponent(btnCrear)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addComponent(btnCrear)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
