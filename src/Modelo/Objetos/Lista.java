package Modelo.Objetos;

import java.util.ArrayList;
import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public abstract class Lista {
	
	private String id;
	private String nombre;
	private ArrayList<Cancion> canciones;
	
	public Lista(String id, String nombre) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.inicializaCanciones();
	}

	public Lista(String id, String nombre, ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
		this.setId(id);
		this.setNombre(nombre);
		this.setCanciones(canciones); //solo para las listas creadas en el dao
	}
	
	private void inicializaCanciones() {
		this.canciones = new ArrayList<Cancion>();
	}
	
    private void setCanciones(ArrayList<Cancion> canciones) throws ErrorCreacionObjeto {
    		if (canciones == null) throw new ErrorCreacionObjeto();
		this.canciones = canciones;
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
	
	public int getDuracion() {
		int total = 0;
		for (Cancion cancion : canciones) {
			total += cancion.getDuracion();
		}
	
		return total;
	}
}
