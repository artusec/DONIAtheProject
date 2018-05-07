package Model.Lista;
import java.util.List;

import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public interface InterfazSASLista {
	public Lista consulta(String idLista);
	public void borrar(Lista lista);
	public void modificar(String nombre, Lista lista) throws ErrorAutenticacion;
	public void crearLista(String nombre) throws ErrorAutenticacion;
	public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion;
	public void anadirCancion(Cancion cancion, Lista lista);
	public void eliminarCancion(Cancion cancion, Lista lista);
}
