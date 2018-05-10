package Model.Genero;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public class FachadaGenero implements InterfazFachadaGenero {
	
    public InterfazSASGenero sasGenero;
    
    public FachadaGenero() {
    		sasGenero = new SASGenero();
    }
    
    @Override
    public void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado {
    		sasGenero.Anadir(genero, usuario);
    }
    @Override
    public void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion {
    		sasGenero.Eliminar(genero, usuario);
    }
    @Override
    public Genero Consultar(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto {
    		return sasGenero.Consultar(idGenero);
    }
}
