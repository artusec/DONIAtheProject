package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public class FachadaCancion implements InterfazFachadaCancion {
    
	public InterfazSASCancion interfazSASCancion;

    public void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado {
    		interfazSASCancion.creaCancion(cancion);
	}
	
	public void eliminaCancion(Cancion cancion) throws ErrorEliminacion {
		interfazSASCancion.eliminaCancion(cancion);
	}
	
    public Video consultaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return interfazSASCancion.consultaVideo(cancion);
    }

    public Letra consultaLetra(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return interfazSASCancion.consultaLetra(cancion);
    }

    public Cancion consultaCancion(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return interfazSASCancion.consultaCancion(cancion);
    }

    public String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		return interfazSASCancion.descargaVideo(cancion);
    }
}
