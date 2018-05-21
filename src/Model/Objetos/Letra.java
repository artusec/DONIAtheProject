package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

/**
 * Clase que representa el objeto Letra.
 * @author Raúl
 *
 */
public class Letra {

    private String id;
    private String texto;

    /**
     * Constructora de la clase.
     * @param id Id que identifica la letra.
     * @param texto String con toda la letra de la canción.
     * @throws ErrorCreacionObjeto Si la id es null.
     */
    public Letra(String id, String texto) throws ErrorCreacionObjeto {
		this.setId(id);
		texto = texto.replace("'", "");
		texto = texto.replace(";", ",");
		this.setTexto(texto);
	}

    /**
     * Método getter del id de la letra.
     * @return Id que identifica la letra.
     */
	public String getId() {
		return id;
	}

	/**
	 * Método setter del id de la letra.
	 * @param id Id que identifica la letra.
	 * @throws ErrorCreacionObjeto Si la id es null.
	 */
	public void setId(String id) throws ErrorCreacionObjeto {
		if (id == null) throw new ErrorCreacionObjeto();
		this.id = id;
	}

	/**
	 * Método getter del texto de la letra.
	 * @return String que contiene toda la letra.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Método setter del texto de la letra.
	 * @param texto String que contiene toda la letra.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
}