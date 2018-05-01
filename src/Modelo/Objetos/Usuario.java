package Modelo.Objetos;
import java.util.List;

import Excepciones.ErrorCreacionObjeto;

public class Usuario {
    
    private String id;
    private String nombre;
    private String clave;
    public List<Genero> gustos;

    public Usuario(String id, String nombre, String clave, List<Genero> gustos) throws ErrorCreacionObjeto {
	    	this.setId(id);
	    	this.setNombre(nombre);
	    	this.setClave(clave);
	    	this.setGustos(gustos);
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

    public String getClave() {
		return clave;
    }

    public void setClave(String clave) throws ErrorCreacionObjeto {
    		if (clave == null) throw new ErrorCreacionObjeto();
    		this.clave = clave;
    }
    
    public List<Genero> getGustos(){
		return gustos;
    }
    
	public void setGustos(List<Genero> gustos) {
		this.gustos = gustos;
	}
}
