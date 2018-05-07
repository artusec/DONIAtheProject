package Model.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class Admin extends Usuario {

	public Admin(String id, String nombre, String clave, ArrayList<Genero> generos) throws ErrorCreacionObjeto {
		super(id, nombre, clave, generos);
	}
	
	public Admin(String id, String nombre, String clave) throws ErrorCreacionObjeto {
		super(id, nombre, clave);
	}
}
