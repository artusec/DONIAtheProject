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
import Model.Objetos.Genero;
import Model.Objetos.ListaAuto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Clase que crea el panel que contiene los campos para añadir una lista automatica a la base de datos.
 */
public class CrearListaAuto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre; //NOmbre
	private JTextField genero; //Genero
	private JTextField duracion; //Duracion

	/**
	 * Crea un panel en el que escribes el nombre de la lista, el género sobre el que crearla y el tiempo máximo de duración.
	 * Tiene un botón que se encarga de realizar las llamadas necesarias para crear la lista automática.
	 * El género debe existir en la base de datos.
	 * Si no hay canciones suficientes para rellenar todo el tiempo deseado, se manda un mensaje a la vista.
	 * @param ventanaPrincipal ventana principal donde se ve toda la información.
	 */
	public CrearListaAuto(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(null, "Crear lista automatica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblGenero = new JLabel("Genero:");
		
		JLabel lblDuracinMaxima = new JLabel("Duracion maxima:");
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setText("");
		
		genero = new JTextField();
		genero.setColumns(10);
		genero.setText("");
		
		duracion = new JTextField();
		duracion.setColumns(10);
		duracion.setText("");
		
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
								.addComponent(nombre, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(genero)
								.addComponent(duracion)))
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
						.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenero)
						.addComponent(genero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDuracinMaxima)
						.addComponent(duracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(btnCrear)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gener = genero.getText();
				String nombr = nombre.getText();
				if (!nombre.getText().equals("") && !genero.getText().equals("") && Double.parseDouble(duracion.getText()) > 0 && 
						VentanaPrincipal.entradaValida(gener) && VentanaPrincipal.entradaValida(nombr)) {
					try {
						Genero nuevoGenero = new Genero(genero.getText());
						ListaAuto lista = new ListaAuto(ventanaPrincipal.generaId(), nombre.getText(), nuevoGenero);
						ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
						control.crearListaAuto(lista, Double.parseDouble(duracion.getText()));
						lblNewLabel.setVisible(false);
					} catch (ErrorCreacionObjeto e1) {
						VentanaPrincipal.muestraError(e1);
					}
				} else {
					lblNewLabel.setVisible(true);
					lblNewLabel.setText("Datos invalidos. Rellene los campos correctamente");
				}
			}
		});
		setLayout(groupLayout);

	}
}
