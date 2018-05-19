package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public interface InterfazSASCancion {
	void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado;
	void eliminaCancion(Cancion cancion) throws ErrorEliminacion;
    String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto;
    Cancion consultaCancion(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
    Letra consultaLetra(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
    Video consultaVideo(String idCancion) throws ErrorConsulta, ErrorCreacionObjeto;
}