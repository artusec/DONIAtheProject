
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import Controlador.ControlCancion;
import Controlador.ControlLista;
import Controlador.ControlUsuario;
import Model.Objetos.Cancion;
import Model.Objetos.Genero;
import Model.Objetos.Lista;
import Model.Objetos.Usuario;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static Border bordePorDefecto = BorderFactory.createLineBorder(Color.black, 2);

	// PANELES
	private static PanelListas panelListas;
	private static PanelCanciones panelCanciones;
	private ToolBar toolBar;
	private JPanel panelCambiante;
	private JPanel panelCentral;
	private PanelUnTercio panelUnTercio;
	
	// PANELES CAMBIANTES (pueden necesitar actualizacion de datos)
	private static PanelDePaneles<Genero> panelFavoritos;
	
	// USUARIO
	private static Usuario usuarioActual;

	private Login Login;;

	/**
	 * Constructura de la Vista Principal.
	 */
	public VentanaPrincipal () {	
		
		super("Donia");
		initGUI();
		try {
			Login = new Login(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Login.setVisible(true);
	}
	
	/**
	 * Inicializa la Vista, creando y colocando los respectivos paneles y barras de herramientas.
	 */
	private void initGUI() {
		
		this.setIconImage(new ImageIcon("src/icons/LOGO_DONIA.png").getImage()); 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent e) {}

			@Override
			public void windowClosing(WindowEvent e) {
				int a = JOptionPane.showOptionDialog(new JFrame(), "¿Seguro que quiere salir?", "SALIR",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (a == 0)
					System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {}

			@Override
			public void windowDeiconified(WindowEvent e) {}

			@Override
			public void windowIconified(WindowEvent e) {}

			@Override
			public void windowOpened(WindowEvent e) {}
		
		 });
		
		
		JPanel panelSupremo = creaPanelSupremo();
		setContentPane(panelSupremo);
		
		addToolBar(panelSupremo);
		
		panelCentral = createPanelCentral();
		panelSupremo.add(panelCentral, BorderLayout.CENTER);

		creaPanelListas(panelCentral);
		creaPanelCanciones(panelCentral);
		createPanelCambiante();
		pack();
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	/**
	 * Crea el panelSupremo.
	 * @return Devuelve el panelSupremo.
	 */
	private JPanel creaPanelSupremo() {
		JPanel principal = new JPanel();
		principal.setLayout(new BorderLayout());
		return principal;
	}

	/**
	 * Añade el toolbar al panelSupremo.
	 * @param panelSupremo Panel al que se le añade la toolbar.
	 */
	private void addToolBar(JPanel panelSupremo) {
		toolBar = new ToolBar(this);
		toolBar.setFloatable(false);
		toolBar.setLayout(new GridLayout(6, 1));
		panelSupremo.add(toolBar, BorderLayout.EAST);
		
	}
	/**
	 * Crea el panelCentral.
	 * @return devuelve el panelCentral.
	 */
	private JPanel createPanelCentral() {
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,3));
		return panelCentral;
	}
	/**
	 * Crea el panelListas y lo añade al panelCentral.
	 * @param panelCentral Panel al que se le añade el panelListas.
	 */
	private void creaPanelListas(JPanel panelCentral) {
		JPanel izquierda = new JPanel();
		izquierda.setLayout(new BorderLayout());
		ToolBarListas barListas = new ToolBarListas(this);
		barListas.setFloatable(false);
		setFont(new Font("MyStyle", 1, 20));
		panelListas = new PanelListas("Listas de reproduccion", this);
		panelListas.setAutoscrolls(true);
		izquierda.add(panelListas);
		izquierda.add(barListas, BorderLayout.SOUTH);
		panelCentral.add(izquierda);	
	}
	
	/**
	 * Crea el panelCanciones y lo añade al panelCentral.
	 * @param panelCentral Panel al que se le añade el panelCanciones.
	 */
	
	private void creaPanelCanciones(JPanel panelCentral) {
		
		panelCanciones = new PanelCanciones(this);
		ToolBarCanciones barCanciones = new ToolBarCanciones(this);
		panelCentral.add(new PanelMedio(barCanciones, panelCanciones));
	}
	
	
	/**
	 * Crea el panel que cambia.
	 */
	private void createPanelCambiante() {
		
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Reinicia el panel que cambia.
	 */
	private void resetearPanelCambiante() {
		
		panelCambiante.removeAll();
		panelCambiante.setVisible(false);
		panelCentral.remove(panelCambiante);
	}
	
	/**
	 * Muestra el panel del perfil del usuario.
	 */
	public void verPerfil() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		Account_panel account = null;
		try {
			account = new Account_panel(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		account.setDatosUsuario(usuarioActual);
		account.setVisible(true);
		account.setOpaque(false);
		panelCambiante.add(account);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * 	Muestra el panel que permite ver los generos favoritos del usuario actual.
	*/
	public void verFavoritos() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
	 	panelFavoritos = new PanelDePaneles<Genero>("Géneros favoritos");
	 	VentanaPrincipal.actualizaGeneros();
		PanelGeneros pg = new PanelGeneros(panelFavoritos, this);
		panelCambiante.add(pg);
		panelCentral.add(panelCambiante);
		VentanaPrincipal.actualizaGeneros();
	}
	
	/**
	 * Muestra el panel que permite añadir una cancion a la base de datos.
	 */
	public void verAniadirCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		SongAdmin_panel songAdmin = new SongAdmin_panel(this);
		songAdmin.setVisible(true);
		songAdmin.setOpaque(false);
		panelCambiante.add(songAdmin);
		panelCentral.add(panelCambiante);
	}
	
	
	/**
	 * Muestra el panel que permite eliminar una cancion de la base de datos.
	 */
	public void verEliminarCancion() {
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		SongBorrarAdmin_panel songAdmin = new SongBorrarAdmin_panel(this);
		songAdmin.setVisible(true);
		songAdmin.setOpaque(false);
		panelCambiante.add(songAdmin);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Muestra el panel que muestra la letra de una canción.
	 */
	public void verPanelLetras() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		DatosCancion_panel panelDatos = new DatosCancion_panel(this);
		PanelAreaTexto panelDeLetras = new PanelAreaTexto("Letra", false);
		panelUnTercio = new PanelUnTercio(panelDeLetras, panelDatos);
		Cancion aux = panelCanciones.getSelectedItem();
		if(aux != null) {
			
			setCancion(aux);
		}
		panelUnTercio.setVisible(true);
		panelCambiante.add(panelUnTercio);
		panelCentral.add(panelCambiante);
	}

	/**
	 * Muestra el panel que muestra los datos de una canción.
	 */
	public void verPanelCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		DatosCancion_panel panelDatos = new DatosCancion_panel(this);
		Enlaces_panel panelDeEnlaces = new Enlaces_panel(this);
		panelUnTercio = new PanelUnTercio(panelDeEnlaces, panelDatos);
		Cancion aux = panelCanciones.getSelectedItem();
		if(aux != null) {
			
			setCancion(aux);
		}
		panelUnTercio.setVisible(true);
		panelCambiante.add(panelUnTercio);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Muestra el panel que permite modificar los datos de una canción.
	 */
	public void verModificarCancion() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		ModificarCancion_panel modificar = new ModificarCancion_panel(this);
		modificar.setVisible(true);
		modificar.setOpaque(false);
		panelCambiante.add(modificar);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Muestra el panel que permite añadir una cancion a una lista.
	 */
	public void verAniadirCancionALista() {	
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		AniadirCancionALista cancion = new AniadirCancionALista(this);
		cancion.setVisible(true);
		cancion.setOpaque(false);
		panelCambiante.add(cancion);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Muestra el panel de creacion de una lista.
	 */
	public void verCrearLista() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		CrearLista crear = new CrearLista(this);
		crear.setVisible(true);
		crear.setOpaque(false);
		panelCambiante.add(crear);
		panelCentral.add(panelCambiante);
	}
	
	
	/**
	 * Muestra el panel que permite modificar el nombre de una lista.
	 */
	public void verModificarLista() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		ModificarLista modificar = new ModificarLista(this);
		modificar.setVisible(true);
		modificar.setOpaque(false);
		panelCambiante.add(modificar);
		panelCentral.add(panelCambiante);
	}
	
	/**
	 * Muestra el panel que permite crear listas automáticas.
	 */
	public void verCrearListaAuto() {
		
		resetearPanelCambiante();
		panelCambiante = new JPanel();
		panelCambiante.setLayout(new BorderLayout());
		this.panelCambiante.setOpaque(false);
		CrearListaAuto crear = new CrearListaAuto(this);
		crear.setVisible(true);
		crear.setOpaque(false);
		panelCambiante.add(crear);
		panelCentral.add(panelCambiante);		
	}
	/**
	 * Muestra un mensaje de error en una ventana emergente.
	 * @param e Excepción que se produce.
	 */
	public static void muestraError(Exception e) {
		JOptionPane.showOptionDialog(new JFrame(), e.getMessage(), "ERROR", JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.ERROR_MESSAGE, null, null, null);
	}
	
	// --- ACTUALIZACION DE VISTA ----
	
	/**
	 * Se actualizan las canciones que se encuentran dentro de una lista.
	 * @param idLista Lista en la que se actualizan las canciones.
	 */
	public static void actualizaCanciones(String idLista) {
		ControlLista control = new ControlLista(usuarioActual);
		panelCanciones.setList(control.consulta(idLista).getCanciones());
	}
	
	/**
	 * Actualiza los generos de el usuario actual.
	 */
	public static void actualizaGeneros() {
		
		ControlUsuario control = new ControlUsuario(usuarioActual);
		ArrayList<Genero> generos = control.ingreso(usuarioActual.getId(), usuarioActual.getClave()).getGustos();
		if (generos != null)
			panelFavoritos.setList(generos);
	}
	
	/**
	 * Actualiza las listas que tiene el usuario actual.
	 */
	public static void actualizaListas() {
		
		ControlLista control = new ControlLista(usuarioActual);
		panelListas.setList(control.getListasUsuario());
	}

	/**
	 * Establece la canción de la cual se muestra la información (letra, enlaces etc...).
	 * @param cancion Canción de la que se muestra la información.
	 */
	public void setCancion(Cancion cancion) {
		
		panelUnTercio.setDatos(cancion, this);
	}
	
	/**
	 * Establece la lista de la cual se muestra la información.
	 * @param lista Lista de al qeu se muestra la información.
	 */
	public void setLista(Lista lista) {
		if (lista != null)
			VentanaPrincipal.actualizaCanciones(lista.getId());
	}
	
	/**
	 * Establece el usuario actual.
	 * @param accesor Usuario que se establece.
	 */
	public void setUsuarioActual(Usuario accesor) {
		
		VentanaPrincipal.usuarioActual = accesor;
	}
	
	/**
	 * Devuelve el panel cambiante.
	 * @return se devuelve el panel cambiante.
	 */
	public JPanel getPanelCambiante() {
		
		return panelCambiante;
	}

	/**
	 * Establece el panel cambiante.
	 * @param panelCambiante Panel que se establece.
	 */
	public void setPanelCambiante(JPanel panelCambiante) {
		
		this.panelCambiante = panelCambiante;
	}
	
	/**
	 * Devuelve el panel cambiante.
	 * @return Devuelve el panel central.
	 */
	public JPanel getPanelCentral() {
		
		
		return panelCentral;
	}
	/**
	 * Establece el panel central.
	 * @param panelCentral Panel que se establece.
	 */
	public void setPanelCentral(JPanel panelCentral) {
		
		this.panelCentral = panelCentral;
	}

	/**
	 * Devuelve el usuario que esta logueado actualmente en la sesión.
	 * @return usuario actual.
	 */
	public Usuario getUsuarioActual() {
		
		return VentanaPrincipal.usuarioActual;
	}
	
	/**
	 * Genera un id de forma aleatoria y presuntamente única para
	 * los objetos nuevos.
	 * @return id
	 */
	public String generaId() {
		
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	/**
	 * Calcula si una entrada del usuario es válida o no.
	 * @param entrada texto a validar.
	 * @return si es válido.
	 */
	public static boolean entradaValida(String entrada) {
		return entrada != null && entrada.matches("[a-zA-Z0-9ñÑ& ]*") && !entrada.equals("");
	}
	
	/**
	 * Devuelve una lista de canciones con las seleccionadas en el panel.
	 * @return Lista con las canciones seleccionadas.
	 */
	public ArrayList<Cancion> getCancionSelecccionada() {
		
		return VentanaPrincipal.panelCanciones.getSelectedItems();
	}

	/**
	 * Devuelve una lista de listas de reproducción con las seleccionadas en el panel.
	 * @return Lista con las listas de reproducción seleccionadas.
	 */
	public ArrayList<Lista> getListaSelecccionada() {
		return VentanaPrincipal.panelListas.getSelectedItems();
	}
	
	/**
	 * Devuelve una lista de Géneros con los seleccionados en el panel.
	 * @return Lista con los géneros seleccionados.
	 */
	public ArrayList<Genero> getGeneroSeleccionado(){
		return VentanaPrincipal.panelFavoritos.getSelectedItems();
	}
	
	/**
	 * Elimina las canciones seleccionadas en el panel de canciones de la lista contenedora.
	 */
	public void eliminarCancion() {
		
		ArrayList<Cancion> cancionesBorrar = this.getCancionSelecccionada();
		for (Cancion c : cancionesBorrar) {
			ControlCancion control = new ControlCancion(this.getUsuarioActual());
			control.eliminaCancion(c);
		}
	}
	
	/**
	 * Desactiva los botones de la toolbar que solo puede usar el administrador.
	 * @param cual Booleano que indica si los botones deben estar activos o inactivos.
	 */

	public void configurarBotones(boolean cual) {

		toolBar.configurarBotones(cual);
	}

	/**
	 * LLama a la función borrarSeleccionado() de panelCanciones.
	 */
	public void deshacerSelecciones() {
		
		panelCanciones.borrarSeleccionado();
	}
	
	/**
	 * Vacia panelCanciones.
	 */
	public void vaciaPanelCanciones() {
		
		panelCanciones.listModel.clear();
	}
}