package Vista;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.ControlCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Video;
import net.miginfocom.swing.MigLayout;

public class Enlaces_panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */

	public Enlaces_panel(VentanaPrincipal ventanaPrincipal) {
		setLayout(new MigLayout("", "[363.00,center][55.00,grow,left]", "[20px][][22px][20px][22px][25px][][][][][][]"));
		
		JLabel lblEnlaceVerVideo = new JLabel("Ver video");
		lblEnlaceVerVideo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		add(lblEnlaceVerVideo, "cell 0 1,alignx center,aligny top");
		
		textField = new JTextField();
		textField.setColumns(10);
		add(textField, "cell 0 2,growx,aligny top");
		
		JButton botonVer = new JButton("Ver");
		botonVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
						Desktop.getDesktop().browse(new URI(textField.getText()));
					} catch (IOException | URISyntaxException e1) {
						VentanaPrincipal.muestraError(new Exception("Dirección incorrecta!"));
					}
				}
			}
		});
		add(botonVer, "cell 1 2");
		
		JLabel lblNewLabel = new JLabel("Enlace descarga");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		add(lblNewLabel, "cell 0 4,alignx center,aligny top");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		add(textField_1, "cell 0 5,growx,aligny top");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.verPanelLetras();
			}
		});
		
		JButton botonDesc = new JButton("Descargar");
		botonDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
						Desktop.getDesktop().browse(new URI(textField_1.getText()));
					} catch (IOException | URISyntaxException e1) {
						VentanaPrincipal.muestraError(new Exception("Dirección incorrecta!"));
					}
				}
			}
		});
		add(botonDesc, "cell 1 5");
		add(btnVolver, "cell 0 9,alignx center,aligny top");
		
		setVisible(true);

	}
	
	public void setDatos(Cancion cancion, VentanaPrincipal ventanaPrincipal) {
		ControlCancion ctrl = new ControlCancion(ventanaPrincipal.getUsuarioActual());
		Video video = ctrl.consultaVideo(cancion.getId());
		if (video != null) {
			this.textField.setText(video.getEnlace());
			this.textField_1.setText(video.getEnlaceDescarga());
		}
	}

	public void vaciarCampos() {
		this.textField.setText("");
		this.textField_1.setText("");		
	}
}
