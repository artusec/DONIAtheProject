package Model.Genero;

import Excepciones.ErrorConsulta;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public class FachadaGenero implements InterfazFachadaGenero {
	
    public InterfazSASGenero interfazSASGenero;
    @Override
    public void Anadir(Genero genero, Usuario usuario) {
    		interfazSASGenero.Anadir(genero, usuario);
    }
    @Override
    public void Eliminar(Genero genero, Usuario usuario) {
    		interfazSASGenero.Eliminar(genero, usuario);
    }
    @Override
    public Genero Consultar(String idGenero) throws ErrorConsulta {
    		return interfazSASGenero.Consultar(idGenero);
    }
}
