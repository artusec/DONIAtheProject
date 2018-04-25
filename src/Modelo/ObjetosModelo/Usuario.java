package Modelo.ObjetosModelo;
import java.util.List;

public class Usuario {
    
    private String id;
    private String nombre;
    private String clave;
    public List<Genero> gustos;

    public String getId() {
		return clave;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public String getNombre() {
		return clave;
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
