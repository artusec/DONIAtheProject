package Model.Genero;

import Excepciones.ErrorConsulta;
import Model.Objetos.Genero;

public interface InterfazSASGenero {
    void Anadir(Genero genero);
    void Eliminar(Genero genero);
    Genero Consultar(String idGenero) throws ErrorConsulta;
}
