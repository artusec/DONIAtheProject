package Vista;

import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Model.Objetos.Cancion;
import Model.Objetos.Lista;

public class ModeloTablaListas extends ModeloTabla<Lista> {

	private static final long serialVersionUID = 1L;
	
	private ControlLista controlLista;
	private ControlUsuario controlUsuario;

	public ModeloTablaListas(String[] columnaCanciones, ControlLista controladorLista, ControlUsuario controladorUsuario) {
		super(columnaCanciones);
		controlLista = controladorLista;
		controlUsuario = controladorUsuario;
	}

	@Override
	 public Object getValueAt(int indiceFil, int indiceCol) {
		 Object s = null;
		 switch (indiceCol) {
		 case 0: s = indiceFil; break;
		 case 1: s = this.lista.get(indiceFil).getNombre(); break;
		 case 2: s = this.lista.get(indiceFil).getDuracion(); break;
		 default: assert (false);
		 }
		 return s;
	 }
	
	
	 public void actualizarDatos(String idLista) {
		 lista.clear();
		 lista.addAll(controlUsuario.getUsuario().getListas()); //�No habria que crear esa funcion?
	 }
	 
	 public Cancion cancionSel() {
		 return null;
	 }
}