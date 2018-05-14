package Vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import Controlador.ControlCancion;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorGuardado;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Letra;
import Model.Objetos.Video;

public class SongAdmin_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titulo;
	private JTextField autor;
	private JTextField duracion;
	private JTextField genero;
	private JTextField album;
	private JTextField video;
	private JTextField descarga;
	private JEditorPane letra;
	/**
	 * Create the panel.
	 */
	public SongAdmin_panel(VentanaPrincipal ventanaPrincipal) {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "NUEVA CANCION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "LETRA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		letra = new JEditorPane();
		letra.setText("Escribe aquí la letra");
		setLayout(new GridLayout(0, 2, 0, 0));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{199, 0};
		gbl_panel.rowHeights = new int[]{34, 16, 26, 16, 26, 16, 26, 26, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNombreDeLa = new JLabel("NOMBRE DE LA CANCIÓN");
		GridBagConstraints gbc_lblNombreDeLa = new GridBagConstraints();
		gbc_lblNombreDeLa.anchor = GridBagConstraints.NORTH;
		gbc_lblNombreDeLa.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombreDeLa.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreDeLa.gridx = 0;
		gbc_lblNombreDeLa.gridy = 1;
		panel.add(lblNombreDeLa, gbc_lblNombreDeLa);
		
		titulo = new JTextField();
		titulo.setColumns(10);
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.anchor = GridBagConstraints.NORTH;
		gbc_titulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_titulo.insets = new Insets(0, 0, 5, 0);
		gbc_titulo.gridx = 0;
		gbc_titulo.gridy = 2;
		panel.add(titulo, gbc_titulo);
		
		JLabel lblNombreDelArtista = new JLabel("NOMBRE DEL ARTISTA");
		GridBagConstraints gbc_lblNombreDelArtista = new GridBagConstraints();
		gbc_lblNombreDelArtista.anchor = GridBagConstraints.NORTH;
		gbc_lblNombreDelArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombreDelArtista.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreDelArtista.gridx = 0;
		gbc_lblNombreDelArtista.gridy = 3;
		panel.add(lblNombreDelArtista, gbc_lblNombreDelArtista);
		
		autor = new JTextField();
		autor.setColumns(10);
		GridBagConstraints gbc_autor = new GridBagConstraints();
		gbc_autor.anchor = GridBagConstraints.NORTH;
		gbc_autor.fill = GridBagConstraints.HORIZONTAL;
		gbc_autor.insets = new Insets(0, 0, 5, 0);
		gbc_autor.gridx = 0;
		gbc_autor.gridy = 4;
		panel.add(autor, gbc_autor);
		
		JLabel label = new JLabel("ALBUM");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 5;
		panel.add(label, gbc_label);
		
		album = new JTextField();
		album.setColumns(10);
		GridBagConstraints gbc_album = new GridBagConstraints();
		gbc_album.insets = new Insets(0, 0, 5, 0);
		gbc_album.fill = GridBagConstraints.HORIZONTAL;
		gbc_album.gridx = 0;
		gbc_album.gridy = 6;
		panel.add(album, gbc_album);
		
		JLabel lblGnero = new JLabel("GÉNERO");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 0);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 7;
		panel.add(lblGnero, gbc_lblGnero);
		
		genero = new JTextField();
		genero.setColumns(10);
		GridBagConstraints gbc_genero = new GridBagConstraints();
		gbc_genero.insets = new Insets(0, 0, 5, 0);
		gbc_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_genero.gridx = 0;
		gbc_genero.gridy = 8;
		panel.add(genero, gbc_genero);
		
		JLabel lblDuracin = new JLabel("DURACIÓN");
		GridBagConstraints gbc_lblDuracin = new GridBagConstraints();
		gbc_lblDuracin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDuracin.insets = new Insets(0, 0, 5, 0);
		gbc_lblDuracin.gridx = 0;
		gbc_lblDuracin.gridy = 9;
		panel.add(lblDuracin, gbc_lblDuracin);
		
		duracion = new JTextField();
		duracion.setColumns(10);
		GridBagConstraints gbc_duracion = new GridBagConstraints();
		gbc_duracion.anchor = GridBagConstraints.NORTH;
		gbc_duracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_duracion.insets = new Insets(0, 0, 5, 0);
		gbc_duracion.gridx = 0;
		gbc_duracion.gridy = 10;
		panel.add(duracion, gbc_duracion);
		
		JLabel label_1 = new JLabel("ENLACE");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 11;
		panel.add(label_1, gbc_label_1);
		
		video = new JTextField();
		video.setColumns(10);
		GridBagConstraints gbc_video = new GridBagConstraints();
		gbc_video.insets = new Insets(0, 0, 5, 0);
		gbc_video.fill = GridBagConstraints.HORIZONTAL;
		gbc_video.gridx = 0;
		gbc_video.gridy = 12;
		panel.add(video, gbc_video);
		
		JLabel label_2 = new JLabel("DESCARGA");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 13;
		panel.add(label_2, gbc_label_2);
		
		descarga = new JTextField();
		descarga.setColumns(10);
		GridBagConstraints gbc_descarga = new GridBagConstraints();
		gbc_descarga.insets = new Insets(0, 0, 5, 0);
		gbc_descarga.fill = GridBagConstraints.HORIZONTAL;
		gbc_descarga.gridx = 0;
		gbc_descarga.gridy = 14;
		panel.add(descarga, gbc_descarga);
		
		JButton btnHecho = new JButton("HECHO");
		btnHecho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ventanaPrincipal.entradaValida(titulo.getText()) &&
					ventanaPrincipal.entradaValida(autor.getText()) &&
					ventanaPrincipal.entradaValida(genero.getText()) &&
					ventanaPrincipal.entradaValida(album.getText()) &&
					Integer.parseInt(duracion.getText()) > 0) {
					System.out.println("Entrada datos cancion valida");
					try {
						Genero generoNuevo = new Genero(genero.getText());
						Video videoNuevo = new Video(ventanaPrincipal.generaId(), video.getText(), descarga.getText());
						Letra letraNueva = new Letra(ventanaPrincipal.generaId(), letra.getText());
						ControlCancion controlC = new ControlCancion(ventanaPrincipal.getUsuarioActual());
						Cancion cancionNueva;
						cancionNueva = new Cancion(ventanaPrincipal.generaId(), titulo.getText(), autor.getText(),
								album.getText(), Integer.parseInt(duracion.getText()), letraNueva, videoNuevo, generoNuevo);
						System.out.println("creacion cancion ok, guardando en db");
						controlC.creaCancion(cancionNueva);
					} catch (NumberFormatException | ErrorCreacionObjeto e1) {
						VentanaPrincipal.muestraError(e1);
					}
				} else {
					VentanaPrincipal.muestraError(new ErrorGuardado("Imposible guardar cancion"));
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 16;
		panel.add(separator, gbc_separator);
		GridBagConstraints gbc_btnHecho = new GridBagConstraints();
		gbc_btnHecho.insets = new Insets(0, 0, 5, 0);
		gbc_btnHecho.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHecho.anchor = GridBagConstraints.NORTH;
		gbc_btnHecho.gridx = 0;
		gbc_btnHecho.gridy = 17;
		panel.add(btnHecho, gbc_btnHecho);
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(letra);

	}
}
