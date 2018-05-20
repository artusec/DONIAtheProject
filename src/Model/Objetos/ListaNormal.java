package Model.Objetos;

import java.util.ArrayList;
import Excepciones.ErrorCreacionObjeto;

public class ListaNormal extends Lista {

	/**
	 * Constructora de la clase.
	 * Llama a la constructora de Lista.
	 * @param id Id que identifica a la lista.
	 * @param nombre Nombre de la lista.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
	public ListaNormal(String id, String nombre) throws ErrorCreacionObjeto {
		super(id, nombre);
	}
	
	/**
	 * Constructora de la clase con una lista de canciones.
	 * Llama a la constructora de Lista.
	 * @param id Id que identifica a la lista.
	 * @param nombre Nombre de la lista.
	 * @param canciones Lista de canciones.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
	public ListaNormal(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
	}
}