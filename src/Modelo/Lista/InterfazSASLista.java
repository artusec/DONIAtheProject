import java.util.List;
import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.Lista;
import Modelo.Objetos.ListaNormal;

public interface InterfazSASLista {
	Lista consulta(Lista lista);
    void borrar(Lista lista);
    void modificar(String nombre, Lista lista);
    void crearLista(List<Cancion> canciones, String nombre);
    void crearListaAuto(String nombre, List<Genero> generos);
    void mostrar(Lista lista);
    void aniadirCancion(Cancion cancion, Lista lista);
}
