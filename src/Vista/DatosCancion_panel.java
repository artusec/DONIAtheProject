package Vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import Model.Objetos.Cancion;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class DatosCancion_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titulo;
	private JTextField artista;
	private JTextField duracion;
	private JTextField genero;
	private JTextField enlace;
	private JTextField descarga;

	/**
	 * Create the panel.
	 */
	public DatosCancion_panel() {
		setBorder(new TitledBorder(null, "Datos de la canción", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblTtulo = new JLabel("Título");
		lblTtulo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblDuracin = new JLabel("Duración");
		lblDuracin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblGnero = new JLabel("Género");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblEnlace = new JLabel("Enlace de descarga");
		lblEnlace.setFont(new Font("Arial Black", Font.ITALIC, 14));
		lblEnlace.setBackground(Color.MAGENTA);
		
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
		
		enlace = new JTextField();
		enlace.setEnabled(true);
		enlace.setColumns(10);
		
		JLabel lblEnlaceVerVideoclip = new JLabel("Enlace ver videoclip");
		lblEnlaceVerVideoclip.setFont(new Font("Arial Black", Font.ITALIC, 14));
		
		descarga = new JTextField();
		descarga.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(artista, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTtulo)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtista))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(duracion, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGnero)
						.addComponent(genero, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDuracin))
					.addGap(23))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(lblEnlace, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(lblEnlaceVerVideoclip, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addComponent(descarga, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(enlace, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTtulo)
						.addComponent(lblDuracin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(duracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(titulo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGnero)
						.addComponent(lblArtista))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(artista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(genero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEnlace)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(enlace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEnlaceVerVideoclip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(descarga, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
			String a = String.valueOf(duracion);
			this.duracion.setText(Integer.toString(min) + " min " + Integer.toString(seg) + " seg");
			enlace.setText(cancion.getVideo().getEnlace());
			descarga.setText(cancion.getVideo().getEnlaceDescarga());
		}
		
	}

	public void vaciarCampos() {
		
		titulo.setText("");
		artista.setText("");
		duracion.setText("");
		enlace.setText("");
		descarga.setText("");
	}
}
