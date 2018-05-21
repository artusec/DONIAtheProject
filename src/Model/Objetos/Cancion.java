package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Cancion {

    private String id;
    private String titulo;
    private String autor;
    private String album;
    private double duracion; //en segundos
    private Letra letra;
    private Video video;
    private Genero genero;

    /**
     * Constructora de la clase.
     * @param id Id único en la DB.
     * @param titulo Titulo de la canción.
     * @param autor Autor de la canción.
     * @param album álbum de la canción.
     * @param duracion Duración de la canción.
     * @param letra Letra de la canción.
     * @param video Video de la canción (enlace al video y enlace de descarga).
     * @param genero Género de la canción.
     * @throws ErrorCreacionObjeto Si la id, título o duración son null.
     */
    public Cancion(String id, String titulo, String autor, String album,
    					double duracion, Letra letra, Video video, Genero genero) throws ErrorCreacionObjeto {
    		this.setId(id);
    		this.setTitulo(titulo);
    		this.setAutor(autor);
    		this.setAlbum(album);
    		this.setDuracion(duracion);
    		this.setLetra(letra);
    		this.setVideo(video);
    		this.setGenero(genero);
    }
    
    /**
     * Método getter del id de la canción.
     * @return Id único de la canción.
     */
    public String getId() {
		return id;
    }

    /**
     * Método setter de la canción
     * @param id Id con el que se identifica la canción. 
     * @throws ErrorCreacionObjeto Si la id es null.
     */
    public void setId(String id) throws ErrorCreacionObjeto {
    	if (id == null) throw new ErrorCreacionObjeto();
    		this.id = id;
    }

    /**
     * Método getter del título de la canción.
     * @return Título de la canción.
     */
    public String getTitulo() {
		return titulo;
    }

    /**
     * Método setter del título de la canción.
     * @param titulo Título de la canción
     * @throws ErrorCreacionObjeto Si el título es null.
     */
    public void setTitulo(String titulo) throws ErrorCreacionObjeto {
    		if (titulo == null) throw new ErrorCreacionObjeto();
    		this.titulo = titulo;
    }

    /**
     * Método getter del autor de la canción.
     * @return Autor de la canción.
     */
    public String getAutor() {
		return autor;
    }

    /**
     * Método setter del autor de la canción.
     * @param autor Autor de la canción.
     */
    public void setAutor(String autor) {
    		this.autor = autor;
    }

    /**
     * Método getter del álbum de la canción.
     * @return álbum de la canción.
     */
    public String getAlbum() {
		return album;
    }

    /**
     * Método setter del álbum de la canción.
     * @param album álbum de la canción.
     */
    public void setAlbum(String album) {
    		this.album = album;
    }

    /**
     * Método getter de la duración de la canción.
     * @return Duración de la canción.
     */
    public double getDuracion() {
		return duracion;
    }

    /**
     * Método setter de la duración de la canción.
     * @param duracion Duración de la canción.
     * @throws ErrorCreacionObjeto Si la duración es null.
     */
    public void setDuracion(double duracion) throws ErrorCreacionObjeto {
    		if (duracion < 0) throw new ErrorCreacionObjeto();
    		this.duracion = duracion;
    }

    /**
     * Método getter de la letra de la canción.
     * @return Letra de la canción.
     */
	public Letra getLetra() {
		return letra;
	}

	/**
	 * Método setter de la letra de la canción.
	 * @param letra Letra de la canción.
	 */
	public void setLetra(Letra letra) {
		this.letra = letra;
	}

	/**
	 * Método getter del video de la canción.
	 * @return Video de la canción.
	 */
	public Video getVideo() {
		return video;
	}

	/**
	 * Método setter del video de la canción.
	 * @param video Video de la canción.
	 */
	public void setVideo(Video video) {
		this.video = video;
	}

	/**
	 * Método getter del género de la canción.
	 * @return Género de la canción.
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * Método setter del género de la canción.
	 * @param genero Género de la canción.
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	/**
	 * Métoto toString. Representamos la canción con el nombre de su título.
	 * @return Título de la canción.
	 */
	public String toString() {
		return this.titulo;
	}
}
