package Model.Cancion;

import Controlador.DAO.DAOFachada;
import Controlador.DAO.InterfazDAOFachada;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

public class SASCancion implements InterfazSASCancion {
	
	private InterfazDAOFachada dao;
	
	//Para los siguientes metodos:
	//Si hubiese errores en el acceso a datos el dao nos notifica
	//Si letra (u otro atributo) no estuviese definida para el objeto, la gui recoge en null y no
	//	escribe nada en pantalla
	
	public SASCancion() {
		this.setDao();
	}
	
	private void setDao() {
		this.dao = new DAOFachada();
	}
	
	@Override
	/**
	 * Anade una cancion a la base de datos
	 * @param cancion cancion que se quiere anadir a la base de datos
	 * @throws ErrorCreacionObjeto
	 */
	public void creaCancion(Cancion cancion) throws ErrorCreacionObjeto, ErrorGuardado {
		//if (/*validar que el usuario actual es admin*/ true){ //Este if se hace en controlador
			//Cancion cancion = new Cancion(this.GeneradorId(), titulo, autor, album, duracion, letra, video, genero);
			if (cancion == null)
				throw new ErrorCreacionObjeto("Error al crear la cancion");
			else
				dao.setCancion(cancion);
				//la cancion deberia eliminarse anadirse sola a la biblioteca
	}
	
	@Override
	/**
	 * Elimina una cancion de la base de datos
	 * @param cancion cancion a eliminar
	 * @throws 
	 */
	public void eliminaCancion(Cancion cancion) throws ErrorEliminacion { 
		dao.eliminarCancion(cancion);
		//la cancion deberia eliminarse de la biblioteca en el dao
	}
	
	/**
	 * Devuelve una cancion de la DB
	 * @param cancion id de la cancion
	 * @return la cancion, null si no existe
	 * @throws ErrorConsulta 
	 * @throws ErrorCreacionObjeto 
	 */
	@Override
    public Cancion consultaCancion(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
    		Cancion cancion2 = this.dao.getCancionDB(cancion);
    		if (cancion2 == null)
    			throw new ErrorConsulta("Error al consultar cancion");
    		else
    			return cancion2;
    }
	
	/**
	 * Devuelve la letra de una cancion
	 * @param cancion id de la cancion
	 * @return la letra, null si no existe
	 * @throws ErrorConsulta 
	 * @throws ErrorCreacionObjeto 
	 */
	@Override
	public Letra consultaLetra(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		Letra letra = this.dao.getCancionDB(cancion).getLetra();
		if (letra == null)
			throw new ErrorConsulta("Error al consultar letra");
		else
			return letra;
	}
	
	/**
	 * Devuelve el video de una cancion
	 * @param cancion id de la cancion
	 * @return el video, null si no existe
	 * @throws ErrorConsulta 
	 * @throws ErrorCreacionObjeto 
	 */
	@Override
    public Video consultaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		Video video = this.dao.getCancionDB(cancion).getVideo();
		if (video == null)
			throw new ErrorConsulta("Error al consultar video");
		else
			return video;			
    }

	/**
	 * Devuelve el enlace de descarga del un video de la DB
	 * @param cancion id de la cancion
	 * @return el enlace a descarga video, null si no existe
	 * @throws ErrorConsulta 
	 * @throws ErrorCreacionObjeto 
	 */
	@Override
    public String descargaVideo(String cancion) throws ErrorConsulta, ErrorCreacionObjeto {
		String enlace = this.dao.getCancionDB(cancion).getVideo().getEnlaceDescarga();
		if (enlace == null)
			throw new ErrorConsulta("Enlace inexistente");
		else
			return enlace;
    }
}
