package Controlador.DAO;

import Modelo.Objetos.*;

public interface InterfazSASDAO {
    Cancion getCancionDB(String idCancion);
    ListaNormal getListaDB(String idLista);
    Genero getGeneroDB(String idGenero);
    Usuario getUsuarioDB(String idUsuario, String clave);
    void setGenero(Genero genero);
    void setLista(Lista lista);
    void setCancion(Cancion cancion);
    void setUsuario(Usuario usuario);
}
