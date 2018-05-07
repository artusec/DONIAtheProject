package Model.Lista;
import java.util.List;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazSASLista {
	public Lista consulta(String idLista);
	public void borrar(Lista lista);
	public void modificar(String nombre, Lista lista) throws ErrorAutenticacion;
	public void crearLista(String nombre) throws ErrorAutenticacion, ErrorCreacionObjeto;
	public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion;
	public void anadirCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion;
	public void eliminarCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion;
}
