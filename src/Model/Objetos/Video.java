package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Video {

	private String id;
    private String enlace;
    private String enlaceDescarga;

    public Video(String id, String enlace, String enlaceDescarga) throws ErrorCreacionObjeto {
		this.id = id;
		this.enlace = enlace;
		this.enlaceDescarga = enlaceDescarga;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws ErrorCreacionObjeto {
		if (id == null) throw new ErrorCreacionObjeto();
		this.id = id;
	}
    
	public String getEnlace() {
		return enlace;
    }

    public void setEnlace(String enlace) {
    		this.enlace = enlace;
    }

    public String getEnlaceDescarga() {
		return enlaceDescarga;
    }

    public void setEnlaceDescarga(String enlace) {
    		this.enlaceDescarga = enlace;
    }
}
