package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Genero {
	
    private String id;

    public Genero(String id) throws ErrorCreacionObjeto {
	    	this.setId(id);
	}

	public String getId() {
		return id;
    }

    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;    
    }

    public String toString() {
    		return id;
    }
}
