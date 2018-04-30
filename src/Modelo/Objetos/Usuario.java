package Modelo.Objetos;
import java.util.List;

public class Usuario {
    
    private String id;
    private String nombre;
    private String clave;
    public List<Genero> gustos;

    public String getId() {
		return id;
    }

    public void setId(String id) {
    		this.id = id;
    }

    public String getNombre() {
		return nombre;
    }

    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }

    public String getClave() {
		return clave;
    }

    public void setClave(String clave) {
    		this.clave = clave;
    }
}
