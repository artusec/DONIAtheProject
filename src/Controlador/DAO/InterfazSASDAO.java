package Controlador.DAO;
import Cancion;
import Genero;
import Lista;
import ListaNomal;
import Usuario;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ab54e46a-f3cf-4b1d-9a82-6af8cbf34232")
public interface InterfazSASDAO {
    @objid ("6436563a-2b54-4183-aa4f-b5703209929c")
    Cancion getCancionDB(String idCancion);

    @objid ("77ee3003-315e-4014-bd9b-07f503e82ec3")
    ListaNomal getListaDB(String idLista);

    @objid ("20abf66b-3666-4ccb-959d-1c70d5174606")
    Genero getGeneroDB(String idGenero);

    @objid ("b007535c-9740-4a31-9939-9ac9bfead8f9")
    Usuario getUsuarioDB(String idUsuario, String clave);

    @objid ("14223afc-9f1f-4d35-951a-474421a7e36a")
    void setGenero(Genero genero);

    @objid ("fe6a5b00-2424-4dc1-ba47-d69dfd7d017d")
    void setLista(Lista lista);

    @objid ("d9548afa-18bc-4a4b-ab9a-c709477f9af5")
    void setCancion(Cancion cancion);

    @objid ("179130e3-1dab-4407-ae79-7264d61677b8")
    void setUsuario(Usuario usuario);

}
