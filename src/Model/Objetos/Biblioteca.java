package Model.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class Biblioteca extends Lista {
    
    public Biblioteca(String nombre) throws ErrorCreacionObjeto {
		super("l0", nombre);
	}

    public Biblioteca(String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super("l0", nombre, canciones);
	}
}
