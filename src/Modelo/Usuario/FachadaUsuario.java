package Modelo.Usuario;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("be43fea8-2bff-4ab2-bed6-de61deda7a73")
public class FachadaUsuario implements InterfazFachadaUsuario {
    @objid ("ad54e2a2-b391-4c8e-82b7-7faa2ed8157f")
    public InterfazSASUsuario interfazSASUsuario;

    @objid ("2ccea1fe-e1b2-40d4-b4ad-b2146a4cc692")
    public void borrar(String user, String pass) {
    }

    @objid ("648a174c-9b87-4609-a12c-21b91b0c145e")
    public void modificar(String user, String pass) {
    }

    @objid ("c2e2b0b3-c2de-4d85-bc1b-9106380a12c8")
    public void salir(String user) {
    }

    @objid ("b2d14fda-1e7e-46ef-93a0-c038b67d6031")
    public void ingreso(String user, String pass) {
    }

    @objid ("32ab67d5-546e-46d2-b57e-9810f2cfeeaf")
    public void registro(String user, String pass) {
    }

}
