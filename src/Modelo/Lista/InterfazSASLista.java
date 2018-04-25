import java.util.List;
import Cancion;
import Genero;
import ListaNomal;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("10d09ea8-6185-486a-8c65-c7eb6d9f5360")
public interface InterfazSASLista {
    @objid ("8215da3a-e7d9-4fb4-8a8c-73b1e7e1255d")
    ListaNomal consulta(ListaNomal lista);

    @objid ("088f185d-9f74-43e4-a409-67c5028b6913")
    void borrar(ListaNomal lista);

    @objid ("ac691b74-2ab6-41e5-a6fc-df965da8227e")
    void modificar(String nombre, ListaNomal lista);

    @objid ("d1282356-39bc-46e2-9a8f-4e39ea23e076")
    void crearLista(List<Cancion> canciones, String nombre);

    @objid ("1626ab88-6b6b-4b04-8d89-72b7168cac2a")
    void crearListaAuto(String nombre, List<Genero> generos);

    @objid ("21e017f9-5307-4c24-b923-e98008d75d8a")
    void mostrar(ListaNomal lista);

    @objid ("6e477ee3-cd90-4c01-a897-509f84a27627")
    void aniadirCancion(Cancion cancion, ListaNomal lista);

}
