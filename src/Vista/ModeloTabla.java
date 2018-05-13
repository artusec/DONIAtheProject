package Vista;

import java.util.List;

import javax.swing.JTable;

import Model.Objetos.Cancion;
import Model.Objetos.Lista;

public abstract class ModeloTabla<T> extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	protected String[] columnIds;
	protected List<T> lista;
	
	public ModeloTabla(String[] columnaCanciones) {
		super();
		this.setCellSelectionEnabled(true);
		this.lista = null;
		this.columnIds = columnaCanciones;
	}
	
	@Override
	public String getColumnName(int col)
	{
		return this.columnIds[col]; 
	}
	
	@Override
	public int getColumnCount() 
	{
		return this.columnIds.length;
	}
	
	@Override
	public int getRowCount() 
	{
		return this.lista == null ? 0 : this.lista.size();
	}
	
	public boolean isCellEditable (int row, int column) { return false; }
	
	 public Cancion cancionSel() {
		 if (isRowSelected(this.getSelectedRow()))
			 return (Cancion) lista.get(this.getSelectedRow());
		 else return null;
	 }
	 
	 public Lista listaSel() {
		 return (Lista) lista.get(this.getSelectedRow());
	 }
}
