package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.*;

/**
 * Clase SASDAO, implementa los métodos necesarios para leer y escribir
 * de la base de datos. GJ.
 */
public class SASDAO implements InterfazSASDAO {
	
	private static final String JDBC = "org.mariadb.jdbc.Driver";
	private static final String DBsys = "mariadb";
	private static final String DBhost = "127.0.0.1";
	private static final String DBnom = "donia";
	private static String DBserver = "jdbc:mariadb://127.0.0.1/donia";
	private Connection DBconn = null;
	//acceso
	private static final String USER = "usr";
    private static final String PASS = "usr";
    
    /**
     * Constructor de la clase, inicializa algunos argumentos y accede a los datos de la DB.
     */
    public SASDAO() {
    		SASDAO.DBserver = "jdbc:" + SASDAO.DBsys + "://" + DBhost + "/" + SASDAO.DBnom;
    		try {
			this.conectaDB();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Inicializa la estructura de la base de datos. Para la primera ejecucion.
     * @throws SQLException Error SQL.
     * @throws ClassNotFoundException Si no existe esta clase (no debería suceder)
     */
    public void initDB() throws ClassNotFoundException, SQLException {
    		//requisito: crear una mariaDB en localhost que sa llame donia con user = usr pass = usr
    		
    		// Para crear la tabla y usuario en mariaDB:
    	
    		// Arrancar mariaDB server en modo administrador y ejecutar las siguientes sentencias
    		// "CREATE DATABASE donia;"
    		// "CONNECT donia;"
    		// "CREATE USER usr IDENTIFIED BY 'usr';"
    		// ejecutar el script de inicializacion
    	
    		//creacion de tablas (alternativo al script)
    		this.conectaDB();
    		if (this.conectado()) {
    			/*String sentencia = DBstruct.getUsuario() + DBstruct.getUsuarioadmin() +
    					DBstruct.getGenero() + DBstruct.getRusuariogenero() +
    					DBstruct.getLista() + DBstruct.getBiblioteca() +
    					DBstruct.getListanormal() + DBstruct.getListaauto() +
    					DBstruct.getLetra() + DBstruct.getVideo() +
    					DBstruct.getCancion() + DBstruct.getRlistacancion();*/
		    PreparedStatement ps = this.DBconn.prepareStatement(DBstruct.getInitTodo());
		    ps.executeQuery();
    		}
    }
    
    /**
     * Inicializa conexion con mariaDB
     * @throws SQLException Si no existe esta clase.
     * @throws ClassNotFoundException Si no existe esta clase (no debería suceder)
     */
    private void conectaDB() throws SQLException, ClassNotFoundException {
        //driver
        Class.forName(SASDAO.JDBC);
        //conectame
        System.out.println("Conectando a MariaDB...");
        this.DBconn = DriverManager.getConnection(DBserver, USER, PASS);
        System.out.println("Conectao! " + SASDAO.USER + " " + SASDAO.DBserver);
    }
    
    public void cierraDB() throws SQLException {
    		this.DBconn.close();
    }
    
    /**
     * Check de si esta conectado a la DB
     * @return True si está conectado, false si no.
     * @throws SQLException Error SQL.
     */
    private boolean conectado() throws SQLException {
    		return this.DBconn != null && !this.DBconn.isClosed();
    }
    
    // --------------- GET ---------------
    /**
     * Implementación de getCancionDB, hace lo descrito en la interfaz.
     */
    @Override
    public Cancion getCancionDB(String id) throws ErrorCreacionObjeto, ErrorConsulta  {
    		try {
			if (this.conectado() && id != null) {
				Cancion cancion = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from cancion where cancion = '" + id + "';");
			    ResultSet datosCancion = stat.executeQuery();
				if(datosCancion.next()) {
					//si ha leido bien lo que queriamos
					String idCancion = datosCancion.getString("cancion");
					String titulo = datosCancion.getString("titulo");
					String autor = datosCancion.getString("autor");
					String album = datosCancion.getString("album");
					double duracion = datosCancion.getDouble("duracion");
					String idLetra = datosCancion.getString("letra");
					String idVideo = datosCancion.getString("video");
					String idGenero = datosCancion.getString("genero");
					
					Letra letra = null;
					if (this.existeLetra(idLetra))
						letra = this.getLetraDB(idLetra);

					Video video = null;
					if (this.existeVideo(idVideo))
						video = this.getVideoDB(idVideo);
					
					Genero genero = null;
					if (this.existeGenero(idGenero))
						genero = this.getGeneroDB(idGenero);
					
					cancion = new Cancion(idCancion, titulo, autor, album, duracion, letra, video, genero);
				}
				return cancion;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
    }
    
    /**
     * Obtiene un video de la base de datos
     * @param idVideo Id del video
     * @return El video creado.
	 * @throws ErrorConsulta Si no se ha padido encontrar.
	 * @throws ErrorCreacionObjeto Si no se puede devolver.
     */
    private Video getVideoDB(String idVideo) throws ErrorConsulta, ErrorCreacionObjeto {
    		try {
			if (this.conectado() && idVideo != null) {
				System.out.println("obteniendo video...");
				Video video = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from video where video = '" + idVideo + "';");
			    ResultSet datosVideo = stat.executeQuery();
				if(datosVideo.next()) {
					//si ha leido bien lo que queriamos
					String id = datosVideo.getString("video");
					String enlace = datosVideo.getString("enlace");
					String enlaceDescarga = datosVideo.getString("enlaceDescarga");
					System.out.println("hay video " + enlace);
					video = new Video(id, enlace, enlaceDescarga);
				}
				return video;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
	}

    /**
     * Consulta la base de datos y crea la letra solicitada.
     * @param idLetra Id de la letra.
     * @return La letra solicitada, null si no existe.
	 * @throws ErrorConsulta Si no se ha padido encontrar.
	 * @throws ErrorCreacionObjeto Si no se puede devolver.
     */
	private Letra getLetraDB(String idLetra) throws ErrorConsulta, ErrorCreacionObjeto {
		try {
			if (this.conectado() && idLetra != null) {
				Letra letra = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from letra where letra = '" + idLetra + "';");
			    ResultSet datosLetra = stat.executeQuery();
				if(datosLetra.next()) {
					//si ha leido bien lo que queriamos
					String id = datosLetra.getString("letra");
					String texto = datosLetra.getString("texto");
					
					letra = new Letra(id, texto);
				}
				return letra;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
	}

	/**
     * Implementación de getListaDB, hace lo descrito en la interfaz.
     */
	@Override
	public Lista getListaDB(String idLista) throws ErrorConsulta, ErrorCreacionObjeto {
		try {
			if (this.conectado() && idLista != null) {
				Lista lista = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from lista where lista = '" + idLista + "';");
			    ResultSet datosLista = stat.executeQuery();
				if(datosLista.next()) {
					//si ha leido bien lo que queriamos obtenemos datos
					//id
					String id = datosLista.getString("lista");
					
					//titulo
					String titulo = datosLista.getString("nombre");

					
					//genero (si existe)
					Genero genero = null;

					if (this.existeListaAuto(id)) {
						//si es una listaauto, cargar el genero
						stat = this.DBconn.prepareStatement("select * from listaAuto where lista = '" + idLista + "';");
					    datosLista = stat.executeQuery();
					    if (datosLista.next()) {
							String idGenero = datosLista.getString("genero");
							if (this.existeGenero(idGenero)) {
								genero = this.getGeneroDB(idGenero);
							}
						}
					}
					
					//procedimiento para obtener lista de canciones
					ArrayList<Cancion> canciones = new ArrayList<Cancion>();
				    PreparedStatement stat2 = this.DBconn.prepareStatement("select * from rlistacancion where lista = '" + idLista + "';");
				    ResultSet datosListaCanciones = stat2.executeQuery();
				    while(datosListaCanciones.next()) {
				    		String idCancion = datosListaCanciones.getString("cancion");
				    		Cancion cancion = this.getCancionDB(idCancion);
				    		canciones.add(cancion);
					}
				    
				    //creacion objeto
					if (genero != null)
						lista = new ListaAuto(id, titulo, genero, canciones);
					else
						lista = new ListaNormal(id, titulo, canciones);
				}
				return lista;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;  
	}

	/**
     * Implementación de getListasDB, hace lo descrito en la interfaz.
     */
	@Override
	public ArrayList<Lista> getListasDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
		try {
			if (this.conectado() && idUsuario != null) {
				if (this.existeUsuario(idUsuario, clave)) {
					ArrayList<Lista> listas = new ArrayList<Lista>();
					PreparedStatement stat = this.DBconn.prepareStatement("select * from listanormal where usuario = '" + idUsuario + "';");
				    ResultSet datosLista = stat.executeQuery();
				    while (datosLista.next()) {
				    		//si ha leido bien lo que queriamos obtenemos datos
				    		System.out.println("obteniendo listas del usuario");
						String id = datosLista.getString("lista");
						listas.add(this.getListaDB(id));
				    }
				    return listas;
				} else {
					throw new ErrorAutenticacion();
				}
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
	}
	
	/**
     * Implementación de getGeneroDB, hace lo descrito en la interfaz.
     */
	@Override
    public Genero getGeneroDB(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
    		try {
			if (this.conectado() && idGenero != null) {
				Genero genero = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from genero where genero = '" + idGenero + "';");
			    ResultSet datosGenero = stat.executeQuery();
				if(datosGenero.next()) {
					//si ha leido bien lo que queriamos
					String id = datosGenero.getString("genero");
					genero = new Genero(id);
				}
				return genero;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
    }

	/**
     * Implementación de getUsuarioDB, hace lo descrito en la interfaz.
     */
    @Override
    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion, ErrorConsulta, ErrorCreacionObjeto {
    	try {
			if (this.conectado() && idUsuario != null) {
				Usuario usuario = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from usuario where usuario = '" + idUsuario + "';"); 
			    ResultSet datosUsuario = stat.executeQuery();
				if(datosUsuario.next()) {
					//si ha leido bien lo que queriamos
					String id = datosUsuario.getString("usuario");
					String nombre = datosUsuario.getString("nombre");
					String claveObtenida = datosUsuario.getString("clave");

					if (!claveObtenida.equals(clave)) throw new ErrorAutenticacion("Pass incorrecta para el usuario: " + nombre);
					//procedimiento para obtener lista de generos
					ArrayList<Genero> generos = new ArrayList<Genero>();
					PreparedStatement stat2 = this.DBconn.prepareStatement("select * from rusuariogenero where usuario = '" + idUsuario + "';");
				    ResultSet datosListaGeneros = stat2.executeQuery();
				    while(datosListaGeneros.next()) {
				    		String idGenero = datosListaGeneros.getString("genero");
				    		Genero genero = this.getGeneroDB(idGenero);
				    		generos.add(genero);
					}
					
					usuario = new Usuario(id, nombre, claveObtenida, generos);
				}
				return usuario;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta(e.getMessage());
		}
		return null;   
	}

    /**
     * Implementación de getCancionesGenero, hace lo descrito en la interfaz.
     */
	@Override
	public ArrayList<Cancion> getCancionesGeneroDB(String id) throws ErrorConsulta, ErrorCreacionObjeto {
		try {
			if (this.conectado() && id != null) {
				ArrayList<Cancion> canciones = new ArrayList<Cancion>();
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from cancion where genero = '" + id + "';");
			    ResultSet datosCancion = stat.executeQuery();
				while(datosCancion.next()) {
					//si ha leido bien lo que queriamos obtenemos datos
					System.out.println("Obteniendo canciones para lista automatica");
					String idCancion = datosCancion.getString("cancion");
					String titulo = datosCancion.getString("titulo");
					String autor = datosCancion.getString("autor");
					String album = datosCancion.getString("album");
					int duracion = datosCancion.getInt("duracion");
					String idLetra = datosCancion.getString("letra");
					String idVideo = datosCancion.getString("video");
					String idGenero = datosCancion.getString("genero");
					
					Letra letra = null;
					if (this.existeLetra(idLetra))
						letra = this.getLetraDB(idLetra);

					Video video = null;
					if (this.existeVideo(idVideo))
						video = this.getVideoDB(idVideo);
					
					Genero genero = null;
					if (this.existeGenero(idGenero))
						genero = this.getGeneroDB(idGenero);
					try {
						Cancion cancion = new Cancion(idCancion, titulo, autor, album, duracion, letra, video, genero);
						canciones.add(cancion);
					} catch (ErrorCreacionObjeto e) {
						System.out.println("error datos cancion dañados");
					}
				}
				System.out.println(canciones.size() +" canciones obtenidas ok");
				return canciones;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta("Error al obtener canciones de DB");
		}
		return null; 
	}
	
    // --------------- SET ---------------
	/**
     * Implementación de setCancionDB, hace lo descrito en la interfaz.
     */
    @Override
    public void setCancion(Cancion cancion) throws ErrorGuardado {
	    	try {
			if (this.conectado() && cancion != null) {
				//recabar datos
				System.out.println("Guardando cancion...");
				String id = cancion.getId();
				String titulo = cancion.getTitulo();
				String autor = cancion.getAutor();
				double duracion = cancion.getDuracion();
				String album = cancion.getAlbum();
				String genero = "g0"; //ids por defecto
				String video = "v0";
				String letra = "l0";
				//las siguientes comprobaciones previenen errores en la DB
				if (cancion.getGenero() != null) {
					genero = cancion.getGenero().getId();
					if (!this.existeGenero(genero)) {
						//si el genero no existe lo anade
						try {
							this.setGenero(cancion.getGenero(), null);
						} catch (ErrorAutenticacion e) {}
					}
				}
				if (cancion.getVideo() != null) {
					video = cancion.getVideo().getId();
					if (!this.existeVideo(video)) {
						//si el video no existe lo anade
						this.setVideo(cancion.getVideo());
					}
				}
				if (cancion.getLetra() != null) {
					letra = cancion.getLetra().getId();
					if (!this.existeLetra(letra)) {
						//si la letra no existe lo anade
						this.setLetra(cancion.getLetra());
					}
				}
				String sentencia = "";
				//comprobar cancion
				if (this.existeCancion(id)) {
					//actualizar DB
					sentencia = DBstruct.updateCancion(id, titulo, autor, duracion, album, genero, video, letra);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				} else {
					//insertar datos
					sentencia = DBstruct.insertCancion(id, titulo, autor, duracion, album, genero, video, letra);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
					//anadir la cancion a la biblioteca
					sentencia = DBstruct.insertRlistaCancion(DBstruct.getIdBiblioteca(), id);
					ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorGuardado();
		}
    }
    
    /**
     * Guarda la latra en la DB.
     * @param letra La letra a guardar.
	 * @throws ErrorGuardado Si no se ha podido guardar.
     */
	private void setLetra(Letra letra) throws ErrorGuardado {
		try {
			if (this.conectado() && letra != null) {
				//recabar datos
				System.out.println("Guardando letra...");
				String id = letra.getId();
				String texto = letra.getTexto();
				if (!this.existeLetra(id)) {
					String sentencia = DBstruct.insertaLetra(id, texto);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				}
			} else {
				throw new ErrorGuardado("Error al guardar letra");
			}
		} catch (SQLException e) {
			throw new ErrorGuardado(e.getMessage());
		}
    }
	
	/**
	 * 
	 * @param video El vídeo a guardar.
	 * @throws ErrorGuardado Si no se ha podido guardar.
	 */
	private void setVideo(Video video) throws ErrorGuardado {
		try {
			if (this.conectado() && video != null) {
				//recabar datos
				System.out.println("Guardando video...");
				String id = video.getId();
				String enlace = video.getEnlace();
				String descarga = video.getEnlaceDescarga();
				if (!this.existeVideo(id)) {
					String sentencia = DBstruct.insertaVideo(id, enlace, descarga);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				}
			} else {
				throw new ErrorGuardado("Error al guardar video");
			}
		} catch (SQLException e) {
			throw new ErrorGuardado(e.getMessage());
		}
	}

	/**
     * Implementación de setUsuario, hace lo descrito en la interfaz.
     */
	@Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
     	try {
			if (this.conectado() && usuario != null) {
				System.out.println("Estableciendo usuario...");
				//recabar datos
				String id = usuario.getId();
				String nombre = usuario.getNombre();
				String clave = usuario.getClave();
				ArrayList<Genero> generos = usuario.getGustos();
				
				String sentencia = "";
				//comprobar usuario
				if (this.existeUsuario(id, clave)) {
					//actualizar DB
					System.out.println("Actualizando usuario..." + id + nombre + clave);
					sentencia = DBstruct.updateUsuario(id, nombre, clave);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				} else {
					//insertar datos
					System.out.println("Guardando nuevo usuario...");
					sentencia = DBstruct.insertUsuario(id, nombre, clave);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				}
				if (generos != null) {
					this.setGenerosUsuario(usuario, generos);
				}
				System.out.println("usuario anadido ok");
				//estais aqui estais aqui no puedo veros pero se que estais aqui
			} else {
				throw new ErrorGuardado();
			}
		} catch (SQLException e) {
			throw new ErrorGuardado(e.getMessage());
		}
    }
	
	/**
     * Implementación de setGenero, hace lo descrito en la interfaz.
     */
	@Override
    public void setGenero(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
     	try {
			if (this.conectado() && genero != null) {
				//recabar datos
				String id = genero.getId();
				if (!this.existeGenero(id)) {
					//si el genero no existe, se guarda
					String sentencia = DBstruct.insertGenero(id);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				} else {
					System.out.println("El genero ya existe");
				}
				if (usuario != null) {
					System.out.println("Asociando genero al usuario");
					//si ademas quieres asociar un usuario al genero
					//recabar datos usuario
					String idUsuario = usuario.getId();
					String clave = usuario.getClave();
					//comprobar usuario
					if (!this.existeUsuario(idUsuario, clave))
						throw new ErrorGuardado("El usuario " + idUsuario + " no existe");
					System.out.println("usuario valido");
					//insertar datos
					String sentencia = "select * from rusuariogenero where usuario = '" + 
										idUsuario + "' and genero = '" + id + "';";
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ResultSet leido = ps.executeQuery();
					if (leido.next())
						throw new ErrorGuardado("Ya sabemos que te gustaba el " + id);
					sentencia = DBstruct.insertRgeneroUsuario(id, idUsuario);
					ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
					System.out.println("genero añadido ok");
				}
			}
		} catch (SQLException e) {
			throw new ErrorGuardado();
		}
    }

	/**
     * Implementación de setLista, hace lo descrito en la interfaz.
     */
    @Override
    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
	    	try {
			if (this.conectado() && lista != null && usuario != null) {
				//recabar datos lista
				String idLista = lista.getId();
				String nombreLista = lista.getNombre();
				//recabar datos usuario
				String idUsuario = usuario.getId();
				String clave = usuario.getClave();
				//comprobar usuario
				if (!this.existeUsuario(idUsuario, clave))
					throw new ErrorAutenticacion();
				String sentencia;
				//comprobar lista
				if (this.existeLista(idLista)) {
					//actualizar DB
					sentencia = DBstruct.updateLista(idLista, nombreLista);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
					//limpiar antigua lista de canciones
					sentencia = DBstruct.deleteRlistaCancion(idLista);
					ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				} else {
					//insertar lista
					System.out.println("insertando nueva lista");
					sentencia = DBstruct.insertLista(idLista, nombreLista);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
					sentencia = DBstruct.insertListaNormal(idLista, idUsuario);
					ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				}
				//insertar canciones en la lista
				if (lista.getCanciones() != null) {
					System.out.println("insertando cancion en la lista");
					for(Cancion cancion : lista.getCanciones()) {
						try {
							sentencia = DBstruct.insertRlistaCancion(idLista, cancion.getId());
							PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
							ps.executeQuery();
						} catch (SQLException e) {
							throw new ErrorGuardado("Error al insertar cancion en la lista.\n"
													+ "La cancion ya estaba añadida!");
						}
						
					}
				}
			} else {
				throw new ErrorGuardado();
			}
		} catch (SQLException e) {
			throw new ErrorGuardado("Fallo en DB");
		}
    }
    
    /**
     * Implementación de setListaAuto, hace lo descrito en la interfaz.
     */
    @Override
	public void setListaAuto(ListaAuto lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
		try {	
			//crear la lista como cualquier otra
			System.out.println("guardando lista auto "+ lista.getGenero() +"...");
	    		this.setLista(lista, usuario);
			//recabar datos
			String idLista = lista.getId();
			String idGenero = lista.getGenero().getId();
			//comprobar genero
			if (this.existeGenero(idGenero)) {
				String sentencia = DBstruct.insertListaAuto(idLista, idGenero);
				PreparedStatement ps;
				ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery(); 
			} else {
				//el genero deberia existir si se ha llamado a esta funcion
				throw new ErrorGuardado();
			}
		} catch (SQLException e) {
			throw new ErrorGuardado();
		}
	}
    
    /**
     * Establece los géneros preferidos de un usuario en la DB.
     * @param usuario Usuario al que asociar géneros.
     * @param generos Géneros del usuario.
     * @throws ErrorAutenticacion Si la clave no coincide con la esperada, o el usuario no existe.
     * @throws ErrorGuardado Si no se ha podido guardar.
     */
    private void setGenerosUsuario(Usuario usuario, ArrayList<Genero> generos) throws ErrorAutenticacion, ErrorGuardado {
	    	try {
			if (this.conectado() && usuario != null && generos != null) {
				//recabar datos usuario
				String idUsuario = usuario.getId();
				String clave = usuario.getClave();
				//comprobar usuario
				if (!this.existeUsuario(idUsuario, clave))
					throw new ErrorAutenticacion();
				//borrar generos del usuario
				String sentencia = "";
				sentencia += DBstruct.deleteRgenerosUsuario(idUsuario);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
				sentencia = "";
				//generos uno a uno
				for (Genero genero : generos ) {
					//recabar datos genero
					String id = genero.getId();
					if (this.existeGenero(id)) {
						//actualizar DB
						sentencia = DBstruct.insertRgeneroUsuario(id, idUsuario);
					}
					sentencia += " \n";
				}
				PreparedStatement ps2 = this.DBconn.prepareStatement(sentencia + ';');
				ps2.executeQuery();
			} else {
				throw new ErrorGuardado();
			}
		} catch (SQLException e) {
			throw new ErrorGuardado();
		}
    }
    
    // --------------- ELIMINAR ---------------
    /**
     * Implementación de eliminarLista, hace lo descrito en la interfaz.
     */
	@Override
	public void eliminarLista(Lista lista) throws ErrorEliminacion {
		try {
			if (this.conectado() && lista != null) {
				//recabar datos lista
				String idLista = lista.getId();
				if (!this.existeLista(idLista))
					throw new ErrorEliminacion();
				//borrar lista
				String sentencia;
				//al borrar la lista deberia hacer cascade
				sentencia = DBstruct.deleteLista(idLista);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

	/**
     * Implementación de eliminarCancion, hace lo descrito en la interfaz.
     */
	@Override
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion {
		try {
			if (this.conectado() && cancion != null) {
				//recabar datos usuario
				String idCancion = cancion.getId();
				if (this.existeCancion(idCancion)) {
					//borrar cancion
					String sentencia;
					//al borrar la cancion deberia hacer cascade
					sentencia = DBstruct.deleteCancion(idCancion);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
					ps.executeQuery();
				} else {
					throw new ErrorEliminacion("La cancion no se encuentra!");
				}
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

	/**
     * Implementación de eliminarGenero, hace lo descrito en la interfaz.
     */
	@Override
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		try {
			if (this.conectado() && genero != null && usuario != null) {
				//recabar datos
				System.out.println("eliminando genero...");
				String idGenero = genero.getId();
				String idUsuario = usuario.getId();
				String clave = usuario.getClave();
				if (!this.existeGenero(idGenero) || !this.existeUsuario(idUsuario, clave))
					throw new ErrorEliminacion("El genero no existe");
				//borrar relacion
				String sentencia;
				System.out.println("eliminando " + genero.getId() + " para " + usuario.getNombre());
				sentencia = DBstruct.deleteRgeneroUsuario(idUsuario, idGenero);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
				ps.executeQuery();
				System.out.println("genero eliminado ok");
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

	/**
     * Implementación de eliminarUsuario, hace lo descrito en la interfaz.
     */
	@Override
	public void eliminarUsuario(Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion  {
		try {
			if (this.conectado() && usuario != null) {
				//recabar datos
				String idUsuario = usuario.getId();
				String clave = usuario.getClave();
				if (!this.existeUsuario(idUsuario, clave))
					throw new ErrorEliminacion();
				//borrar usuario
				String sentencia = "";
				sentencia += DBstruct.deleteUsuario(idUsuario);
				//te vas amigo pero se que volveras!
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}
    
    // --------------- EXISTE ---------------
	/**
	 * Comprueba si existe una canción en la DB.
	 * @param cancionId Id de la canción.
	 * @return true si existe, false si no.
	 */
    private boolean existeCancion(String cancionId) {
    		try {
			return this.getCancionDB(cancionId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    /**
     * Comprueba si existe un usuario en la DB.
     * @param usuarioId Id del usuario.
     * @param clave Clave del usuario.
     * @return true si existe, false si no.
     * @throws ErrorAutenticacion Si la clave no coincide con la esperada.
     */
    private boolean existeUsuario(String usuarioId, String clave) throws ErrorAutenticacion {
		try {
			return this.getUsuarioDB(usuarioId, clave) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    /**
     * Comprueba si existe una lista en la DB.
     * @param listaId  Id de la lista.
     * @return true si existe, false si no.
     */
    private boolean existeLista(String listaId) {
		try {
			return this.getListaDB(listaId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
	/**
	 * Comprueba si existe una lista automática en la DB.
	 * @param id Id de la lista.
	 * @return true si existe, false si no.
	 */
	private boolean existeListaAuto(String id) {
		try {
			if (this.conectado() && id != null) {
				PreparedStatement stat = this.DBconn.prepareStatement("select * from listaauto where lista = '" + id + "';");
			    ResultSet datosLista = stat.executeQuery();
				if(datosLista.next()) {
					return true;
				}
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}

	/**
	 * Comprueba si existe un género en la DB.
	 * @param generoId Id del género.
	 * @return true si existe, false si no.
	 */
    private boolean existeGenero(String generoId) {
		try {
			return this.getGeneroDB(generoId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    /**
     * Comprueba si existe un vídeo en la DB.
     * @param videoId Id del vídeo.
     * @return true si existe, false si no.
     */
    private boolean existeVideo(String videoId) {
		try {
			return this.getVideoDB(videoId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    /**
     * Comprueba si existe una letra en la DB.
     * @param letraId Id de la letra.
     * @return true si existe, false si no.
     */
    private boolean existeLetra(String letraId) {
		try {
			return this.getLetraDB(letraId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
}
