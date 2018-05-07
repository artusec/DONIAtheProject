package Modelo.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class ListaNormal extends Lista {

	public ListaNormal(String id, String nombre) throws ErrorCreacionObjeto {
		super(id, nombre);
	}
	
	public ListaNormal(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
	}
}
