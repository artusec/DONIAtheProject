import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;

public interface InterfazSASUsuario {
	
    void borrar(String user, String pass);
    void salir(String user);
    void registro(String user, String pass);
    void modificar(String user, String pass) throws ErrorCreacionObjeto, ErrorAutenticacion;
    void ingreso(String user, String pass);

}
