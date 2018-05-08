package Controlador;

import java.util.ArrayList;
import java.util.List;
import Model.Objetos.Usuario;
import Vista.ObservadorAplicacion;

public class Controlador {
	
	private Usuario usuarioActual;
	private List <ObservadorAplicacion> observers;
	
	public Controlador() {
		usuarioActual = null;
		observers = new ArrayList<>();
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void addObservador(ObservadorAplicacion o) {
		observers.add(o);
	}
}