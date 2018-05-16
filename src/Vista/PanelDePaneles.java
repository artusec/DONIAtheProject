package Vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class PanelDePaneles<T> extends JPanel {

	private static final long serialVersionUID = 1L;

	protected ListModel<T> listModel;
	protected JList<T> objList;
	
	public PanelDePaneles(String titulo) {
		
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder(titulo));
		this.listModel = new ListModel<T>();
		this.objList = new JList<T>(this.listModel);
		this.add(new JScrollPane(objList,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
	}
	
	public ArrayList<T> getSelectedItems() {
		ArrayList<T> l = new ArrayList<>();
		for (int i : this.objList.getSelectedIndices()) {
			l.add(listModel.getElementAt(i));
		}
		return l;
	}
	
	public T getSelectedItem() {
		int i = this.objList.getMinSelectionIndex();
		if (i < 0)
			return null;
		return listModel.getElementAt(i);
	}
	
	public void setList(ArrayList<T> lista) {
		this.listModel.setList(lista);
	}

	public ListModel<T> getModelo() {
		return listModel;
	}
	
	public void borrarSeleccionado() {
		
		objList.clearSelection();
	}
}