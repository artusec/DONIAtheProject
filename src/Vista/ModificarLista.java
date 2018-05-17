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
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;

public class ModificarLista extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField entradaNombre;

	/**
	 * Create the panel.
	 * @param ventanaPrincipal 
	 */
	public ModificarLista(VentanaPrincipal ventanaPrincipal) {
		
		setBorder(new TitledBorder(null, "Crear lista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton botonModificar = new JButton("Guardar nuevo nombre");
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		setLayout(new MigLayout("", "[54px][18px,grow][190px]", "[26px][16px][29px,grow]"));
		
		entradaNombre = new JTextField();
		entradaNombre.setColumns(10);
		entradaNombre.setText("");
		add(entradaNombre, "cell 1 0,alignx center,aligny top");
		
		entradaNombre.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                		botonModificar.doClick();
                }
			}
		});
		add(lblNewLabel, "cell 0 0,alignx right,aligny center");
				
				JLabel lblNombreInvalido = new JLabel("NOMBRE INVALIDO");
				add(lblNombreInvalido, "cell 1 1,alignx center,aligny top");
				lblNombreInvalido.setVisible(false);
		
				add(botonModificar, "cell 1 2,alignx center,aligny top");
				
				
				botonModificar.addActionListener(new ActionListener() {
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
							} else {
								lblNombreInvalido.setVisible(true);
							}
						} catch (ErrorCreacionObjeto e1) {
							VentanaPrincipal.muestraError(e1);
						}
					}
				});
	}
}
