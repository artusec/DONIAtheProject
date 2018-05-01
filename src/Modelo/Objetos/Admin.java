package Modelo.Objetos;

import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public class Admin extends Usuario {

	public Admin(String id, String nombre, String clave, List<Genero> gustos) throws ErrorCreacionObjeto {
		super(id, nombre, clave, gustos);
		// TODO Auto-generated constructor stub
	}
}
