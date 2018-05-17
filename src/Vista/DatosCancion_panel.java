package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import Controlador.ControlCancion;
import Model.Objetos.Cancion;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DatosCancion_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titulo;
	private JTextField artista;
	private JTextField duracion;
	private JTextField genero;
	private Enlaces_panel enlacesPanel;
	private JButton btnEnlaces;

	/**
	 * Create the panel.
	 */
	public DatosCancion_panel(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(null, "Datos de la canción", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDuracin = new JLabel("Duración");
		lblDuracin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblGnero = new JLabel("Género");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		titulo = new JTextField();
		titulo.setEditable(false);
		titulo.setColumns(10);
		
		artista = new JTextField();
		artista.setEditable(false);
		artista.setColumns(10);
		
		duracion = new JTextField();
		duracion.setEditable(false);
		duracion.setColumns(10);
		
		genero = new JTextField();
		genero.setEditable(false);
		genero.setColumns(10);
		
		enlacesPanel = new Enlaces_panel(ventanaPrincipal);

		
		btnEnlaces = new JButton("Enlaces");
		btnEnlaces.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.verPanelCancion();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEnlaces)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(artista, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
							.addComponent(lblArtista)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTtulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(154))
							.addComponent(titulo, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGnero)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(genero, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(1))
						.addComponent(duracion, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDuracin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(23)))
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(lblDuracin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(duracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArtista)
						.addComponent(lblGnero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(artista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(genero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(btnEnlaces)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	public void setDatos(Cancion cancion) {	
		if(cancion != null) {
			this.titulo.setText(cancion.getTitulo());
			this.artista.setText(cancion.getAutor());
			this.genero.setText(cancion.getGenero().toString());
			Double duracion = cancion.getDuracion();
			int min = (int) (duracion / 60);
			int seg = (int) (duracion % 60);
			this.duracion.setText(Integer.toString(min) + " min " + Integer.toString(seg) + " seg");
			// enlace.setText(cancion.getVideo().getEnlace());
			// descarga.setText(cancion.getVideo().getEnlaceDescarga());
		}
	}

	public void vaciarCampos() {
		
		titulo.setText("");
		artista.setText("");
		duracion.setText("");
	}

	public void ocultarBoton() {
		btnEnlaces.setVisible(false);
	}

	public void verBoton() {
		btnEnlaces.setVisible(true);
	}
}
