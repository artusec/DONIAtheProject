package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazSASLista {
	public Lista consulta(String idLista) throws ErrorConsulta;
	public void borrar(Lista lista, Usuario usuario);
	public void modificar(String nombre, Lista lista, Usuario usuario) throws ErrorAutenticacion;
	public void crearLista(String nombre, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto;
	public void crearListaAuto(String nombre, Genero genero, Usuario usuario, int duracion) throws ErrorAutenticacion, ErrorCreacionObjeto;
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion;
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion;
}
