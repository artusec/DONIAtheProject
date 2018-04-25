import java.util.List;
import Cancion;
import Genero;
import ListaNomal;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5f753464-d5ef-4f9d-9ea7-e1fb09e10dfa")
public interface InterfazListaFachada {
    @objid ("10fa156f-5cdd-4d15-94e3-837d0c4172f3")
    ListaNomal consulta(ListaNomal lista);

    @objid ("365cb8cd-008f-4c7b-8157-7bd48666b961")
    void borrar(ListaNomal lista);

    @objid ("63d81564-d70a-4afb-9022-6053f446f242")
    void modificar(String nombre, ListaNomal lista);

    @objid ("377d1d3e-cde3-47ef-ba66-d58803e1a333")
    void crearLista(List<Cancion> canciones, String nombre);

    @objid ("57091e1d-0765-42d0-876f-ec09b0f8d2ba")
    void crearListaAuto(String nombre, List<Genero> generos);

    @objid ("2c08c31e-ed94-4485-9d70-f668ed0c049b")
    void mostrar(ListaNomal lista);

    @objid ("40936137-52c7-483d-a932-471b968d1272")
    void aniadirCancion(Cancion cancion, ListaNomal lista);

}
