package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Genero {
	
    private String id;
    private String nombre;

    public Genero(String id, String nombre) throws ErrorCreacionObjeto {
	    	this.setId(id);
	    	this.setNombre(nombre);
	}

	public String getId() {
		return id;
    }

    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;    
    }

    public String getNombre() {
		return nombre;
    }

    public void setNombre(String nombre) throws ErrorCreacionObjeto {
    		if (nombre == null) throw new ErrorCreacionObjeto();
    		this.nombre = nombre;
    }
    
    public String toString() {
    		return nombre;
    }
}
