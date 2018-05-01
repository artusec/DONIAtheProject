import java.util.List;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.ListaNormal;

public class SASLista implements InterfazSASLista {
	
    public ListaNormal consulta(ListaNormal lista) {
    	return null;
    }

    public void borrar(ListaNormal lista) {
    }

    public void modificar(String nombre, ListaNormal lista) {
    }

    public void crearLista(List<Cancion> canciones, String nombre) {
    }

    public void crearListaAuto(String nombre, List<Genero> generos) {
    }

    public void mostrar(ListaNormal lista) {
    }

    public void aniadirCancion(Cancion cancion, ListaNormal lista) {
    }

}
