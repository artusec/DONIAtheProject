package Controlador.DAO;

import Modelo.Objetos.*;

public interface InterfazDAOFachada {
    Genero getGeneroDB(String idGenero);
    Cancion getCancionDB(String idCancion);
    Lista getListaDB(String idLista);
    Usuario getUsuarioDB(String idUsuario, String clave);
    void setCancion(Cancion cancion);
    void setGenero(Genero genero);
    void setUsuario(Usuario usuario);
    void setLista(Lista lista);
}
