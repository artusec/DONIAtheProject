package Modelo.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class Biblioteca extends Lista {
    
    public Biblioteca(String id, String nombre) throws ErrorCreacionObjeto {
		super(id, nombre);
	}

    public Biblioteca(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
	}
}
