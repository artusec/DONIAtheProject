package Controlador.DAO;

import Modelo.Objetos.*;
import Controlador.DAO.SASDAO;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorContrasteDatos;

public class DAOFachada implements InterfazDAOFachada {
	
    private InterfazSASDAO sasdao;

    public DAOFachada() {
    		this.sasdao = new SASDAO();
    }
    
    public Genero getGeneroDB(String idGenero) {
		return this.sasdao.getGeneroDB(idGenero);
    }

    public Cancion getCancionDB(String idCancion) {
		return this.sasdao.getCancionDB(idCancion);
    }

    public Lista getListaDB(String idLista) {
		return this.getListaDB(idLista);
    }

    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion {
		return this.getUsuarioDB(idUsuario, clave);
    }

    public void setCancion(Cancion cancion) {
    		this.sasdao.setCancion(cancion);
    }

    public void setGenero(Genero genero) {
    		this.sasdao.setGenero(genero);
    }

    public void setUsuario(Usuario usuario) throws ErrorAutenticacion {
    		this.sasdao.setUsuario(usuario);
    }

    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion {
    		this.sasdao.setLista(lista, usuario);
    }
    
    public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion{
    		this.sasdao.setListaAuto(lista, genero, usuario);
    }
}
