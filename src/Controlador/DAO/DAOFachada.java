package Controlador.DAO;

import java.util.ArrayList;
import Controlador.DAO.SASDAO;
import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public class DAOFachada implements InterfazDAOFachada {
	
    private InterfazSASDAO sasdao;

    public DAOFachada() {
    		this.sasdao = new SASDAO();
    }
    
    // ----------- GET -----------
    @Override
    public Genero getGeneroDB(String idGenero) {
		return this.sasdao.getGeneroDB(idGenero);
    }

    @Override
    public Cancion getCancionDB(String idCancion) {
		return this.sasdao.getCancionDB(idCancion);
    }

    @Override
    public Lista getListaDB(String idLista) {
		return this.getListaDB(idLista);
    }

    @Override
    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion {
		return this.getUsuarioDB(idUsuario, clave);
    }

    // ----------- SET -----------
    @Override
    public void setCancion(Cancion cancion) {
    		this.sasdao.setCancion(cancion);
    }

    @Override
    public void setGenero(Genero genero, Usuario usuario) {
    		this.sasdao.setGenero(genero, usuario);
    }

    @Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion {
    		this.sasdao.setUsuario(usuario);
    }

    @Override
    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion {
    		this.sasdao.setLista(lista, usuario);
    }
    
    @Override
    public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion{
    		this.sasdao.setListaAuto(lista, genero, usuario);
    }

    // ----------- ELIMINAR -----------
	@Override
	public void eliminarLista(Lista lista, Usuario usuarioActual) {
		this.sasdao.eliminarLista(lista, usuarioActual);
	}

	@Override
	public void eliminarCancion(Cancion cancion) {
		this.sasdao.eliminarCancion(cancion);
	}

	@Override
	public ArrayList<Cancion> getCancionesGeneroDB(String id) {
		return this.sasdao.getCancionesGeneroDB(id);
	}

	@Override
	public void eliminarGenero(Genero genero, Usuario usuario) {
		this.sasdao.eliminarGenero(genero, usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		this.sasdao.eliminarUsuario(usuario);
	}
}
