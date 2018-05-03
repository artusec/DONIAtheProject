package Controlador.DAO;

import Modelo.Objetos.*;
import Controlador.DAO.SASDAO;
import Excepciones.ErrorAutenticacion;

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

    public Usuario getUsuarioDB(String idUsuario, String clave) {
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

    public void setLista(Lista lista) {
    		this.sasdao.setLista(lista);
    }
}
