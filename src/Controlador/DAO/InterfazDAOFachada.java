package Controlador.DAO;
import Cancion;
import Genero;
import Lista;
import ListaNomal;
import Usuario;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0f5326ad-4d2e-4464-bf19-adbb01bc20d0")
public interface InterfazDAOFachada {
    @objid ("e9b5e11e-352a-4f72-8bb9-d53d791b0db6")
    Genero getGeneroDB(String idGenero);

    @objid ("5024c3e7-72b5-4155-ab9c-7645edbe3989")
    Cancion getCancionDB(String idCancion);

    @objid ("646355ac-5d9c-48eb-a5aa-dcf130a65bb8")
    ListaNomal getListaDB(String idLista);

    @objid ("d49f9893-c853-4fce-bbdc-8dbca6a4f63a")
    Usuario getUsuarioDB(String idUsuario, String clave);

    @objid ("26eb7a50-53b5-4ca7-b1ca-f240f93c8551")
    void setCancion(Cancion cancion);

    @objid ("2d6d698c-5311-4fe5-ad94-431547abca84")
    void setGenero(Genero genero);

    @objid ("307494d8-1f80-4a58-b1e3-7d5314af140a")
    void setUsuario(Usuario usuario);

    @objid ("765195ed-84fe-4f46-a09b-8ea5e2595cbe")
    void setLista(Lista lista);

}
