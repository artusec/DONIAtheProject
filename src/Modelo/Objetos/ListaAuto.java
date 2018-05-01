package Modelo.Objetos;

import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public class ListaAuto extends ListaNormal {
    public ListaAuto(String id, String nombre, List<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
		// TODO Auto-generated constructor stub
	}

	public Genero genero;

}
