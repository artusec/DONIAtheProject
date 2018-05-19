package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

public interface InterfazSASUsuario {
	
    /**
     * Elimina el usuario de la DB.
     * @param Usuario usuario a eliminar.
     * @throws ErrorEliminacion 
     * @throws ErrorDeAutenticacion Error si se ha producido un error al validar los datos del usuario.
     */
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion;
	
    /**
     * Crea un usuario y lo guarda en la DB, siempre que no se repita la id elegida.
     * @param usuario usuario que se quiere registrar.
     * @throws ErrorCreacionObjeto 
     * @throws ErrorAutenticacion 
     * @throws ErrorGuardado 
     */
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado;
	
    /**
     * Genera el usuario con las modificaciones y lo guarda si es posible en la DB.
     * @param usuario usuario nuevo.
     * @throws ErrorCreacionObjeto si los nombre o pass intruducidos no son validos.
     * @throws ErrorGuardado 
     * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
     */
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado;
	
	/**
	 * Verifica los datos de inicio de sesión y genera el usuario seleccionado.
	 * @param id id del usuario.
	 * @param pass contraseña.
	 * @return usuario usuario encontrado. 
	 * @throws ErrorCreacionObjeto 
	 * @throws ErrorConsulta 
	 * @throws ErrorDeAutenticacion si se ha producido un error al validar los datos del usuario (la contrasena está mal).
	 */
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto;
}
