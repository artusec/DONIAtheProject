package Model.Usuario;

import Controlador.DAO.DAOFachada;
import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

public class SASUsuario implements InterfazSASUsuario {
	
	private InterfazDAOFachada dao;
	//hay un objeto dao, solo que no se donde deberiamos ponerlo
	
	/**
	 * @param dao interfazDAOFachada
	 */
	public SASUsuario() {
		this.setDao();
		dao = new DAOFachada();
		
	}
	
	private void setDao() {
		this.dao = new DAOFachada();
	}
	
	/**
	 * Verifica los datos de inicio de sesion y genera el usuario seleccionado
	 * @param id id de usuario
	 * @param pass contrasena
	 * @return usuario encontrado
	 * @throws ErrorCreacionObjeto 
	 * @throws ErrorConsulta 
	 * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena esta mal)
	 */
    public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
    		Usuario buscado = dao.getUsuarioDB(id, pass);
    		if (buscado != null)
    			return buscado;
    		else
    			throw new ErrorAutenticacion();
    }

    /**
     * Elimina el usuario de la DB
     * @param Usuario usuario a eliminar
     * @throws ErrorEliminacion 
     * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario
     */
    public void eliminar(Usuario Usuario) throws ErrorAutenticacion, ErrorEliminacion {
    		dao.eliminarUsuario(Usuario);
    }

    /**
     * Genera el usuario con las modificaciones y lo guarda si es posible en la DB
     * @param usuario usuario nuevo
     * @throws ErrorCreacionObjeto si los nombre o pass intruducidos no son validos
     * @throws ErrorGuardado 
     * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena esta mal)
     */
    public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
    		dao.setUsuario(nuevo);
    }
    
    /**
     * Crea un usuario y lo guarda en la DB, siempre que no se repita la id elegida
     * @param usuario usuario que se quiere registrar
     * @throws ErrorCreacionObjeto 
     * @throws ErrorAutenticacion 
     * @throws ErrorGuardado 
     */
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		dao.setUsuario(usuario);
	}
}
