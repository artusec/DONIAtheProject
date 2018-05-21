package Vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import Controlador.ControlGenero;
import Model.Objetos.Genero;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Clase que crea el panel que contiene los géneros que le han gustado al usuario.
 */
public class PanelGeneros extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructora. Crea el panel y accede a la base de datos para ver los géneros favoritos del usuario. A su 
	 * vez contiene un botón que borra el género musical seleccionado de la lista de gustos.
	 * @param panelFavoritos Panel de géneros.
	 * @param ventanaPrincipal Panel principal de la aplicación.
	 */
	PanelGeneros(PanelDePaneles<Genero> panelFavoritos, VentanaPrincipal ventanaPrincipal) {

			setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Géneros"));
			JPanel panel = new JPanel();
			JButton boton = new JButton("Eliminar");
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Genero> generos = ventanaPrincipal.getGeneroSeleccionado();
					if (generos != null && !generos.isEmpty())
					for (Genero g: generos) {
						ControlGenero controlGenero = new ControlGenero(ventanaPrincipal.getUsuarioActual());
						controlGenero.Eliminar(g);
					}
				}
			});
			panel.add(new JLabel(""), BorderLayout.SOUTH);
			panel.add(boton, BorderLayout.NORTH);
			panel.setSize(100, 1000);
			
			panelFavoritos.setVisible(true);
			setLayout(new MigLayout("", "[438px]", "[237px,grow][33px,bottom]"));
			panelFavoritos.setOpaque(false);
			add(panelFavoritos, "cell 0 0,grow");
			add(panel, "cell 0 1,growx,aligny top");
	 }
}