package Model.Usuario;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.Usuario;

public interface InterfazFachadaUsuario {
	public void borrar(Usuario usuario) throws ErrorAutenticacion;
	public void salir(Usuario usuario);
	public void registro(String id, String nombre, String pass);
	public void modificar(Usuario usuario, String nombre, String pass) throws ErrorCreacionObjeto, ErrorAutenticacion;
	public Usuario ingreso(String id, String pass) throws ErrorAutenticacion;
}
