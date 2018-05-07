package Model.Lista;

import java.util.List;

import Excepciones.ErrorAutenticacion;
import Model.Objetos.*;

public class ListaFachada implements InterfazListaFachada {
	
    public InterfazSASLista interfazSASLista;

    @Override
    public void crearLista(String nombre) throws ErrorAutenticacion {
    		interfazSASLista.crearLista(nombre);
    }

    @Override
    public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion {
    		interfazSASLista.crearListaAuto(nombre, genero);
    }

	@Override
	public Lista consulta(String idLista) {
    		return interfazSASLista.consulta(idLista);		
	}

	@Override
	public void borrar(Lista lista) {
		interfazSASLista.borrar(lista);		
	}

	@Override
	public void modificar(String nombre, Lista lista) throws ErrorAutenticacion {
		interfazSASLista.modificar(nombre, lista);		
	}

	@Override
	public void anadirCancion(Cancion cancion, Lista lista) {
		interfazSASLista.anadirCancion(cancion, lista);		
	}

	@Override
	public void eliminarCancion(Cancion cancion, Lista lista) {
		interfazSASLista.eliminarCancion(cancion, lista);	
	}
}
