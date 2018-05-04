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
    void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorContrasteDatos;
    void setCancion(Cancion cancion);
    void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorContrasteDatos;
}
