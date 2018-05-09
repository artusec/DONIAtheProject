package Model.Genero;

import Excepciones.ErrorAutenticacion;
import Excepciones.ErrorConsulta;
import Excepciones.ErrorCreacionObjeto;
import Excepciones.ErrorEliminacion;
import Excepciones.ErrorGuardado;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public interface InterfazFachadaGenero {
    void Anadir(Genero genero, Usuario usuario) throws ErrorAutenticacion, ErrorGuardado;
    void Eliminar(Genero genero, Usuario usuario) throws ErrorEliminacion, ErrorAutenticacion;
    Genero Consultar(String idGenero) throws ErrorConsulta, ErrorCreacionObjeto;
}
