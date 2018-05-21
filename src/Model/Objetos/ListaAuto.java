package Model.Objetos;

import java.util.ArrayList;

import Excepciones.ErrorCreacionObjeto;

/**
 * Clase ListaAuto. Extiende a ListaNormal.
 * @author Raúl
 *
 */
public class ListaAuto extends ListaNormal {
	
	private Genero genero;
	
	/**
	 * Constructora de la clase. 
	 * Llama a la constructora de ListaNormal.
	 * @param id Id que identifica a la lista.
	 * @param nombre Nombre de la lista.
	 * @param genero Género de las canciones con las que se creara la lista.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
    public ListaAuto(String id, String nombre, Genero genero) throws ErrorCreacionObjeto {
    		super(id, nombre);
    		this.setGenero(genero);
    }

    /**
     * Constructora de la clase con una lista de canciones.
     * Llama a la constructora de ListaNormal.
     * @param id Id que identifica a la lista.
     * @param nombre Nombre de la lista.
     * @param genero Género de las canciones con las que se creara la lista.
     * @param canciones Lista de canciones.
     * @throws ErrorCreacionObjeto Si la id es null.
     */
    public ListaAuto(String id, String nombre, Genero genero, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		super(id, nombre, canciones);
		this.setGenero(genero);
    }
    
    /**
     * Método setter del género de la lista.
     * @param genero Género de las canciones con las que se creara la lista.
     * @throws ErrorCreacionObjeto Si la id es null.
     */
	public void setGenero(Genero genero) throws ErrorCreacionObjeto {
		if (genero == null) throw new ErrorCreacionObjeto();
		this.genero = genero;
	}
	
	/**
	 * Método getter del género de la lista.
	 * @return Género de las canciones con las que se creara la lista.
	 */
	public Genero getGenero() {
		return genero;
	}
}