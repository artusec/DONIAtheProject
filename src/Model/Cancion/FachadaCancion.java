package Model.Cancion;

import Excepciones.ErrorCreacionObjeto;
import Model.Objetos.*;

public class FachadaCancion implements InterfazFachadaCancion {
    
	public InterfazSASCancion interfazSASCancion;

    public void creaCancion(String titulo, String autor, String album, int duracion,
			Genero genero, Letra letra, Video video) throws ErrorCreacionObjeto {
    		interfazSASCancion.creaCancion(titulo, autor, album, duracion, letra, video, genero);
	}
	
	public void eliminaCancion(Cancion cancion) {
		interfazSASCancion.eliminaCancion(cancion);
	}
	
    public Video consultaVideo(String cancion) {
    		return interfazSASCancion.consultaVideo(cancion);
    }

    public Letra consultaLetra(String cancion) {
    		return interfazSASCancion.consultaLetra(cancion);
    }

    public Cancion consultaCancion(String cancion) {
    		return interfazSASCancion.consultaCancion(cancion);
    }

    public String descargaVideo(String cancion) {
    		return interfazSASCancion.descargaVideo(cancion);
    }
}
