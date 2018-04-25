package Modelo.Lista;
import java.util.List;
import Cancion;
import Genero;
import ListaNomal;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("22f43c12-6bae-4a1d-8130-7fb563b97e6d")
public class ListaFachada implements InterfazListaFachada {
    @objid ("0381dc3f-71ac-4a47-8cd5-edbe72a657df")
    public InterfazSASLista interfazSASLista;

    @objid ("c59c3828-ed8c-4246-8c16-799e7272beac")
    public ListaNomal consulta(ListaNomal lista) {
    }

    @objid ("d49c670d-d81f-4392-b422-b7e23ac19dfe")
    public void borrar(ListaNomal lista) {
    }

    @objid ("4d642cef-771a-4efd-864d-b34131b0bcb4")
    public void modificar(String nombre, ListaNomal lista) {
    }

    @objid ("f15358ee-369e-41a0-83a4-51e9e6cd58a4")
    public void crearLista(List<Cancion> canciones, String nombre) {
    }

    @objid ("98b7cb29-d661-486d-9140-078b7585396f")
    public void crearListaAuto(String nombre, List<Genero> generos) {
    }

    @objid ("f42ea1f3-421a-40e6-a4da-2f999863430a")
    public void mostrar(ListaNomal lista) {
    }

    @objid ("8854462c-0629-457f-9b1e-8f3e6fe2d15a")
    public void aniadirCancion(Cancion cancion, ListaNomal lista) {
    }

}
