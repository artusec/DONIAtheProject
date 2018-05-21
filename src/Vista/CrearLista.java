package Vista;

import javax.swing.JPanel;
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
import net.miginfocom.swing.MigLayout;

/**
 * Clase que crea el panel con los campos para crear una lista vacia y añadirla a la base de datos.
 */
public class CrearLista extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField entradaNombre;

	/**
	 * Crea un panel con un campo de texto para escribir el nombre de la lista a crear y un botón que realiza las llamadas necesarias para crear la lista vacía.
	 * @param ventanaPrincipal ventana principal donde se ve toda la información.
	 */
	public CrearLista(VentanaPrincipal ventanaPrincipal) {
		
		setBorder(new TitledBorder(null, "Crear lista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnCrear = new JButton("Crear");
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		setLayout(new MigLayout("", "[116.00px][184.00px,grow,center][159px]", "[26px][16px][29px,grow]"));
		
		entradaNombre = new JTextField();
		entradaNombre.setColumns(10);
		entradaNombre.setText("");
		add(entradaNombre, "cell 1 0,growx,aligny top");
		
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
		add(lblNewLabel, "cell 0 0,alignx right,aligny center");
				
				JLabel lblNombreInvalido = new JLabel("NOMBRE INVALIDO");
				add(lblNombreInvalido, "cell 1 1,alignx center,aligny top");
				lblNombreInvalido.setVisible(false);
				
				add(btnCrear, "cell 1 2,alignx center,aligny top");
				
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
	}
}
