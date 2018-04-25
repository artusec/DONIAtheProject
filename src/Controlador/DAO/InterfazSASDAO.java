package Controlador.DAO;
import Modelo.ObjetosModelo.Cancion;
import Modelo.ObjetosModelo.Genero;
import Modelo.ObjetosModelo.Lista;
import Modelo.ObjetosModelo.ListaNormal;
import Modelo.ObjetosModelo.Usuario;

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
