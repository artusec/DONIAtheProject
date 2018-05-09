package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;

import Model.Objetos.Usuario;

public interface InterfazSASUsuario {
	public void eliminar(Usuario usuario) throws ErrorAutenticacion;
	public void salir(Usuario usuario);
	public void registro(Usuario usuario) throws ErrorCreacionObjeto, ErrorAutenticacion;
	public void modificar(Usuario nuevo) throws ErrorCreacionObjeto, ErrorAutenticacion;
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion;
}
