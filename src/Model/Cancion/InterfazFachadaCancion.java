package Model.Cancion;

import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public interface InterfazFachadaCancion {
    Cancion consultaCancion(String cancion) throws ErrorConsulta;
    Letra consultaLetra(String cancion) throws ErrorConsulta;
    Video consultaVideo(String cancion) throws ErrorConsulta;
    String descargaVideo(String cancion) throws ErrorConsulta;
    void creaCancion(String titulo, String autor, String album, int duracion,
    						Genero genero, Letra letra, Video video) throws ErrorCreacionObjeto;
    void eliminaCancion(Cancion cancion);
}
