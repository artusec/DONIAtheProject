package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazListaFachada {
	public Lista consulta(String idLista);
	public void borrar(Lista lista);
	public void modificar(String nombre, Lista lista) throws ErrorAutenticacion;
	public void crearLista(String nombre) throws ErrorAutenticacion, ErrorCreacionObjeto;
	public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion, ErrorCreacionObjeto;
	public void anadirCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion;
	public void eliminarCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion;
}
