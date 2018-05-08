package Vista;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Controlador;


public class PanelBarraEstado extends JPanel implements ObservadorAplicacion
{
	private static final long serialVersionUID = 1L;
	private JLabel infoEjecucion;
	
	public PanelBarraEstado(String mensaje, Controlador controlador)
	{
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.infoEjecucion = new JLabel(mensaje);
		this.add(this.infoEjecucion);
		this.setBorder(BorderFactory.createBevelBorder(1));
		controlador.addObservador(this);
	}
	
	// Faltan los metodos del Observador:
	
	/*
	@Override
	public void reinicia()
	{
		this.infoEjecucion.setText("");
	}
	
	@Override
	public void cargaCancion()
	{
		this.infoEjecucion.setText(cancion.getTitulo() + " - " + cancion.getAutor() + " - Duracion: " + cancion.getDuracion());
	}
	*/
}

