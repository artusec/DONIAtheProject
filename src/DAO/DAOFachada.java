package DAO;

import java.util.ArrayList;

import DAO.SASDAO;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Clase DAOFachada, implementa InterfazDAOFachada. Realiza las peticiones
 * al objeto de acceso a datos.
 */
public class DAOFachada implements InterfazDAOFachada {
	
    private InterfazSASDAO sasdao;

    /**
     * Constructor de la clase, inicializa argumentos.
     */
    public DAOFachada() {
    		this.sasdao = new SASDAO();
    }
    
    // ----------- GET -----------
    /**
     * Implementación de getGeneroDB.
     */
    @Override
    public Genero getGeneroDB(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getGeneroDB(idGenero);
    }
    /**
     * Implementación de getCancionDB.
     */
    @Override
    public Cancion getCancionDB(String idCancion) throws ErrorCreacionObjeto, ErrorConsulta {
		return this.sasdao.getCancionDB(idCancion);
    }
    /**
     * Implementación de getListaDB.
     */
    @Override
    public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getListaDB(idLista);
    }
    /**
     * Implementación de getUsuarioDB.
     */
    @Override
    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getUsuarioDB(idUsuario, clave);
    }
    /**
     * Implementación de getListasDB.
     */
	@Override
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto{
		return this.sasdao.getListasDB(idUsuario, clave);
	}
    // ----------- SET -----------
	/**
     * Implementación de setCancion.
     */
    @Override
    public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto {
    		this.sasdao.setCancion(cancion);
    }
    /**
     * Implementación de setGenero.
     */
    @Override
    public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setGenero(genero, usuario);
    }
    /**
     * Implementación de setUsuario.
     */
    @Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setUsuario(usuario);
    }
    /**
     * Implementación de setLista.
     */
    @Override
    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setLista(lista, usuario);
    }
    /**
     * Implementación de setListaAuto.
     */
    @Override
    public void setListaAuto(ListaAuto lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado{
    		this.sasdao.setListaAuto(lista, usuario);
    }

    // ----------- ELIMINAR -----------
    /**
     * Implementación de eliminarLista.
     */
	@Override
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion, ErrorEliminacion {
		this.sasdao.eliminarLista(lista);
	}
	/**
     * Implementación de eliminarCancion.
     */
	@Override
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion {
		this.sasdao.eliminarCancion(cancion);
	}
	/**
     * Implementación de getCancionesGeneroDB.
     */
	@Override
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getCancionesGeneroDB(id);
	}
	/**
     * Implementación de eliminarGenero.
     */
	@Override
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		this.sasdao.eliminarGenero(genero, usuario);
	}
	/**
     * Implementación de eliminarUsuario.
     */
	@Override
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		this.sasdao.eliminarUsuario(usuario);
	}
}
