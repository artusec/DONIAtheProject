package Model.Lista;

import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public class ListaFachada implements InterfazFachadaLista {
	
    public InterfazSASLista sasLista;

    public ListaFachada(){
    		sasLista = new SASLista();
    }
    
    @Override
    public void crearLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorGuardado {
    		sasLista.crearLista(lista, usuario);
    }

    @Override
    public void crearListaAuto(ListaAuto lista, Usuario usuario,int duracion) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
    		sasLista.crearListaAuto(lista, usuario,duracion);
    }

	@Override
	public Lista consulta(String idLista) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasLista.consulta(idLista);		
	}

	@Override
	public ArrayList<Lista> mostrar(Usuario usuarioActual) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		return sasLista.mostrar(usuarioActual);
	}
	
	@Override
	public void eliminar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorEliminacion {
		sasLista.eliminar(lista, usuario);		
	}

	@Override
	public void modificar(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
		sasLista.modificar(lista, usuario);		
	}

	@Override
	public void anadirCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
		sasLista.anadirCancion(cancion, lista, usuario);		
	}

	@Override
	public void eliminarCancion(Cancion cancion, Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorCreacionObjeto, ErrorConsulta, ErrorGuardado {
		sasLista.eliminarCancion(cancion, lista, usuario);	
	}
}
