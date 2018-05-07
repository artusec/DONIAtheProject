package Model.Lista;

import java.util.List;

import laskdjf.Objetos.Cancion;
import laskdjf.Objetos.Genero;
import laskdjf.Objetos.Lista;

public class ListaFachada implements InterfazListaFachada {
	
    public InterfazSASLista interfazSASLista;

    public void crearLista(List<Cancion> canciones, String nombre) {
    	interfazSASLista.crearLista(canciones, nombre);
    }

    public void crearListaAuto(String nombre, List<Genero> generos) {
    	interfazSASLista.crearListaAuto(nombre, generos);
    }

	@Override
	public void consulta(Lista lista) {
    	interfazSASLista.consulta(lista);		
	}

	@Override
	public void borrar(Lista lista) {
    	interfazSASLista.borrar(lista);		
	}

	@Override
	public void modificar(String nombre, Lista lista) {
    	interfazSASLista.modificar(nombre, lista);		
	}

	@Override
	public void mostrar(Lista lista) {
    	interfazSASLista.mostrar(lista);		
	}

	@Override
	public void aniadirCancion(Cancion cancion, Lista lista) {
    	interfazSASLista.aniadirCancion(cancion, lista);		
	}

}
