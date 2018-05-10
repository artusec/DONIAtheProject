package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public class FachadaCancion implements InterfazFachadaCancion {
    
	public InterfazSASCancion sasCancion;

	public FachadaCancion() {
		sasCancion = new SASCancion();
	}
	
    public void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado {
    		sasCancion.creaCancion(cancion);
	}
	
	public void eliminaCancion(Cancion cancion) throws ErrorEliminacion {
		sasCancion.eliminaCancion(cancion);
	}
	
    public Video consultaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasCancion.consultaVideo(cancion);
    }

    public Letra consultaLetra(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasCancion.consultaLetra(cancion);
    }

    public Cancion consultaCancion(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasCancion.consultaCancion(cancion);
    }

    public String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasCancion.descargaVideo(cancion);
    }
}
