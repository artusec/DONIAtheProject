package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public InterfazSASUsuario interfazSASUsuario;

	@Override
	public void eliminar(Usuario usuario) throws ErrorAutenticacion {
		interfazSASUsuario.eliminar(usuario);
	}

	@Override
	public void salir(Usuario usuario) {
		interfazSASUsuario.salir(usuario);
	}

	@Override
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion {
		interfazSASUsuario.registro(usuario);
	}

	@Override
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion {
		interfazSASUsuario.modificar(nuevo);
	}

	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion {
		return interfazSASUsuario.ingreso(id, pass);
	}
}
