package Controlador.DAO;

import java.util.ArrayList;
import Controlador.DAO.SASDAO;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public class DAOFachada implements InterfazDAOFachada {
	
    private InterfazSASDAO sasdao;

    public DAOFachada() {
    		this.sasdao = new SASDAO();
    }
    
    // ----------- GET -----------
    @Override
    public Genero getGeneroDB(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getGeneroDB(idGenero);
    }

    @Override
    public Cancion getCancionDB(String idCancion) throws ErrorCreacionObjeto, ErrorConsulta {
		return this.sasdao.getCancionDB(idCancion);
    }

    @Override
    public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getListaDB(idLista);
    }

    @Override
    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getUsuarioDB(idUsuario, clave);
    }

	@Override
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto{
		return this.sasdao.getListasDB(idUsuario, clave);
	}
    // ----------- SET -----------
    @Override
    public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto {
    		this.sasdao.setCancion(cancion);
    }

    @Override
    public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setGenero(genero, usuario);
    }

    @Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setUsuario(usuario);
    }

    @Override
    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		this.sasdao.setLista(lista, usuario);
    }
    
    @Override
    public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado{
    		this.sasdao.setListaAuto(lista, genero, usuario);
    }

    // ----------- ELIMINAR -----------
	@Override
	public void eliminarLista(Lista lista, Usuario usuarioActual) throws ErrorAutenticacion, ErrorEliminacion {
		this.sasdao.eliminarLista(lista);
	}

	@Override
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion {
		this.sasdao.eliminarCancion(cancion);
	}

	@Override
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto {
		return this.sasdao.getCancionesGeneroDB(id);
	}

	@Override
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		this.sasdao.eliminarGenero(genero, usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		this.sasdao.eliminarUsuario(usuario);
	}
}
