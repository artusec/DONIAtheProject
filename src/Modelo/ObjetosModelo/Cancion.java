package Modelo.ObjetosModelo;

public class Cancion {

    private String id;
    private String titulo;
    private String autor;
    private String album;
    private int duracion;
    public Letra letra;
    public Video video;
    public Genero genero;

    public String getId() {
		return id;
    }

    public void setId(String id) {
    	this.id = id;
    }

    public String getTítulo() {
		return titulo;
    }

    public void setTítulo(String titulo) {
    	this.titulo = titulo;
    }

    public String getAutor() {
		return autor;
    }

    public void setAutor(String autor) {
    	this.autor = autor;
    }

    public String getÁlbum() {
		return album;
    }

    public void setÁlbum(String album) {
    	this.album = album;
    }

    public int getDuración() {
		return duracion;
    }

    public void setDuración(int duracion) {
    	if(duracion > 0)
    		this.duracion = duracion;
    }
}
