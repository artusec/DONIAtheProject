package Controlador;

import Model.Genero.InterfazSASGenero;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;
import Vista.VentanaPrincipal;

//TODO: revisar mucho el fuckin sas loko

public class ControlGenero {

	InterfazSASGenero fGenero;
	VentanaPrincipal ventanaPrincipal;
	Usuario usuarioActual;

	public ControlGenero() {
		
	}
	
	public void Anadir(Genero genero) {
		fGenero.Anadir(genero, usuarioActual);
	}
	
	public void Eliminar(Genero genero) {
		fGenero.Eliminar(genero, usuarioActual);
	}

	public Genero Consultar(String idGenero) {
		return fGenero.Consultar(idGenero);
	}
}
