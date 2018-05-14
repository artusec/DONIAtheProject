package Controlador.DAO;

/**
 * Esta clase proporciona las serntencias SQL para la creacion de tablas, insercion,
 * eliminacion y actualizacion en maria
 * 
 * @author borja
 */
public abstract class DBstruct {
	
	// IDs ENTIDADES UNICAS OBLIGATORIAS
	private static String idUsuarioAdmin = "u0";
	private static String idBiblioteca = "l0";
	
	// SENTENCIAS CREACION TABLAS
	private static String initTodo = "DROP TABLE 'rusuariogenero';\n" + 
			"DROP TABLE 'rlistacancion';\n" + 
			"DROP TABLE 'cancion';\n" + 
			"DROP TABLE 'video';\n" + 
			"DROP TABLE 'letra';\n" + 
			"DROP TABLE 'biblioteca';\n" + 
			"DROP TABLE 'listaauto';\n" + 
			"DROP TABLE 'genero';\n" + 
			"DROP TABLE 'listanormal';\n" + 
			"DROP TABLE 'lista';\n" + 
			"DROP TABLE 'usuarioadmin';\n" + 
			"DROP TABLE 'usuario';\n" + 
			"\n" + 
			"CREATE TABLE 'usuario' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) DEFAULT NULL,\n" + 
			"  'clave' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'usuarioadmin' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario'),\n" + 
			"  CONSTRAINT 'usuarioadmin_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'lista' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'listanormal' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  KEY 'listanormal_usuario_FK' ('usuario'),\n" + 
			"  CONSTRAINT 'listanormal_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'listanormal_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'genero' (\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('genero')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'listaauto' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  KEY 'listaauto_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_listanormal_FK' FOREIGN KEY ('lista') REFERENCES 'listanormal' ('lista') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'biblioteca' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  CONSTRAINT 'biblioteca_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'letra' (\n" + 
			"  'texto' text NOT NULL,\n" + 
			"  'letra' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('letra')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'video' (\n" + 
			"  'enlace' varchar(100) NOT NULL,\n" + 
			"  'enlaceDescarga' varchar(100) DEFAULT NULL,\n" + 
			"  'video' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('video')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'cancion' (\n" + 
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
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'rlistacancion' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'cancion' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista','cancion'),\n" + 
			"  KEY 'rlistacancion_cancion_FK' ('cancion'),\n" + 
			"  CONSTRAINT 'rlistacancion_cancion_FK' FOREIGN KEY ('cancion') REFERENCES 'cancion' ('cancion') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rlistacancion_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n" + 
			"\n" + 
			"CREATE TABLE 'rusuariogenero' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario','genero'),\n" + 
			"  KEY 'rusuariogenero_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'rusuariogenero_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rusuariogenero_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
	
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
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";

	private static String video = "CREATE TABLE 'video' (\n" + 
			"  'enlace' varchar(100) NOT NULL,\n" + 
			"  'enlaceDescarga' varchar(100) DEFAULT NULL,\n" + 
			"  'video' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('video')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n;";
	private static String letra = "CREATE TABLE 'letra' (\n" + 
			"  'texto' text NOT NULL,\n" + 
			"  'letra' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('letra')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String genero = "CREATE TABLE 'genero' (\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('genero')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String lista = "CREATE TABLE 'lista' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String rlistacancion = "CREATE TABLE 'rlistacancion' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'cancion' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista','cancion'),\n" + 
			"  KEY 'rlistacancion_cancion_FK' ('cancion'),\n" + 
			"  CONSTRAINT 'rlistacancion_cancion_FK' FOREIGN KEY ('cancion') REFERENCES 'cancion' ('cancion') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rlistacancion_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String listaauto = "CREATE TABLE 'listaauto' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  KEY 'listaauto_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero'),\n" + 
			"  CONSTRAINT 'listaauto_listanormal_FK' FOREIGN KEY ('lista') REFERENCES 'listanormal' ('lista') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String listanormal = "CREATE TABLE 'listanormal' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  KEY 'listanormal_usuario_FK' ('usuario'),\n" + 
			"  CONSTRAINT 'listanormal_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'listanormal_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String biblioteca = "CREATE TABLE 'biblioteca' (\n" + 
			"  'lista' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('lista'),\n" + 
			"  CONSTRAINT 'biblioteca_lista_FK' FOREIGN KEY ('lista') REFERENCES 'lista' ('lista')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String usuario = "CREATE TABLE 'usuario' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'nombre' varchar(100) DEFAULT NULL,\n" + 
			"  'clave' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario')\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String rusuariogenero = "CREATE TABLE 'rusuariogenero' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  'genero' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario','genero'),\n" + 
			"  KEY 'rusuariogenero_genero_FK' ('genero'),\n" + 
			"  CONSTRAINT 'rusuariogenero_genero_FK' FOREIGN KEY ('genero') REFERENCES 'genero' ('genero') ON DELETE CASCADE ON UPDATE CASCADE,\n" + 
			"  CONSTRAINT 'rusuariogenero_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	private static String usuarioadmin = "CREATE TABLE 'usuarioadmin' (\n" + 
			"  'usuario' varchar(100) NOT NULL,\n" + 
			"  PRIMARY KEY ('usuario'),\n" + 
			"  CONSTRAINT 'usuarioadmin_usuario_FK' FOREIGN KEY ('usuario') REFERENCES 'usuario' ('usuario') ON DELETE CASCADE ON UPDATE CASCADE\n" + 
			") ENGINE=InnoDB DEFAULT CHARSET=latin1 \n";
	
	// IDs ENTIDADES UNICAS OBLIGATORIAS
	public static String getIdBiblioteca() {
		return idBiblioteca;
	}
	public static String getIdUsuarioAdmin() {
		return idUsuarioAdmin;
	}
	
	// SENTENCIAS CREACION TABLAS
	public static String getInitTodo() {
		return initTodo;
	}
	public static String getCancion() {
		return cancion;
	}
	public static String getVideo() {
		return video;
	}
	public static String getLetra() {
		return letra;
	}
	public static String getGenero() {
		return genero;
	}
	public static String getLista() {
		return lista;
	}
	public static String getRlistacancion() {
		return rlistacancion;
	}
	public static String getListaauto() {
		return listaauto;
	}
	public static String getListanormal() {
		return listanormal;
	}
	public static String getBiblioteca() {
		return biblioteca;
	}
	public static String getUsuario() {
		return usuario;
	}
	public static String getRusuariogenero() {
		return rusuariogenero;
	}
	public static String getUsuarioadmin() {
		return usuarioadmin;
	}
	
	//SENTENCIAS DE INSERCION
	public static String insertCancion(String id, String titulo, String autor, int duracion, String album,
			String genero, String video, String letra) {
		return 	"INSERT INTO donia.cancion\n" +
				"(cancion, titulo, autor, duracion, album, genero, video, letra)\n" +
				"VALUES('" + id + "', " + "'" + titulo + "', " + "'" + autor + "', " + "'" + duracion + "', " +
				"'" + album + "', " + "'" + genero + "', " + "'" + video + "', " + "'" + letra + "');\n";
	}
	
	public static String insertaLetra(String id, String texto) {
		return "INSERT INTO donia.letra\n" + 
				"(texto, letra)\n" + 
				"VALUES('"+ texto +"', '"+ id +"');\n";
	}
	
	public static String insertaVideo(String id, String enlace, String descarga) {
		return "INSERT INTO donia.video\n" + 
				"(enlace, enlaceDescarga, video)\n" + 
				"VALUES('"+ enlace +"', '"+ descarga +"', '"+ id +"');\n";
	}
	
	public static String insertUsuario(String id, String nombre, String clave) {
		return "INSERT INTO donia.usuario\n" +
				"(usuario, nombre, clave)\n" +
				"VALUES('" + id + "', '" + nombre + "', '"  + clave + "')\n";
	}
	
	public static String insertGenero(String id) {
		return "INSERT INTO donia.genero\n" +
				"(genero)\n" +
				"VALUES('" + id + "');\n";
	}
	
	public static String insertLista(String id, String nombre) {
		return "INSERT INTO donia.lista\n" +
				"(lista, nombre)\n" +
				"VALUES('" + id + "', " + "'" + nombre + "');\n";
	}
	
	public static String insertListaNormal(String lista, String usuario) {
		return "INSERT INTO donia.listanormal\n" +
		"(lista, usuario)\n" +
		"VALUES('" + lista + "', " + "'" + usuario + "');\n";
	}
	
	public static String insertListaAuto(String lista, String genero) {
		return "INSERT INTO donia.listaauto\n" +
				"(lista, genero)\n" +
				"VALUES('" + lista + "', " + "'" + genero + "');\n";
	}
	
	public static String insertRlistaCancion(String lista, String cancion) {
		return 	"INSERT INTO donia.rlistacancion\n" +
				"(lista, cancion) \n" +
				"VALUES('" + lista + "', " + "'" + cancion + "');\n";
	}
	
	public static String insertRgeneroUsuario(String genero, String usuario) {
		return 	"INSERT INTO donia.rgenerousuario\n" +
				"(genero, usuario)\n" +
				"VALUES('" + genero + "'," + "'" + usuario + "');\n";
	}
	
	//SENTENCIAS DE ACTUALIZACION
	public static String updateCancion(String id, String titulo, String autor, int duracion, String album,
			String genero, String video, String letra) {
		return 	"UPDATE donia.cancion \n" +
				"SET titulo='" + titulo + "', autor='" + autor + "', duracion=" + duracion + 
				", album='" + album + "', genero='" + genero + "', video='" + video + "', letra='" + letra + "' \n" +
				"WHERE cancion='" + id + "'";
	}
	public static String updateUsuario(String id, String nombre, String clave) {
		return 	"UPDATE donia.usuario\n" +
		"SET nombre='" + nombre + "', clave=" + clave + "' \n" +
		"WHERE usuario='" + id + "';\n";
	}
	
	public static String updateGenero(String id, String nombre) {
		return 	"UPDATE donia.genero \n" +
				"SET nombre='" + nombre + "' \n" +
				"WHERE genero='" + id + "'";
	}
	
	public static String updateLista(String id, String nombre) {
		return "UPDATE donia.lista \n" +
				"SET nombre='" + nombre + "' \n" +
				"WHERE genero='" + id + "'";
	}
	public static String updateGeneroLista(String idLista, String idGenero) {
		return "UPDATE donia.listaauto\n" + 
				"SET genero='"+ idGenero +"' " + 
				"WHERE lista='" + idLista + "'";
	}
	
	// SENTENCIAS DE ELIMINACION
	public static String deleteLista(String idLista) {
		return "DELETE FROM donia.lista \n" + 
				"WHERE lista='" + idLista + "'";
	}
	
	public static String deleteCancion(String idCancion) {
		return "DELETE FROM donia.cancion \n" + 
				"WHERE cancion='" + idCancion + "'";
	}
	
	public static String deleteGenero(String idGenero) {
		return "DELETE FROM donia.genero \n" + 
				"WHERE genero='" + idGenero + "'";
	}
	public static String deleteUsuario(String idUsuario) {
		return "DELETE FROM donia.usuario \n" + 
				"WHERE usuario='" + idUsuario + "'";
	}
	
	public static String deleteRlistaCancion(String idLista) {
		return "DELETE FROM donia.rlistacancion \n" + 
				"WHERE lista='" + idLista + "'";
	}
	
	public static String deleteRgeneroUsuario(String idUsuario, String idGenero) {
		return "DELETE FROM donia.rgenerousuario \n" + 
				"WHERE usuario='" + idUsuario + "' AND cancion='" + idGenero + "'";
	}
	
	
	public static String deleteRgenerosUsuario(String idUsuario) {
		return "DELETE FROM donia.rgenerousuario \n" + 
				"WHERE usuario='" + idUsuario + "'";
	}
}
