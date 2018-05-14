package Vista;

import java.util.List;
import javax.swing.DefaultListModel;

import Model.Objetos.Cancion;

public class ListModel<T> extends DefaultListModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> lista;

	public ListModel() { 
		
		this.lista = null;
	}

	
	public void setList(List<T> lista) {
		this.lista = lista;
		fireContentsChanged(this, 0, this.lista.size());
	}
	
	@Override
	public T getElementAt(int index) {
		
		return lista.get(index);
	}
	
	@Override
	public int getSize() {
		
		return this.lista == null ? 0 : this.lista.size();
	}

	public Cancion cancionSel() {
		
		return null;
	}
}