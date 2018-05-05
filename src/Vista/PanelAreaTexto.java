package Vista;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	 }
	 
	 
	 public void setBorde(String titulo)
	 {
		 this.setBorder(BorderFactory.createTitledBorder(titulo));
	 }
	 
	 public String getTexto()
	 {
		 return areatexto.getText();
	 }
	 
	 public void setTexto(String texto)
	 {
		 this.areatexto.setText(texto);
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
