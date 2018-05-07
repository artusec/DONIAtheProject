package Controlador;

import Model.Objetos.Usuario;

public class Controlador {
	//usuario que esta funcionando
	private Usuario usuarioActual;
	
	public Controlador() {
		usuarioActual = null;
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
}
