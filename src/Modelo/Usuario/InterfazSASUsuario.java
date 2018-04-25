import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("fb7e486b-0a49-42da-8706-3e60718392cd")
public interface InterfazSASUsuario {
    @objid ("06067021-2112-42d7-9830-b1d9551d9b58")
    void borrar(String user, String pass);

    @objid ("0b15992f-a79a-482b-9a38-acf3671f15d2")
    void salir(String user);

    @objid ("ab827c6d-b50c-4c64-adeb-e01cd7998731")
    void registro(String user, String pass);

    @objid ("6d6d04de-38e3-4fe7-8002-26e1a416fe07")
    void modificar(String user, String pass);

    @objid ("82c80762-37ae-42e0-9c75-f60ac130cfda")
    void ingreso(String user, String pass);

}
