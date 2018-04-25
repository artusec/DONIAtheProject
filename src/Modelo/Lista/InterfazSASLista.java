import java.util.List;
import Modelo.ObjetosModelo.Cancion;
import Modelo.ObjetosModelo.Genero;
import Modelo.ObjetosModelo.ListaNormal;

public interface InterfazSASLista {
	
    ListaNormal consulta(ListaNormal lista);
    void borrar(ListaNormal lista);
    void modificar(String nombre, ListaNormal lista);
    void crearLista(List<Cancion> canciones, String nombre);
    void crearListaAuto(String nombre, List<Genero> generos);
    void mostrar(ListaNormal lista);
    void aniadirCancion(Cancion cancion, ListaNormal lista);

}
