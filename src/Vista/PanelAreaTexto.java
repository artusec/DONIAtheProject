package Vista;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Controlador.ControlCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Letra;

public class PanelAreaTexto extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JTextArea areatexto;
	
	 public PanelAreaTexto(String titulo, boolean editable) 
	 {		
		this.setLayout(new GridLayout(1,1));
		this.areatexto = new JTextArea(40, 30);
		this.areatexto.setEditable(editable);
		this.add(new JScrollPane(areatexto));
		this.setBorde(titulo);
		areatexto.setLineWrap(true);
	 }
	 
	 
	 public void setBorde(String titulo)
	 {
		 this.setBorder(BorderFactory.createTitledBorder(titulo));
	 }
	 
	 public String getTexto()
	 {
		 return areatexto.getText();
	 }
	 
	 public void setTexto(Cancion cancion, VentanaPrincipal ventanaPrincipal) {
		 ControlCancion ctrl = new ControlCancion(ventanaPrincipal.getUsuarioActual());
		 Letra letra = ctrl.consultaLetra(cancion.getId());
		 if (letra != null)
			 areatexto.setText(letra.getTexto());
	 }
	 
	 public void setTexto(String string) {
		 
		 this.areatexto.setText(string);
	 }
	 
	 public void limpiar() 
	 {
		 this.areatexto.setText("");
	 }
	 public void inserta(String valor) 
	 {
		 this.areatexto.insert(valor, this.areatexto.getCaretPosition());
	 }
	 
	 public JTextArea getAreaTexto()
	 {
		 return areatexto;
	 }
}
