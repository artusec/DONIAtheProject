package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class ListaFachada implements InterfazListaFachada {
	
    public InterfazSASLista interfazSASLista;

    @Override
    public void crearLista(String nombre, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto {
    		interfazSASLista.crearLista(nombre, usuario);
    }

    @Override
    public void crearListaAuto(String nombre, Genero genero, Usuario usuario,int duracion) throws ErrorAutenticacion, ErrorCreacionObjeto {
    		interfazSASLista.crearListaAuto(nombre, genero, usuario,duracion);
    }

	@Override
	public Lista consulta(String idLista) throws ErrorConsulta {
    		return interfazSASLista.consulta(idLista);		
	}

	@Override
	public void borrar(Lista lista, Usuario usuario) {
		interfazSASLista.borrar(lista, usuario);		
	}

	@Override
	public void modificar(String nombre, Lista lista, Usuario usuario) throws ErrorAutenticacion {
		interfazSASLista.modificar(nombre, lista, usuario);		
	}

	@Override
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion {
		interfazSASLista.anadirCancion(cancion, lista, usuario);		
	}

	@Override
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion {
		interfazSASLista.eliminarCancion(cancion, lista, usuario);	
	}
}
