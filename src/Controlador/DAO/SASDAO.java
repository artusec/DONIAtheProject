package Controlador.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorContrasteDatos;
import Excepciones.ErrorCreacionObjeto;
import Modelo.Objetos.*;

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
				this.initDB();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }
    
    /**
     * Inicializa la estructura de la base de datos. Para la primera ejecucion.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    private void initDB() throws ClassNotFoundException, SQLException {
    		//de algun modo deberia crear una mariaDB en localhost que sa llame donia con user = usr pass = usr
    		
    		//creacion de tablas
    		this.conectaDB();
    		if (this.conectado()) {
    			String sentencia = DBstruct.getUsuario() + DBstruct.getUsuarioadmin() +
    					DBstruct.getGenero() + DBstruct.getRusuariogenero() +
    					DBstruct.getLista() + DBstruct.getBiblioteca() +
    					DBstruct.getListanormal() + DBstruct.getListaauto() +
    					DBstruct.getLetra() + DBstruct.getVideo() +
    					DBstruct.getCancion() + DBstruct.getRlistacancion();
		    PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ";");
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
        System.out.println("Conectao!");
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
    
    @Override
    public Cancion getCancionDB(String idCancion) {
    		try {
			if (this.conectado() && idCancion != null) {
				Cancion cancion = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from cancion where cancion = " + idCancion + ";");
			    ResultSet datosCancion = stat.executeQuery();
				if(datosCancion.next()) {
					//si ha leido bien lo que queriamos
					String id = datosCancion.getString("cancion");
					String titulo = datosCancion.getString("titulo");
					String autor = datosCancion.getString("autor");
					String album = datosCancion.getString("album");
					int duracion = datosCancion.getInt("duracion");
					String idLetra = datosCancion.getString("letra");
					String idVideo = datosCancion.getString("video");
					String idGenero = datosCancion.getString("genero");
					
					Letra letra = null;
					if (idLetra != null)
					letra = this.getLetraDB(idLetra);
					
					Video video = null;
					if (idVideo != null)
					video = this.getVideoDB(idVideo);
					
					Genero genero = null;
					if (idGenero != null)
					genero = this.getGeneroDB(idGenero);
					
					cancion = new Cancion(id, titulo, autor, album, duracion, letra, video, genero);
				}
				return cancion;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			e.printStackTrace();
		}
		return null;
    }

    private Video getVideoDB(String idVideo) {
    		try {
			if (this.conectado() && idVideo != null) {
				Video video = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from video where video = " + idVideo + ";");
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
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			
		}
		return null;
	}

	private Letra getLetraDB(String idLetra) {
		try {
			if (this.conectado() && idLetra != null) {
				Letra letra = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from letra where letra = " + idLetra + ";");
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
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			
		}
		return null;
	}

	@Override
	public Lista getListaDB(String idLista) {
		try {
			if (this.conectado() && idLista != null) {
				Lista lista = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from lista where lista = " + idLista + ";");
			    ResultSet datosLista = stat.executeQuery();
				if(datosLista.next()) {
					//si ha leido bien lo que queriamos obtenemos datos
					String id = datosLista.getString("lista");
					String titulo = datosLista.getString("nombre");
					//procedimiento para obtener lista de canciones
					ArrayList<Cancion> canciones = new ArrayList<Cancion>();
				    PreparedStatement stat2 = this.DBconn.prepareStatement("select * from rlistacancion where lista = " + idLista + ";");
				    ResultSet datosListaCanciones = stat2.executeQuery();
				    while(datosListaCanciones.next()) {
				    		String idCancion = datosListaCanciones.getString("cancion");
				    		Cancion cancion = this.getCancionDB(idCancion);
				    		canciones.add(cancion);
					}
					
					lista = new ListaNormal(id, titulo, canciones);
				}
				return lista;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			e.printStackTrace();
		}
		return null;  
	}

	public Lista getListaAutoDB(String idLista) {
		try {
			if (this.conectado() && idLista != null) {
				Lista lista = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from listaauto where lista = " + idLista + ";");
			    ResultSet datosLista = stat.executeQuery();
				if(datosLista.next()) {
					//si ha leido bien lo que queriamos obtenemos datos
					String id = datosLista.getString("lista");
					String titulo = datosLista.getString("nombre");
					String idGenero = datosLista.getString("genero");
					Genero genero = this.getGeneroDB(idGenero);
					//procedimiento para obtener lista de canciones
					ArrayList<Cancion> canciones = new ArrayList<Cancion>();
				    PreparedStatement stat2 = this.DBconn.prepareStatement("select * from rlistacancion where lista = " + idLista + ";");
				    ResultSet datosListaCanciones = stat2.executeQuery();
				    while(datosListaCanciones.next()) {
				    		String idCancion = datosListaCanciones.getString("cancion");
				    		Cancion cancion = this.getCancionDB(idCancion);
				    		canciones.add(cancion);
					}
					
					lista = new ListaAuto(id, titulo, genero, canciones);
				}
				return lista;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			e.printStackTrace();
		}
		return null;  
	}
	
	@Override
    public Genero getGeneroDB(String idGenero) {
    		try {
			if (this.conectado() && idGenero != null) {
				Genero genero = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from genero where genero = " + idGenero + ";");
			    ResultSet datosGenero = stat.executeQuery();
				if(datosGenero.next()) {
					//si ha leido bien lo que queriamos
					String id = datosGenero.getString("genero");
					String nombre = datosGenero.getString("nombre");
					
					genero = new Genero(id, nombre);
				}
				return genero;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public Usuario getUsuarioDB(String idUsuario, String clave) throws ErrorAutenticacion {
    	try {
			if (this.conectado() && idUsuario != null) {
				Usuario usuario = null;
			    PreparedStatement stat = this.DBconn.prepareStatement("select * from usuario where usuario = " + idUsuario + ";");
			    ResultSet datosUsuario = stat.executeQuery();
				if(datosUsuario.next()) {
					//si ha leido bien lo que queriamos
					String id = datosUsuario.getString("usuario");
					String nombre = datosUsuario.getString("nombre");
					String claveObtenida = datosUsuario.getString("clave");
					if (claveObtenida != clave) throw new ErrorAutenticacion("Contraseña incorrecta para el usuario: " + nombre);
					//procedimiento para obtener lista de generos
					ArrayList<Genero> generos = new ArrayList<Genero>();
					PreparedStatement stat2 = this.DBconn.prepareStatement("select * from rusuariogenero where usuario = " + idUsuario + ";");
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
			e.printStackTrace();
		} catch (ErrorCreacionObjeto e) {
			e.printStackTrace();
		}
		return null;   
	}

    @Override
    public void setCancion(Cancion cancion) {
	    	try {
				if (this.conectado() && cancion != null) {
					//recabar datos
					String id = cancion.getId();
					String titulo = cancion.getTitulo();
					String autor = cancion.getAutor();
					int duracion = cancion.getDuracion();
					String album = cancion.getAlbum();
					//las siguientes comprobaciones previenen errores en la DB
					String genero = cancion.getGenero().getId();
					if (!this.existeGenero(genero)) genero = null;
					String video = cancion.getVideo().getId();
					if (!this.existeVideo(video)) genero = null;
					String letra = cancion.getLetra().getId();
					if (!this.existeLetra(letra)) letra = null;
					
					String sentencia = "";
					//comprobar cancion
					if (this.existeCancion(id)) {
						//actualizar DB
						sentencia = DBstruct.updateCancion(id, titulo, autor, duracion, album, genero, video, letra);
					} else {
						//insertar datos
						sentencia = DBstruct.insertCancion(id, titulo, autor, duracion, album, genero, video, letra);
						//anadir la cancion a la biblioteca
						sentencia += '\n' + DBstruct.insertRlistaCancion(DBstruct.getIdBiblioteca(), id);
					}
					PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
					ps.executeQuery();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    }

    @Override
    public void setUsuario(Usuario usuario) throws ErrorAutenticacion {
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
				} else {
					//insertar datos
					sentencia = DBstruct.insertUsuario(id, nombre, clave);
				}
				if (generos != null) {
					this.setGenerosUsuario(usuario, generos);
				}
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void setGenero(Genero genero) {
     	try {
			if (this.conectado() && genero != null) {
				//recabar datos
				String id = genero.getId();
				String nombre = genero.getNombre();
				
				String sentencia = "";
				//comprobar genero
				if (this.existeGenero(id)) {
					//actualizar DB
					sentencia = DBstruct.updateGenero(id, nombre);
				} else {
					//insertar datos
					sentencia = DBstruct.insertGenero(id, nombre);
				}
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void setLista(Lista lista, Usuario usuario) throws ErrorAutenticacion {
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
					//limpiar antigua lista de canciones
					sentencia += DBstruct.deleteRlistaCancion(idLista);
				} else {
					//insertar lista
					sentencia = DBstruct.insertLista(idLista, nombreLista);
				}
				//insertar canciones en la lista
				if (lista.getCanciones() != null) {
					for(Cancion cancion : lista.getCanciones()) {
						sentencia += DBstruct.insertRlistaCancion(idLista, cancion.getId()) + '\n';
					}
				}
				PreparedStatement ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @Override
	public void setListaAuto(Lista lista, Genero genero, Usuario usuario) throws ErrorAutenticacion {
		this.setLista(lista, usuario);
		//recabar datos
		String idLista = lista.getId();
		String idGenero = genero.getId();
		//comprobar genero
		if (this.existeGenero(idGenero)) {
			String sentencia = DBstruct.updateGeneroLista(idLista, idGenero);
			PreparedStatement ps;
			try {
				ps = this.DBconn.prepareStatement(sentencia + ';');
				ps.executeQuery(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
    
    private void setGenerosUsuario(Usuario usuario, ArrayList<Genero> generos) throws ErrorAutenticacion {
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
				sentencia += DBstruct.deleteRgeneroUsuario(idUsuario);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private boolean existeCancion(String cancionId) {
    		return this.getCancionDB(cancionId) != null;
    }
    
    private boolean existeUsuario(String usuarioId, String clave) throws ErrorAutenticacion {
		return this.getUsuarioDB(usuarioId, clave) != null;
    }
    
    private boolean existeLista(String listaId) {
		return this.getListaDB(listaId) != null;
    }
    
    private boolean existeGenero(String generoId) {
		return this.getGeneroDB(generoId) != null;
    }
    
    private boolean existeVideo(String videoId) {
		return this.getVideoDB(videoId) != null;
    }
    
    private boolean existeLetra(String letraId) {
		return this.getLetraDB(letraId) != null;
    }
}
