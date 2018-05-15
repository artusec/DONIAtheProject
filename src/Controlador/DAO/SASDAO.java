package Controlador.DAO;

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
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public void initDB() throws ClassNotFoundException, SQLException {
    		//de algun modo deberia crear una mariaDB en localhost que sa llame donia con user = usr pass = usr
    		
    		// Para crear la tabla y usuario en mariaDB:
    	
    		// Arrancar mariaDB server en modo administrador y ejecutar las siguientes sentencias
    		// "CREATE DATABASE donia;"
    		// "CONNECT donia;"
    		// "CREATE USER usr IDENTIFIED BY 'usr';"
    		// ejecutar el script de inicializacion
    	
    		//creacion de tablas
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
     * Inicializa conexion con maria
     * @throws SQLException 
     * @throws ClassNotFoundException 
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
     * @return
     * @throws SQLException 
     */
    private boolean conectado() throws SQLException {
    		return this.DBconn != null && !this.DBconn.isClosed();
    }
    
    // --------------- GET ---------------
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
					
					cancion = new Cancion(idCancion, titulo, autor, album, duracion, letra, video, genero);
				}
				return cancion;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
    }

    private Video getVideoDB(String idVideo) throws ErrorConsulta, ErrorCreacionObjeto {
    		try {
			if (this.conectado() && idVideo != null) {
				Video video = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from video where video = '" + idVideo + "';");
			    ResultSet datosVideo = stat.executeQuery();
				if(datosVideo.next()) {
					//si ha leido bien lo que queriamos
					String id = datosVideo.getString("cancion");
					String enlace = datosVideo.getString("enlace");
					String enlaceDescarga = datosVideo.getString("enlaceDescarga");
					
					video = new Video(id, enlace, enlaceDescarga);
				}
				return video;
			}
		} catch (SQLException e) {
			throw new ErrorConsulta();
		}
		return null;
	}

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
    @Override
    public void setCancion(Cancion cancion) throws ErrorGuardado, ErrorCreacionObjeto {
	    	try {
			if (this.conectado() && cancion != null) {
				//recabar datos
				System.out.println("Guardando cancion...");
				String id = cancion.getId();
				String titulo = cancion.getTitulo();
				String autor = cancion.getAutor();
				int duracion = cancion.getDuracion();
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

	@Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
     	try {
			if (this.conectado() && usuario != null) {
				//recabar datos
				String id = usuario.getId();
				String nombre = usuario.getNombre();
				String clave = usuario.getClave();
				ArrayList<Genero> generos = usuario.getGustos();
				
				String sentencia = "";
				//comprobar usuario
				if (this.existeUsuario(id, clave)) {
					//actualizar DB
					sentencia = DBstruct.updateUsuario(id, nombre, clave);
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
					ps.executeQuery();
				} else {
					//insertar datos
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
				String sentencia = "";
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
					for(Cancion cancion : lista.getCanciones()) {
						sentencia = DBstruct.insertRlistaCancion(idLista, cancion.getId());
						PreparedStatement ps = this.DBconn.prepareStatement(sentencia);
						ps.executeQuery();
					}
				}
			} else {
				throw new ErrorGuardado();
			}
		} catch (SQLException e) {
			throw new ErrorGuardado("Fallo en DB");
		}
    }
    
    @Override
	public void setListaAuto(ListaAuto lista, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
		try {	
			//crear la lista como cualquier otra
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
	@Override
	public void eliminarLista(Lista lista) throws ErrorEliminacion {
		try {
			if (this.conectado() && lista != null) {
				//recabar datos lista
				String idLista = lista.getId();
				if (!this.existeLista(idLista))
					throw new ErrorEliminacion();
				//borrar lista
				String sentencia = "";
				//al borrar la lista deberia hacer cascade
				sentencia += DBstruct.deleteLista(idLista);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

	@Override
	public void eliminarCancion(Cancion cancion) throws ErrorEliminacion {
		try {
			if (this.conectado() && cancion != null) {
				//recabar datos usuario
				String idCancion = cancion.getId();
				//borrar lista
				String sentencia = "";
				//al borrar la lista deberia hacer cascade
				sentencia += DBstruct.deleteCancion(idCancion);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

	@Override
	public void eliminarGenero(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
		try {
			if (this.conectado() && genero != null && usuario != null) {
				//recabar datos
				String idGenero = genero.getId();
				String idUsuario = usuario.getId();
				String clave = usuario.getClave();
				if (!this.existeGenero(idGenero) || !this.existeUsuario(idUsuario, clave))
					throw new ErrorEliminacion();
				//borrar relacion
				String sentencia = "";
				sentencia += DBstruct.deleteRgeneroUsuario(idUsuario, idGenero);
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			throw new ErrorEliminacion();
		}
	}

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
    private boolean existeCancion(String cancionId) {
    		try {
			return this.getCancionDB(cancionId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    private boolean existeUsuario(String usuarioId, String clave) throws ErrorAutenticacion {
		try {
			return this.getUsuarioDB(usuarioId, clave) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    private boolean existeLista(String listaId) {
		try {
			return this.getListaDB(listaId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }

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

    private boolean existeGenero(String generoId) {
		try {
			return this.getGeneroDB(generoId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    private boolean existeVideo(String videoId) {
		try {
			return this.getVideoDB(videoId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
    
    private boolean existeLetra(String letraId) {
		try {
			return this.getLetraDB(letraId) != null;
		} catch (ErrorCreacionObjeto | ErrorConsulta e) {
			return false;
		}
    }
}
