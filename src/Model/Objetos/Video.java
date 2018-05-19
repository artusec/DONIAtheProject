package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Video {

	private String id;
    private String enlace;
    private String enlaceDescarga;

    /**
     * Constructora de la clase.
     * @param id Id que identifica al video.
     * @param enlace Enlace al video.
     * @param enlaceDescarga Enlace de descarga del video.
     * @throws ErrorCreacionObjeto
     */
    public Video(String id, String enlace, String enlaceDescarga) throws ErrorCreacionObjeto {
		this.id = id;
		this.enlace = enlace;
		this.enlaceDescarga = enlaceDescarga;
	}

    /**
     * Método getter de la id del video.
     * @return Id que identifica al video.
     */
	public String getId() {
		return id;
	}

	/**
	 * Método setter del id del video.
	 * @param id Id que identifica al video.
	 * @throws ErrorCreacionObjeto
	 */
	public void setId(String id) throws ErrorCreacionObjeto {
		if (id == null) throw new ErrorCreacionObjeto();
		this.id = id;
	}
    
	/**
	 * Método getter del enlace del video.
	 * @return Enlace al video.
	 */
	public String getEnlace() {
		return enlace;
    }

	/**
	 * Método setter del enlace del video.
	 * @param enlace Enlace al video.
	 */
    public void setEnlace(String enlace) {
    		this.enlace = enlace;
    }

    /**
     * Método getter del enlace de descarga del video.
     * @return Enlace de descarga del video.
     */
    public String getEnlaceDescarga() {
		return enlaceDescarga;
    }

    /**
     * Método setter del enlace de descarga del video.
     * @param enlace Enlace de descarga del video.
     */
    public void setEnlaceDescarga(String enlace) {
    		this.enlaceDescarga = enlace;
    }
}
