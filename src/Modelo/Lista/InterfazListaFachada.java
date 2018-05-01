import java.util.List;

import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.ListaNormal;

public interface InterfazListaFachada {
	
    void consulta(ListaNormal lista);
    void borrar(ListaNormal lista);
    void modificar(String nombre, ListaNormal lista);
    void crearLista(List<Cancion> canciones, String nombre);
    void crearListaAuto(String nombre, List<Genero> generos);
    void mostrar(ListaNormal lista);
    void aniadirCancion(Cancion cancion, ListaNormal lista);

}
