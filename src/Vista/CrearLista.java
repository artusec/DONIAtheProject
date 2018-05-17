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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		JLabel lblNombreInvalido = new JLabel("NOMBRE INVALIDO");// DefaultComponentFactory.getInstance().createLabel("NOMBRE INVALIDO");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(196)
							.addComponent(btnCrear))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombreInvalido)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(entradaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNombreInvalido)
					.addGap(57)
					.addComponent(btnCrear)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		lblNombreInvalido.setVisible(false);
		
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListaNormal lista;
					String nombre = "Nueva lista";
					if (entradaNombre.getText() != null && !entradaNombre.getText().equals("") &&
							VentanaPrincipal.entradaValida(entradaNombre.getText())) {
						nombre = entradaNombre.getText();
						lista = new ListaNormal(ventanaPrincipal.generaId(), nombre);
						ControlLista controlador = new ControlLista(ventanaPrincipal.getUsuarioActual());
						controlador.crearLista(lista);
						lblNombreInvalido.setVisible(false);
					}
					else {
						lblNombreInvalido.setVisible(true);
					}
				} catch (ErrorCreacionObjeto e1) {
					VentanaPrincipal.muestraError(e1);
				}
			}
			});
		
		entradaNombre.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                		btnCrear.doClick();
                }
			}
		});
	}
}
