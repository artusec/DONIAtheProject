package Controlador.DAO;

/**
 * Esta clase proporciona las serntencias SQL para la creacion de datos en maria
 * 
 * @author borja
 */
public abstract class DBstruct {
	private static String cancion = "CREATE TABLE 'cancion' (\n" + 
			"  'id' varchar(100) NOT NULL,\n" + 
			"  'titulo' varchar(100) NOT NULL,\n" + 
			"  'autor' varchar(100) DEFAULT NULL,\n" + 
			"  'duracion' time DEFAULT NULL,\n" + 
			"  'album' varchar(100) DEFAULT NULL,\n" + 
			"  'genero' varchar(100) DEFAULT NULL,\n" + 
			"  'video' varchar(100) DEFAULT NULL,\n" + 
			"  'letra' varchar(100) DEFAULT NULL,\n" + 
			"  PRIMARY KEY ('id'),\n" + 
			"  KEY 'cancion_letra_FK' ('letra'),\n" + 
			"  KEY 'cancion_video_FK' ('video'),\n" + 
			"  KEY 'cancion_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'cancion_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero') ON DELETE SET NULL ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'cancion_letra_FK' FOREIGN KEY ('letra') REFERENCES 'letra' ('letra') ON DELETE SET NULL ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'cancion_video_FK' FOREIGN KEY ('video') REFERENCES 'video' ('video') ON DELETE SET NULL ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	private static String video = "CREATE TABLE 'video' (\n" + 
			"  'enlace' varchar(100) NOT NULL,\n" + 
			"  'enlaceDescarga' varchar(100) DEFAULT NULL,\n" + 
			"  'video' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('video')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	private static String letra = "CREATE TABLE 'letra' (\n" + 
			"  'texto' text NOT NULL,\n" + 
			"  'letra' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('letra')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	private static String genero = "CREATE TABLE 'genero' (\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('genero')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	private static String lista;
	private static String listaCancion;
	private static String listaAuto;
	private static String listaNormal;
	private static String biblioteca;
	private static String usuario;
	private static String usuarioGeneros;
	private static String admin;
	
	public static String getCancion() {
		return cancion;
	}
	public static String getLetra() {
		return letra;
	}
	public static String getGenero() {
		return genero;
	}
}
