package Model.Lista;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class ListaFachada implements InterfazFachadaLista {
	
    public InterfazSASLista interfazSASLista;

    @Override
    public void crearLista(String nombre, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto {
    		interfazSASLista.crearLista(nombre, usuario);
    }

    @Override
    public void crearListaAuto(ListaAuto lista, Genero genero, Usuario usuario,int duracion) throws ErrorAutenticacion, ErrorCreacionObjeto {
    		interfazSASLista.crearListaAuto(lista, genero, usuario,duracion);
    }

	@Override
	public Lista consulta(String idLista) throws ErrorConsulta {
    		return interfazSASLista.consulta(idLista);		
	}

	@Override
	public void eliminar(Lista lista, Usuario usuario) {
		interfazSASLista.eliminar(lista, usuario);		
	}

	@Override
	public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion {
		interfazSASLista.modificar(lista, usuario);		
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
