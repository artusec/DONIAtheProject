


public class FachadaGenero implements InterfazFachadaGenero {
	
    public InterfazSASGenero interfazSASGenero;

    public void Aniadir(String gusto) {
    	interfazSASGenero.Aniadir(gusto);
    }

    public void Eliminar(String gusto) {
    	interfazSASGenero.Eliminar(gusto);
    }

    public void Mostrar() {
    	interfazSASGenero.Mostrar();
    }

}
