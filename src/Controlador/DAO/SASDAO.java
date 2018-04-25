package Controlador.DAO;
import Cancion;
import Genero;
import Lista;
import ListaNomal;
import Usuario;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("1c21c91c-7db2-4054-9974-11d9b7ce22fa")
public class SASDAO implements InterfazSASDAO {
    @objid ("ea86c18a-07c7-4770-a869-b4d6b2f4300e")
    public Cancion getCancionDB(String idCancion) {
    }

    @objid ("167374c3-3ef2-464e-8f25-56f0e7d09a43")
    public ListaNomal getListaDB(String idLista) {
    }

    @objid ("2ea08672-a172-47e8-a160-53b18db5a067")
    public Genero getGeneroDB(String idGenero) {
    }

    @objid ("ba0ffaa4-1bf4-44ed-aae9-cdc5f9015467")
    public Usuario getUsuarioDB(String idUsuario, String clave) {
    }

    @objid ("2e7afc82-07ce-4bb7-b6f8-18cb2f597487")
    public void setCancion(Cancion cancion) {
    }

    @objid ("2a4fc2c0-7040-40fe-84a0-e59dc9f0d7f2")
    public void setUsuario(Usuario usuario) {
    }

    @objid ("ae057be0-388e-43ac-ab65-ac39126268d2")
    public void setGenero(Genero genero) {
    }

    @objid ("fd563ebf-1094-4dc3-840c-4f2bf6eeb741")
    public void setLista(Lista lista) {
    }

}
