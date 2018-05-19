package Vista;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 * Clase para gestionar un modelo de lista.
 * @param <T>
 */
public class ListModel<T> extends DefaultListModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> lista;

	/**
	 * Constructora. Inicializa la lista a null.
	 */
	public ListModel() { 
		
		this.lista = null;
	}

	/**
	 * Establece la lista a una proporcionada por parámetro.
	 * @param lista
	 */
	public void setList(List<T> lista) {
		this.lista = lista;
		fireContentsChanged(this, 0, this.lista.size());
	}
	

	/**
	 * Devuelve el elemento que se encuentre en la posicion indicada por el parámetro.
	 * @param index. Índice de la lista.
	 */
	@Override
	public T getElementAt(int index) {
		
		return lista.get(index);
	}
	
	/**
	 * Devuelve el tamaño de la lista.
	 */
	@Override
	public int getSize() {
		
		return this.lista == null ? 0 : this.lista.size();
	}
}