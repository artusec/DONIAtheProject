package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

public interface InterfazSASUsuario {
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion;
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado;
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado;
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion;
}
