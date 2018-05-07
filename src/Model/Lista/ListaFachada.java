package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class ListaFachada implements InterfazListaFachada {
	
    public InterfazSASLista interfazSASLista;

    @Override
    public void crearLista(String nombre) throws ErrorAutenticacion, ErrorCreacionObjeto {
    		interfazSASLista.crearLista(nombre);
    }

    @Override
    public void crearListaAuto(String nombre, Genero genero) throws ErrorAutenticacion, ErrorCreacionObjeto {
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
	public void anadirCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion {
		interfazSASLista.anadirCancion(cancion, lista);		
	}

	@Override
	public void eliminarCancion(Cancion cancion, Lista lista) throws ErrorAutenticacion {
		interfazSASLista.eliminarCancion(cancion, lista);	
	}
}
