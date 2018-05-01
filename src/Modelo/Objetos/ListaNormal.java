package Modelo.Objetos;

import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public class ListaNormal implements Lista {
	
	private String nombre;
	private String id;
    private List<Cancion> canciones;
	
    public ListaNormal(String id, String nombre, List<Cancion> canciones) throws ErrorCreacionObjeto {
    	this.setId(id);
    	this.setNombre(nombre);
    	this.setCanciones(canciones);
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

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public void insertaCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}

	@Override
	public void eliminaCancion(Cancion cancion) {
		this.canciones.remove(cancion);
	}
	
}
