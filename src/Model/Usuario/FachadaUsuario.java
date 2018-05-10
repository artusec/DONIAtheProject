package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Usuario;

public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public SASUsuario SASUsuario;

    
    public FachadaUsuario() {
		// TODO Auto-generated constructor stub
    	SASUsuario = new SASUsuario();
    	
	}
	@Override
	public void eliminar(Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		SASUsuario.eliminar(usuario);
	}

	@Override
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		SASUsuario.registro(usuario);
	}

	@Override
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion, ErrorGuardado {
		SASUsuario.modificar(nuevo);
	}

	@Override
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return SASUsuario.ingreso(id, pass);
	}
}
