package Vista;

import Model.Objetos.Lista;

public class ModeloTablaListas extends ModeloTabla<Lista> {

	private static final long serialVersionUID = 1L;

	public ModeloTablaListas(String[] columnaCanciones/*, Controlador ctrl*/) {
		super(columnaCanciones/*, ctrl*/);
	}

	@Override
	 public Object getValueAt(int indiceFil, int indiceCol) {
		 Object s = null;
		 switch (indiceCol) {
		 case 0: s = indiceFil; break;
		 case 1: s = this.lista.get(indiceFil).getNombre(); break;
		 case 2: s = this.lista.get(indiceFil).getDuracion(); break;
		 case 3: s = this.lista.get(indiceFil).getGenero(); break;
		 default: assert (false);
		 }
		 return s;
	 }
	
	// ...
}
