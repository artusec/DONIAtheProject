import java.util.List;

import Modelo.Objetos.Cancion;
import Modelo.Objetos.Genero;
import Modelo.Objetos.Lista;
import Modelo.Objetos.ListaNormal;

public interface InterfazListaFachada {
    public void consulta(Lista lista);
    public void borrar(Lista lista);
    public void modificar(String nombre, Lista lista);
    public void crearLista(List<Cancion> canciones, String nombre);
    public void crearListaAuto(String nombre, List<Genero> generos);
    public void mostrar(Lista lista);
    public void aniadirCancion(Cancion cancion, Lista lista);
}
