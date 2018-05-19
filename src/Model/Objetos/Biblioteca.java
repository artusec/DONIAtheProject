package Model.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class Biblioteca extends Lista {
    
	/**
	 * Constructora de la clase.
	 * Es una lista con todas las canciones de la base de datos.
	 * Llama a la constructora de Lista
	 * @param nombre Nombre de la lista. En este caso "l0"
	 * @throws ErrorCreacionObjeto
	 */
    public Biblioteca(String nombre) throws ErrorCreacionObjeto {
		super("l0", nombre);
	}

    /**
     * Constructora de la clase.
     * Es una lista con todas las canciones de la base de datos.
     * @param nombre Nombre de la lista. En este caso "l0"
     * @param canciones Lista de canciones. En este caso, todas las de la base de datos.
     * @throws ErrorCreacionObjeto
     */
    public Biblioteca(String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super("l0", nombre, canciones);
	}
}
