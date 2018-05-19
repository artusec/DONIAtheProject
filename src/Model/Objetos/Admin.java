package Model.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class Admin extends Usuario {

	/**
	 * Constructora que llama al constructor de Usuario con la lista de géneros que le gustan;
	 * @param id Id único en la DB que le corresponde al usuario.
	 * @param nombre Nombre del usuario.
	 * @param clave Constraseña del usuario.
	 * @param generos Lista de géneros que le gustan al usuario.
	 * @throws ErrorCreacionObjeto
	 */
	public Admin(String id, String nombre, String clave, ArrayList<Genero> generos) throws ErrorCreacionObjeto {
		super(id, nombre, clave, generos);
	}
	
	/**
	 * Constructora que llama al constructor de Usuario;
	 * @param id Id único en la DB que le corresponde al usuario.
	 * @param nombre Nombre del usuario.
	 * @param clave Constraseña del usuario.
	 * @throws ErrorCreacionObjeto
	 */
	public Admin(String id, String nombre, String clave) throws ErrorCreacionObjeto {
		super(id, nombre, clave);
	}
}
