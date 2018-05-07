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

	@Override
	public void borrarLista(Lista lista, Usuario usuarioActual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCancion(Cancion cancion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Cancion> getCancionesGeneroDB(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarGeneroDB(Genero genero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

}
