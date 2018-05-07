package Vista;

import Model.Objetos.Cancion;

public class ModeloTablaCanciones extends ModeloTabla<Cancion> {

	private static final long serialVersionUID = 1L;
	
	public ModeloTablaCanciones(String[] columnIdCanciones/*, Controlador ctrl*/)
	{
		super(columnIdCanciones/*, ctrl*/);
	}
	
	 @Override
	 public Object getValueAt(int indiceFil, int indiceCol) {
		 Object s = null;
		 switch (indiceCol) {
		 case 0: s = indiceFil; break;
		 case 1: s = this.lista.get(indiceFil).getTitulo(); break;
		 case 2: s = this.lista.get(indiceFil).getAutor(); break;
		 case 3: s = this.lista.get(indiceFil).getGenero(); break;
		 case 4: s = this.lista.get(indiceFil).getDuracion(); break;
		 default: assert (false);
		 }
		 return s;
	 }
	 
	 // ...
}
