
import java.util.List;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.ListaNormal;

public class ListaFachada implements InterfazListaFachada {
	
    public InterfazSASLista interfazSASLista;

    public void consulta(ListaNormal lista) {
    	interfazSASLista.consulta(lista);
    }

    public void borrar(ListaNormal lista) {
    	interfazSASLista.borrar(lista);
    }

    public void modificar(String nombre, ListaNormal lista) {
    	interfazSASLista.modificar(nombre, lista);
    }

    public void crearLista(List<Cancion> canciones, String nombre) {
    	interfazSASLista.crearLista(canciones, nombre);
    }

    public void crearListaAuto(String nombre, List<Genero> generos) {
    	interfazSASLista.crearListaAuto(nombre, generos);
    }

    public void mostrar(ListaNormal lista) {
    	interfazSASLista.mostrar(lista);
    }

    public void aniadirCancion(Cancion cancion, ListaNormal lista) {
    	interfazSASLista.aniadirCancion(cancion, lista);
    }

}
