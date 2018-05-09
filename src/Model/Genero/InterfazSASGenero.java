package Model.Genero;

import Excepciones.ErrorConsulta;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public interface InterfazSASGenero {
    void Anadir(Genero genero, Usuario usuario);
    void Eliminar(Genero genero, Usuario usuario);
    Genero Consultar(String idGenero) throws ErrorConsulta;
}
