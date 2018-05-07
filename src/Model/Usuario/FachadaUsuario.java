package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public InterfazSASUsuario interfazSASUsuario;

	@Override
	public void borrar(Usuario usuario) throws ErrorAutenticacion {
		interfazSASUsuario.borrar(usuario);
	}

	@Override
	public void salir(Usuario usuario) {
		interfazSASUsuario.salir(usuario);
	}

	@Override
	public void registro(String id, String nombre, String pass) throws ErrorCreacionObjeto, ErrorAutenticacion {
		interfazSASUsuario.registro(id, nombre, pass);
	}

	@Override
	public void modificar(Usuario usuario, String nombre, String pass) throws ErrorCreacionObjeto, ErrorAutenticacion {
		interfazSASUsuario.modificar(usuario, nombre, pass);
	}

	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion {
		return interfazSASUsuario.ingreso(id, pass);
	}
}
