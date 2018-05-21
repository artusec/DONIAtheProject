package Model.Objetos;

import java.util.ArrayList;
import Excepciones.ErrorCreacionObjeto;

/**
 * Clase abstrata que representa el objeto Lista.
 * @author Raúl
 *
 */
public abstract class Lista {
	
	private String id;
	private String nombre;
	private ArrayList<Cancion> canciones;
	
	/**
	 * Construye una lista sin canciones.
	 * @param id Id de lista
	 * @param nombre Nombre de lista
	 * @throws ErrorCreacionObjeto Error si no se ha podido crear la lista.
	 */
	public Lista(String id, String nombre) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.inicializaCanciones();
	}

	/**
	 * Construye una lista con canciones. Ideado para ser invocado desde el DAO.
	 * @param id Id de lista.
	 * @param nombre Nombre de lista.
	 * @param canciones Lista de canciones.
	 * @throws ErrorCreacionObjeto Error si no se ha podido crear la lista.
	 */
	public Lista(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.setCanciones(canciones); //solo para las listas creadas en el dao
	}
	
	/**
	 * Inicializa a vacia la lista de canciones.
	 */
	private void inicializaCanciones() {
		this.canciones = new ArrayList<Cancion>();
	}
	
	/**
	 * Método setter de la lista de canciones.
	 * @param canciones Lista de canciones.
	 * @throws ErrorCreacionObjeto Si la lista de canciones es null.
	 */
    private void setCanciones(ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		if (canciones == null) throw new ErrorCreacionObjeto();
			this.canciones = canciones;
	}

    /**
     * Añade una canción a la lista (siempre que no esté ya añadida)
     * @param cancion Canción a añadir.
     */
    public void anadirCancion(Cancion cancion) {
		if (cancion != null && !canciones.contains(cancion))
			canciones.add(cancion);
    }
    
    /**
     * Elimina una canción de la lista.
     * @param cancion Canción a añadir.
     */
    public void eliminarCancion(Cancion cancion) {
		if (cancion != null)
			canciones.remove(cancion);
    }
    
    /**
     * Método getter del id de la lista.
     * @return Id que identifica a la lista.
     */
	public String getId() {
		return this.id;
    }

	/**
	 * Método setter del id de la lista.
	 * @param id Id que identifica a la lista.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
    public void setId(String id) throws ErrorCreacionObjeto {
    	if (id == null) throw new ErrorCreacionObjeto();
    	this.id = id;
    }

    /**
     * Método getter del nombre de la lista.
     * @return Nombre de la lista.
     */
    public String getNombre() {
		return this.nombre;
    }

    /**
     * Método setter del nombre de la lista.
     * @param nombre Nombre de la lista.
     */
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    /**
     * Método getter de la lista de canciones.
     * @return Lista de canciones.
     */
	public ArrayList<Cancion> getCanciones(){
		return this.canciones;
	}
	
	/**
	 * Calcula la duración de la lista.
	 * @return Duración total de la lista.
	 */
	public int getDuracion() {
		int total = 0;
		for (Cancion cancion : canciones)
			total += cancion.getDuracion();
		return total;
	}

	/**
	 * 	Método toString de la lista.
	 * @return String con el nombre de la lista.
	 */
	@Override
	public String toString() {
		return nombre;
	}
}
