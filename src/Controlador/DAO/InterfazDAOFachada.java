package Controlador.DAO;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public interface InterfazDAOFachada {
	// GET
	public Genero getGeneroDB(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto;
	public Cancion getCancionDB(String idCancion) throws ErrorCreacionObjeto, ErrorConsulta;
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto;
	public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto;
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
	// SET
	public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto;
	public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
	// ELIMINAR
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion, ErrorEliminacion;
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion;
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
}
