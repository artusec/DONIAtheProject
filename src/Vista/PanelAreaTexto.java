package Vista;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Controlador.ControlCancion;
import Model.Objetos.Cancion;
import Model.Objetos.Letra;

/**
 * Clase que se encarga de mostrar las letras de las canciones.
 */
public class PanelAreaTexto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextArea areatexto;
	
	/**
	 * Constructora. 
	 * @param titulo
	 * @param editable
	 */
	 public PanelAreaTexto(String titulo, boolean editable) {	
		 
		this.setLayout(new GridLayout(1,1));
		this.areatexto = new JTextArea(40, 30);
		this.areatexto.setEditable(editable);
		this.add(new JScrollPane(areatexto));
		this.setBorde(titulo);
		areatexto.setLineWrap(true);
	 }
	 
	 /**
	  * Crea un borde de tipo "Titled border" con el parámetro de entrada.
	  * @param titulo
	  */
	 public void setBorde(String titulo){
		 
		 this.setBorder(BorderFactory.createTitledBorder(titulo));
	 }
	 
	 /**
	  * Devuelve el texto que hay en el panel.
	  * @return String - Texto del panel.
	  */
	 public String getTexto() {
		 
		 return areatexto.getText();
	 }
	 
	 /**
	  * Establece el texto del panel. Obtiene el usuario actual de la sesión y consulta en la base de datos
	  * la cancion que se va a escribir en caso de que exista dicha letra.
	  * @param cancion
	  * @param ventanaPrincipal
	  */
	 public void setTexto(Cancion cancion, VentanaPrincipal ventanaPrincipal) {
		 
		 ControlCancion ctrl = new ControlCancion(ventanaPrincipal.getUsuarioActual());
		 Letra letra = ctrl.consultaLetra(cancion.getId());
		 if (letra != null)
			 areatexto.setText(letra.getTexto());
	 }
	 
	 /**
	  * Escribe en el panel de texto la cadena que le pasan por parámetro.
	  * @param string
	  */
	 public void setTexto(String string) {
		 
		 this.areatexto.setText(string);
	 }
	 
	 /**
	  * Pone a vacío el texto del panel.
	  */
	 public void limpiar()  {
		 
		 this.areatexto.setText("");
	 }
	 
	 /**
	  * Inserta una cadena de caracteres en el area de texto.
	  * @param valor
	  */
	 public void inserta(String valor) {
		 
		 this.areatexto.insert(valor, this.areatexto.getCaretPosition());
	 }
	 
	 /**
	  * Devuelve el panel de area de texto.
	  * @return JTextArea
	  */
	 public JTextArea getAreaTexto() {
		 
		 return areatexto;
	 }
}
