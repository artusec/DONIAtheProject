package Controlador.DAO;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public interface InterfazSASDAO {
	// GET
	public Genero getGeneroDB(String idGenero);
	public Cancion getCancionDB(String idCancion);
	public ArrayList<Cancion> getCancionesGeneroDB(String id);
	public Lista getListaDB(String idLista);
	public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion;
	public long getUltimoIdCancion();
	public long getUltimoIdLista();
	public long getUltimoIdGenero();
	// SET
	public void setCancion(Cancion cancion);
	public void setGenero(Genero genero, Usuario usuario);
	public void setUsuario(Usuario usuario) throws ErrorAutenticacion;
	public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion;
	public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion;
	// ELIMINAR
	public void eliminarLista(Lista lista, Usuario usuarioActual);
	public void eliminarCancion(Cancion cancion);
	public void eliminarGenero(Genero genero, Usuario usuario);
	public void eliminarUsuario(Usuario usuario);
}
