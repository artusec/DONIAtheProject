package Controlador.DAO;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorContrasteDatos;
import Modelo.Objetos.*;

public interface InterfazSASDAO {
    Cancion getCancionDB(String idCancion);
    Lista getListaDB(String idLista);
    Genero getGeneroDB(String idGenero);
    Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion;
    void setGenero(Genero genero);
    void setCancion(Cancion cancion);
    void setUsuario(Usuario usuario) throws ErrorAutenticacion;
    void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion;
	void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion;
}
