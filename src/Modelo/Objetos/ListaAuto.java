package Modelo.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

public class ListaAuto extends ListaNormal {
	
	private Genero genero;
	
    public ListaAuto(String id, String nombre, Genero genero) throws ErrorCreacionObjeto {
    		super(id, nombre);
    		this.setGenero(genero);
    }

    public ListaAuto(String id, String nombre, Genero genero, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
		this.setGenero(genero);
    }
    
	public void setGenero(Genero genero) throws ErrorCreacionObjeto {
		if (genero == null) throw new ErrorCreacionObjeto();
		this.genero = genero;
	}
	
	@Override
	public String getGenero() {
		
		return genero.getNombre();
	}
}
