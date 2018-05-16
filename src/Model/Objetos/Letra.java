package Model.Objetos;

import Excepciones.ErrorCreacionObjeto;

public class Letra {

    private String id;
    private String texto;

    public Letra(String id, String texto) throws ErrorCreacionObjeto {
		this.setId(id);
		texto = texto.replace("'", ""); //Quitamos las comillas simples por problemas con la BD
		texto = texto.replace(";", ",");
		this.setTexto(texto);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws ErrorCreacionObjeto {
		if (id == null) throw new ErrorCreacionObjeto();
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
