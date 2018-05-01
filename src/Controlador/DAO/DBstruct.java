package Controlador.DAO;

/**
 * Esta clase proporciona las serntencias SQL para la creacion de datos en maria
 * 
 * @author borja
 */
public abstract class DBstruct {
	private static String cancion = "CREATE TABLE 'cancion' (\n" + 
			"  'cancion' varchar(100) NOT NULL,\n" + 
			"  'titulo' varchar(100) NOT NULL,\n" + 
			"  'autor' varchar(100) DEFAULT NULL,\n" + 
			"  'duracion' int(10) unsigned DEFAULT NULL,\n" + 
			"  'album' varchar(100) DEFAULT NULL,\n" + 
			"  'genero' varchar(100) DEFAULT NULL,\n" + 
			"  'video' varchar(100) DEFAULT NULL,\n" + 
			"  'letra' varchar(100) DEFAULT NULL,\n" + 
			"  PRIMARY KEY ('cancion'),\n" + 
			"  KEY 'cancion_letra_FK' ('letra'),\n" + 
			"  KEY 'cancion_video_FK' ('video'),\n" + 
			"  KEY 'cancion_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'cancion_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero') ON DELETE SET NULL ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'cancion_letra_FK' FOREIGN KEY ('letra') REFERENCES 'letra' ('letra') ON DELETE SET NULL ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'cancion_video_FK' FOREIGN KEY ('video') REFERENCES 'video' ('video') ON DELETE SET NULL ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
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
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String genero = "CREATE TABLE 'genero' (\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('genero')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String lista = "CREATE TABLE 'lista' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String rlistacancion = "CREATE TABLE 'rlistacancion' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'cancion' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista','cancion'),\n" + 
			"  KEY 'rlistacancion_cancion_FK' ('cancion'),\n" + 
			"  CONSTRAINT 'rlistacancion_cancion_FK' FOREIGN KEY ('cancion') REFERENCES 'cancion' ('cancion') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rlistacancion_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String listaauto = "CREATE TABLE 'listaauto' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  KEY 'listaauto_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String listanormal = "CREATE TABLE 'listanormal' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  CONSTRAINT 'listanormal_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String biblioteca = "CREATE TABLE 'biblioteca' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  CONSTRAINT 'biblioteca_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String usuario = "CREATE TABLE 'usuario' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) DEFAULT NULL,\n" + 
			"  'clave' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String rusuariogenero = "CREATE TABLE 'rusuariogenero' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario','genero'),\n" + 
			"  KEY 'rusuariogenero_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'rusuariogenero_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rusuariogenero_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String rusuariolista = "CREATE TABLE 'rusuariolista' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario','lista'),\n" + 
			"  KEY 'rusuariolista_lista_FK' ('lista'),\n" + 
			"  CONSTRAINT 'rusuariolista_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rusuariolista_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	private static String usuarioadmin = "CREATE TABLE 'usuarioadmin' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario'),\n" + 
			"  CONSTRAINT 'usuarioadmin_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1";
	
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
