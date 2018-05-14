package Vista;


import Controlador.ControlCancion;
import Controlador.ControlLista;
import Model.Objetos.Cancion;

public class ModeloTablaCanciones extends ModeloTabla<Cancion> {

	private static final long serialVersionUID = 1L;

	public ModeloTablaCanciones(String[] columnIdCanciones) {
		super(columnIdCanciones);
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
	 
	 /*SGURO QUE ESTO SE HACE AQUI??
	 public void actualizarDatos(String idLista) {
		 lista.clear();
		 ControlLista control = new ControlLista(ventanaPrincipal.getUsuarioActual());
		 lista.addAll(control.consulta(idLista).getCanciones());
	 }*/
}
