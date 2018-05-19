package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Genero {
	
    private String id;

    /**
     * Constructora de la clase.
     * @param id Id que identifica al género.
     * @throws ErrorCreacionObjeto
     */
    public Genero(String id) throws ErrorCreacionObjeto {
	    	this.setId(id);
	}

    /**
     * Método getter del id del género.
     * @return Id que identifica al género.
     */
	public String getId() {
		return id;
    }

	/**
	 * Método setter del id del género.
	 * @param id Id que identifica al género.
	 * @throws ErrorCreacionObjeto
	 */
    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;    
    }

    /**
     * Método toString del género.
     * @return Id que identifica el género.
     */
    public String toString() {
    		return id;
    }
}
