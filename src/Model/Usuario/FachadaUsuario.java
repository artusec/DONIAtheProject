package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public InterfazSASUsuario interfazSASUsuario;

	@Override
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		interfazSASUsuario.eliminar(usuario);
	}

	@Override
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		interfazSASUsuario.registro(usuario);
	}

	@Override
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		interfazSASUsuario.modificar(nuevo);
	}

	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion {
		return interfazSASUsuario.ingreso(id, pass);
	}
}
