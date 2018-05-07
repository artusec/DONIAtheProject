package Controlador.DAO;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorContrasteDatos;
import Modelo.Objetos.*;

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
}
