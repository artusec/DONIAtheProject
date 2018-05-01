package Modelo.Objetos;

import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public class ListaAuto extends Lista {
	
	private Genero genero;
	
    public ListaAuto(String id, String nombre, Genero genero) throws ErrorCreacionObjeto {
    		super(id, nombre);
		//TODO
    }

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) throws ErrorCreacionObjeto {
		if (genero == null) throw new ErrorCreacionObjeto();
		this.genero = genero;
	}
}
