package Model.Usuario;

import DAO.DAOFachada;
import DAO.InterfazDAOFachada;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

/**
 * Servicio de aplicación de usuario.
 * @author Raúl
 *
 */
public class SASUsuario implements InterfazSASUsuario {
	
	private InterfazDAOFachada dao;
	
	/**
	 * Constructora de la clase.
	 */
	public SASUsuario() {
		this.setDao();
	}
	
	/**
	 * Actualiza el atributo dao a un nuevo DAOFachada.
	 */
	private void setDao() {
		this.dao = new DAOFachada();
	}
	
	/**
	 * Verifica los datos de inicio de sesión y genera el usuario seleccionado.
	 * @param id id del usuario.
	 * @param pass contraseña.
	 * @return usuario usuario encontrado. 
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto. 
	 * @throws ErrorConsulta Si se ha producido un error al buscar el usuario.
	 * @throws ErrorAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
	 */
    public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
    		Usuario buscado = dao.getUsuarioDB(id, pass);
    		if (buscado != null)
    			return buscado;
    		else
    			throw new ErrorAutenticacion();
    }

    /**
     * Elimina el usuario de la DB.
     * @param Usuario usuario a eliminar.
     * @throws ErrorEliminacion Si no se ha podido eliminar.
     * @throws ErrorAutenticacion Error si se ha producido un error al validar los datos del usuario.
     */
    public void eliminar(Usuario Usuario) throws ErrorAutenticacion, ErrorEliminacion {
    	if (!Usuario.getId().equals("u0"))
    		dao.eliminarUsuario(Usuario);
    	else
    		throw new ErrorEliminacion("No se puede eliminar el usuario ADMINISTRADOR");
    }

    /**
     * Genera el usuario con las modificaciones y lo guarda si es posible en la DB.
     * @param nuevo usuario nuevo.
     * @throws ErrorCreacionObjeto si los nombre o pass intruducidos no son validos.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     * @throws ErrorAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
     */
    public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
    		dao.setUsuario(nuevo);
    }
    
    /**
     * Crea un usuario y lo guarda en la DB, siempre que no se repita la id elegida.
     * @param usuario usuario que se quiere registrar.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @throws ErrorAutenticacion Si el usuario no existe.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     */
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		dao.setUsuario(usuario);
	}
}
