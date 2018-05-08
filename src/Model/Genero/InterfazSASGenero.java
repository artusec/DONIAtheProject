package Model.Genero;

import Excepciones.ErrorConsulta;
import Model.Objetos.Genero;
import Model.Objetos.Usuario;

public interface InterfazSASGenero {
    public void Anadir(Genero genero, Usuario usuario);
    public void Eliminar(Genero genero, Usuario usuario);
    public Genero Consultar(String idGenero) throws ErrorConsulta;
}
