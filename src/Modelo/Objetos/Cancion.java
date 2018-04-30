package Modelo.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Cancion {

    private String id;
    private String titulo;
    private String autor;
    private String album;
    private int duracion; //en segundos
    public Letra letra;
    public Video video;
    public Genero genero;

    public Cancion(String id, String titulo, String autor, String album,
    					int duracion, Letra letra, Video video, Genero genero) throws ErrorCreacionObjeto {
    		this.setId(id);
    		this.setTitulo(titulo);
    		this.setAutor(autor);
    		this.setAlbum(album);
    		this.setDuracion(duracion);
    		this.setLetra(letra);
    		this.setTitulo(titulo);
    		this.setGenero(genero);
    }
    
    public String getId() {
		return id;
    }

    public void setId(String id) throws ErrorCreacionObjeto {
	    	if (id == null) throw new ErrorCreacionObjeto();
	    	this.id = id;
    }

    public String getTitulo() {
		return titulo;
    }

    public void setTitulo(String titulo) throws ErrorCreacionObjeto {
    		if (titulo == null) throw new ErrorCreacionObjeto();
    		this.titulo = titulo;
    }

    public String getAutor() {
		return autor;
    }

    public void setAutor(String autor) {
    	this.autor = autor;
    }

    public String getAlbum() {
		return album;
    }

    public void setAlbum(String album) {
    	this.album = album;
    }

    public int getDuracion() {
		return duracion;
    }

    public void setDuracion(int duracion) throws ErrorCreacionObjeto {
    		if (duracion < 0) throw new ErrorCreacionObjeto();
    		this.duracion = duracion;
    }

	public Letra getLetra() {
		return letra;
	}

	public void setLetra(Letra letra) {
		this.letra = letra;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
