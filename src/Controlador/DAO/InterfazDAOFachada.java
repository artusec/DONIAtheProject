package Controlador.DAO;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public interface InterfazDAOFachada {
	public Genero getGeneroDB(String idGenero);
	public Cancion getCancionDB(String idCancion);
	public Lista getListaDB(String idLista);
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion;
	public void setCancion(Cancion cancion);
	public void setGenero(Genero genero);
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion;
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion;
	public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion;
	public void borrarLista(Lista lista, Usuario usuarioActual);
	public void eliminarCancion(Cancion cancion);
	public ArrayList<Cancion> getCancionesGeneroDB(String id);
	public void borrarGeneroDB(Genero genero);
	public void borrarUsuario(Usuario usuario);
}
