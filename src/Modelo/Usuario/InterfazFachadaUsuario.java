
public interface InterfazFachadaUsuario {
	
    void borrar(String user, String pass);
    void ingreso(String user, String pass);
    void modificar(String user, String pass);
    void salir(String user);
    void registro(String user, String pass);

}
