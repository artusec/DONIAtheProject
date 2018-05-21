package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

/**
 * FachadaUsuario. Implementa InterfazFachadaUsuario.
 * @author Raúl
 *
 */
public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public InterfazSASUsuario SASUsuario;

    /**
     * Constructora de la clase.
     */
    public FachadaUsuario() {
    		SASUsuario = new SASUsuario();
	}
    
    /**
     * Elimina el usuario de la DB.
     * @param usuario Usuario a eliminar.
     * @throws ErrorEliminacion Si no se ha podido eliminar.
     * @throws ErrorAutenticacion Error si se ha producido un error al validar los datos del usuario.
     */
	@Override
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		SASUsuario.eliminar(usuario);
	}

    /**
     * Crea un usuario y lo guarda en la DB, siempre que no se repita la id elegida.
     * @param usuario Usuario que se quiere registrar.
     * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
     * @throws ErrorAutenticacion Si el usuario no existe.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     */
	@Override
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		SASUsuario.registro(usuario);
	}

    /**
     * Genera el usuario con las modificaciones y lo guarda si es posible en la DB.
     * @param nuevo Usuario nuevo.
     * @throws ErrorCreacionObjeto si los nombre o pass intruducidos no son validos.
     * @throws ErrorGuardado Si no se ha podido guardar la información.
     * @throws ErrorAutenticacion Si se ha producido un error al validar los datos del usuario (la contrasena está mal).
     */
	@Override
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		SASUsuario.modificar(nuevo);
	}

	/**
	 * Verifica los datos de inicio de sesión y genera el usuario seleccionado.
	 * @param id id del usuario.
	 * @param pass contraseña.
	 * @return usuario usuario encontrado .
	 * @throws ErrorCreacionObjeto Si se ha producido un error al crear el objeto.
	 * @throws ErrorConsulta Si se ha producido un error al buscar usuario.
	 * @throws ErrorAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
	 */
	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return SASUsuario.ingreso(id, pass);
	}
}
