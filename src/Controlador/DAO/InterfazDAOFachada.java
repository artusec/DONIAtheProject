package Controlador.DAO;

import Modelo.ObjetosModelo.Cancion;
import Modelo.ObjetosModelo.Genero;
import Modelo.ObjetosModelo.Lista;
import Modelo.ObjetosModelo.ListaNormal;
import Modelo.ObjetosModelo.Usuario;

public interface InterfazDAOFachada {
	
    Genero getGeneroDB(String idGenero);
    Cancion getCancionDB(String idCancion);
    ListaNormal getListaDB(String idLista);
    Usuario getUsuarioDB(String idUsuario, String clave);
    void setCancion(Cancion cancion);
    void setGenero(Genero genero);
    void setUsuario(Usuario usuario);
    void setLista(Lista lista);

}
