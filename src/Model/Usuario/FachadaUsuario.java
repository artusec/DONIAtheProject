package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

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
     * @param Usuario usuario a eliminar.
     * @throws ErrorEliminacion 
     * @throws ErrorDeAutenticacion Error si se ha producido un error al validar los datos del usuario.
     */
	@Override
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		SASUsuario.eliminar(usuario);
	}

    /**
     * Crea un usuario y lo guarda en la DB, siempre que no se repita la id elegida.
     * @param usuario usuario que se quiere registrar.
     * @throws ErrorCreacionObjeto 
     * @throws ErrorAutenticacion 
     * @throws ErrorGuardado 
     */
	@Override
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		SASUsuario.registro(usuario);
	}

    /**
     * Genera el usuario con las modificaciones y lo guarda si es posible en la DB.
     * @param usuario usuario nuevo.
     * @throws ErrorCreacionObjeto si los nombre o pass intruducidos no son validos.
     * @throws ErrorGuardado 
     * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
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
	 * @throws ErrorCreacionObjeto 
	 * @throws ErrorConsulta 
	 * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
	 */
	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return SASUsuario.ingreso(id, pass);
	}
}
