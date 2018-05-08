package Vista;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public abstract class ModeloTabla<T> extends DefaultTableModel implements ObservadorAplicacion {
	
	private static final long serialVersionUID = 1L;
	
	protected String[] columnIds;
	protected List<T> lista;
	
	public ModeloTabla(String[] columnaCanciones, Controlador ctrl) {
		this.lista = null;
		this.columnIds = columnaCanciones;
		ctrl.addObservador(this);
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
}

