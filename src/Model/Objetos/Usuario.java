package Model.Objetos;

import java.util.ArrayList;
import Excepciones.ErrorCreacionObjeto;

/**
 * Clase que representa el objeto Usuario.
 * @author Raúl
 *
 */
public class Usuario {
    
    private String id;
    private String nombre;
    private String clave;
    public ArrayList<Genero> generos;

    /**
     * Constructora de la clase con una lista de géneros que le gustan al usuario.
     * @param id Id único en la DB que identifica al usuario.
     * @param nombre Nombre del usuario.
     * @param clave Constraseña del usuario.
     * @param generos Lista de géneros favoritos del usuario.
     * @throws ErrorCreacionObjeto Si la id, el nombre o la clave son nulos.
     */
    public Usuario(String id, String nombre, String clave, ArrayList<Genero> generos) throws ErrorCreacionObjeto {
	    	this.setId(id);
	    	this.setNombre(nombre);
	    	this.setClave(clave);
	    	this.setGustos(generos);
	}

    /**
     * Constructora de la clase.
     * @param id Id único en la DB que identifica al usuario.
     * @param nombre Nombre del usuario.
     * @param clave Constraseña del usuario.
     * @throws ErrorCreacionObjeto Si la id, el nombre o la clave son nulos.
     */
    public Usuario(String id, String nombre, String clave) throws ErrorCreacionObjeto {
	    	this.setId(id);
	    	this.setNombre(nombre);
	    	this.setClave(clave);
	}
    
    /**
     * Método getter del id del usuario.
     * @return Id único en la DB que identifica al usuario.
     */
	public String getId() {
		return id;
    }

	/**
	 * Método setter del id del usuario.
	 * @param id Id único en la DB que identifica al usuario.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;
    }

    /**
     * Método getter del nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
		return nombre;
    }

    /**
     * Método setter del nombre del usuario.
     * @param nombre Nombre que se pone al usuario.
     * @throws ErrorCreacionObjeto Si el nombre es null.
     */
    public void setNombre(String nombre) throws ErrorCreacionObjeto {
    		if (nombre == null) throw new ErrorCreacionObjeto();
    		this.nombre = nombre;
    }

    /**
     * Método getter de la clave del usuario.
     * @return Clave del usuario.
     */
    public String getClave() {
		return clave;
    }

    /**
     * Método setter de la clave del usuario.
     * @param clave Clave que se pone al usuario.
     * @throws ErrorCreacionObjeto Si la clave es null.
     */
    public void setClave(String clave) throws ErrorCreacionObjeto {
    		if (clave == null) throw new ErrorCreacionObjeto();
    		this.clave = clave;
    }
    
    /**
     * Método getter de la lista de gustos del usuario.
     * @return ArrayList de gustos del usuario.
     */
    public ArrayList<Genero> getGustos(){
		return generos;
    }
    
    /**
     * Método setter de gustos del usuario.
     * @param gustos Lista de gustos que se le establecen al usuario.
     */
	public void setGustos(ArrayList<Genero> gustos) {
		this.generos = gustos;
	}
}
