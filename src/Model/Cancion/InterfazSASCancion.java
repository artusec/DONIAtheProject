package Model.Cancion;

import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazSASCancion {
	void creaCancion(String titulo, String autor, String album,
					int duracion, Letra letra, Video video, Genero genero) throws ErrorCreacionObjeto;
	void eliminaCancion(Cancion cancion);
    String descargaVideo(String cancion);
    Cancion consultaCancion(String idCancion);
    Letra consultaLetra(String idCancion);
    Video consultaVideo(String idCancion);
}
