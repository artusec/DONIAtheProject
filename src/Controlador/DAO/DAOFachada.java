package Controlador.DAO;
import Cancion;
import Genero;
import Lista;
import ListaNomal;
import Usuario;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d5255a61-3aeb-4c9e-9fc0-c83229348145")
public class DAOFachada implements InterfazDAOFachada {
    @objid ("ccf6870b-8066-41c2-a0d3-4d9ff3c73225")
    public InterfazSASDAO interfazSASDAO;

    @objid ("667af636-5da7-4752-b02c-1b1042198bcb")
    public Genero getGeneroDB(String idGenero) {
    }

    @objid ("29a6ba53-e395-4ada-96c5-a2eec97c09c6")
    public Cancion getCancionDB(String idCancion) {
    }

    @objid ("7ea92237-4b14-4022-aee3-9ff6f5476cf5")
    public ListaNomal getListaDB(String idLista) {
    }

    @objid ("cecdf664-8f34-403c-8757-a662d3e19d6e")
    public Usuario getUsuarioDB(String idUsuario, String clave) {
    }

    @objid ("c462ea07-971e-45d0-9256-f704f38f620b")
    public void setCancion(Cancion cancion) {
    }

    @objid ("52f412a8-231f-47b7-95aa-76441d905fac")
    public void setGenero(Genero genero) {
    }

    @objid ("bb804979-19f7-4c68-bf69-b426434dfe82")
    public void setUsuario(Usuario usuario) {
    }

    @objid ("517d8293-0ac1-4a3a-b404-56c1e4fc6f9c")
    public void setLista(Lista lista) {
    }

}
