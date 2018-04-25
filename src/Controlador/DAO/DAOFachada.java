package Controlador.DAO;

import Modelo.ObjetosModelo.Cancion;
import Modelo.ObjetosModelo.Genero;
import Modelo.ObjetosModelo.Lista;
import Modelo.ObjetosModelo.ListaNormal;
import Modelo.ObjetosModelo.Usuario;

public class DAOFachada implements InterfazDAOFachada {
	
    public InterfazSASDAO interfazSASDAO;

    public Genero getGeneroDB(String idGenero) {
		return null;
    }

    public Cancion getCancionDB(String idCancion) {
		return null;
    }

    public ListaNormal getListaDB(String idLista) {
		return null;
    }

    public Usuario getUsuarioDB(String idUsuario, String clave) {
		return null;
    }

    public void setCancion(Cancion cancion) {
    }

    public void setGenero(Genero genero) {
    }

    public void setUsuario(Usuario usuario) {
    }

    public void setLista(Lista lista) {
    }

}
