package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import Controlador.ControlGenero;
import Controlador.ControlLista;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Genero;
import Model.Objetos.ListaAuto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CrearListaAuto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField; //NOmbre
	private JTextField textField_1; //Genero
	private JTextField textField_2; //Duracion

	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public CrearListaAuto(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(null, "Crear lista autom\u00E1tica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblGenero = new JLabel("G\u00E9nero:");
		
		JLabel lblDuracinMaxima = new JLabel("Duraci\u00F3n maxima:");
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText("");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText("");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText("");

		
		ControlLista ctrl = new ControlLista(ventanaPrincipal.getUsuarioActual());
		ControlGenero ctrlGenero = new ControlGenero(ventanaPrincipal.getUsuarioActual());
		
		JButton btnCrear = new JButton("Crear");
		
		JLabel lblNewLabel = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(195)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDuracinMaxima)
								.addComponent(lblGenero)
								.addComponent(lblNombre))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(textField_1)
								.addComponent(textField_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenero)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuracinMaxima)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnCrear)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("") && !textField_1.getText().equals("") && !textField_2.getText().equals("")) {
					Genero genero = ctrlGenero.Consultar(textField_1.getText());
					try {
						ListaAuto lista = new ListaAuto("", textField.getText(), genero);
						ctrl.crearListaAuto(lista, genero, Integer.parseInt(textField_2.getText()));
					} catch (ErrorCreacionObjeto e1) {
						e1.printStackTrace();
					}
				}
				else {
					lblNewLabel.setText("Rellena todos los campos para crear la lista correctamente");
				}
			}
		});
		setLayout(groupLayout);

	}

}
