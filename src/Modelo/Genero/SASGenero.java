package Genero;

import Controlador.DAO.InterfazDAOFachada;

public class SASGenero implements InterfazSASGenero {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	
    public void Anadir(Genero genero) {
    		dao.setGenero(genero);
    }

    public void Eliminar(Genero genero) {
    		dao.borrarGeneroDB(genero);
    	}

    public Genero Consultar(String id) {
    		return dao.getGeneroDB(id);
    }
}
