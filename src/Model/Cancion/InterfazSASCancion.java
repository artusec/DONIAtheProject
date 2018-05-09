package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazSASCancion {
	void creaCancion(Cancion cancion) throws ErrorCreacionObjeto;
	void eliminaCancion(Cancion cancion);
    String descargaVideo(String cancion) throws ErrorConsulta;
    Cancion consultaCancion(String idCancion) throws ErrorConsulta;
    Letra consultaLetra(String idCancion) throws ErrorConsulta;
    Video consultaVideo(String idCancion) throws ErrorConsulta;
}
