package Vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * Panel para representar listas.
 * @param <T> contenido de la lista.
 */
public class PanelDePaneles<T> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ListModel<T> listModel;
	protected JList<T> objList;
	
	/**
	 * Constructora. Crea el panel con el título pasado por parámetro.
	 * @param titulo Título del Titled border.
	 */
	public PanelDePaneles(String titulo) {
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(titulo));
		this.listModel = new ListModel<T>();
		this.objList = new JList<T>(this.listModel);
		this.add(new JScrollPane(objList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
	}
	
	/**
	 * Devuelve una lista con los elementos seleccionados.
	 * @return Lista de componentes tipo "T" que han sido seleccionados en la vista.
	 */
	public ArrayList<T> getSelectedItems() {
		ArrayList<T> l = new ArrayList<>();
		for (int i : this.objList.getSelectedIndices()) {
			l.add(listModel.getElementAt(i));
		}
		return l;
	}
	
	/**
	 * Devuelve un único elemento seleccionado de la lista.
	 * @return T
	 */
	public T getSelectedItem() {
		int i = this.objList.getMinSelectionIndex();
		if (i < 0)
			return null;
		return listModel.getElementAt(i);
	}
	
	/**
	 * Establece el modelo de lista a partir de un parámetro
	 * @param lista Lista parametrizable por T a la cual se actualiza nuestro parámetro lista.
	 */
	public void setList(ArrayList<T> lista) {
		this.listModel.setList(lista);
	}

	/**
	 * Devuelve el modelo de lista.
	 * @return Lista de objetos tipo "T".
	 */
	public ListModel<T> getModelo() {
		return listModel;
	}
	
	/**
	 * Borra las selecciones de la lista.
	 */
	public void borrarSeleccionado() {
		
		objList.clearSelection();
	}
}