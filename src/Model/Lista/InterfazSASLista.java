package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public interface InterfazSASLista {
	public Lista consulta(String idLista) throws ErrorConsulta, ErrorCreacionObjeto;
	public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion;
	public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void crearLista(String nombre, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado;
	public void crearListaAuto(ListaAuto lista, Genero genero, Usuario usuario, int duracion) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado;
}
