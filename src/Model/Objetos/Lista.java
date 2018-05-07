package Model.Objetos;

import java.util.ArrayList;
import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public abstract class Lista {
	
	private String id;
	private String nombre;
	private ArrayList<Cancion> canciones;
	
	/**
	 * Construye una lista sin canciones
	 * @param id id de lista
	 * @param nombre nombre de lista
	 * @throws ErrorCreacionObjeto si no se ha podido crear la lista
	 */
	public Lista(String id, String nombre) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.inicializaCanciones();
	}

	/**
	 * Construye una lista con canciones. Ideado para ser invocado desde el DAO
	 * @param id id de lista
	 * @param nombre nombre de lista
	 * @param canciones lista de canciones
	 * @throws ErrorCreacionObjeto si no se ha podido crear la lista
	 */
	public Lista(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.setCanciones(canciones); //solo para las listas creadas en el dao
	}
	
	/**
	 * Inicializa a vacia la lista de canciones
	 */
	private void inicializaCanciones() {
		this.canciones = new ArrayList<Cancion>();
	}
	
    private void setCanciones(ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
    		if (canciones == null) throw new ErrorCreacionObjeto();
    			this.canciones = canciones;
	}

    /**
     * Anade una cancion a la lista (siempre que no este ya anadida)
     * @param cancion cancion a anadir
     */
    public void anadirCancion(Cancion cancion) {
    		if (cancion != null && !canciones.contains(cancion))
    			canciones.add(cancion);
    }
    
    /**
     * Elimina una cancion de la lista
     * @param cancion cancion a anadir
     */
    public void eliminarCancion(Cancion cancion) {
		if (cancion != null)
			canciones.remove(cancion);
    }
    
	public String getId() {
		return this.id;
    }

    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;
    }

    public String getNombre() {
		return this.nombre;
    }

    public void setNombre(String nombre) {
    		this.nombre = nombre;
    }
    
	public List<Cancion> getCanciones(){
		return this.canciones;
	}
	
	/**
	 * Calcula la duracion de la lista
	 * @return
	 */
	public int getDuracion() {
		int total = 0;
		for (Cancion cancion : canciones)
			total += cancion.getDuracion();
		return total;
	}
}
