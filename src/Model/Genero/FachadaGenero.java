package Model.Genero;

import Model.Objetos.Genero;

public class FachadaGenero implements InterfazFachadaGenero {
	
    public InterfazSASGenero interfazSASGenero;
    @Override
    public void Anadir(Genero genero) {
    		interfazSASGenero.Anadir(genero);
    }
    @Override
    public void Eliminar(Genero genero) {
    		interfazSASGenero.Eliminar(genero);
    }
    @Override
    public void Consultar(Genero genero) {
    		interfazSASGenero.Consultar(genero);
    }
}
