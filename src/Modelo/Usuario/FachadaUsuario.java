
public class FachadaUsuario implements InterfazFachadaUsuario {
	
    public InterfazSASUsuario interfazSASUsuario;

    public void borrar(String user, String pass) {
    		interfazSASUsuario.borrar(user, pass);
    }

    public void modificar(String user, String pass) {
    		interfazSASUsuario.modificar(user, pass);
    }

    public void salir(String user) {
    		interfazSASUsuario.salir(user);
    }

    public void ingreso(String user, String pass) {
    		interfazSASUsuario.ingreso(user, pass);
    }

    public void registro(String user, String pass) {
    		interfazSASUsuario.registro(user, pass);
    }

}
