import java.util.List;
import Cancion;
import Genero;
import ListaNomal;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8b5febe7-c9e1-444e-bd57-ee213afa1bc1")
public class SASLista implements InterfazSASLista {
    @objid ("3c2cc7c1-ec52-44c7-96dc-0bae4c448521")
    public ListaNomal consulta(ListaNomal lista) {
    }

    @objid ("26c72f05-0b0a-4b8f-b6a6-ace00b3cec0c")
    public void borrar(ListaNomal lista) {
    }

    @objid ("75e1f628-3c9c-4399-842b-356abfb73d1e")
    public void modificar(String nombre, ListaNomal lista) {
    }

    @objid ("b9eb2894-4206-4ad6-b62d-41a0b48d7d06")
    public void crearLista(List<Cancion> canciones, String nombre) {
    }

    @objid ("ac13aa37-5750-4cc1-af84-2f2fb02c6f42")
    public void crearListaAuto(String nombre, List<Genero> generos) {
    }

    @objid ("961c6551-b586-4ba9-954d-84cc1d413351")
    public void mostrar(ListaNomal lista) {
    }

    @objid ("0ae592c1-f1e0-4bdc-b62e-1577bd3a5739")
    public void aniadirCancion(Cancion cancion, ListaNomal lista) {
    }

}
