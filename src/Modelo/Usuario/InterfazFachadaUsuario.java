import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1a996e63-4d46-435a-b447-fd0abdc07f2a")
public interface InterfazFachadaUsuario {
    @objid ("751d2d16-a4a9-452a-961c-c6076507ef31")
    void borrar(String user, String pass);

    @objid ("49d197c6-c23d-433a-98f1-d841c9717529")
    void ingreso(String user, String pass);

    @objid ("5d0beec6-a33a-4ab1-9959-495d6c0ea1fb")
    void modificar(String user, String pass);

    @objid ("529ef43e-3664-4655-b3a8-a1a44839fe45")
    void salir(String user);

    @objid ("a81ad82a-7c75-48e2-9286-f718699bc3af")
    void registro(String user, String pass);

}
