import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0e950cbb-4d53-4ee6-bf2a-506d300488ea")
public interface InterfazFachadaCancion {
    @objid ("66a609e6-7c67-4694-b28e-ec95322502ff")
    void consultaCancion(String cancion);

    @objid ("5436ab09-0e44-4f3e-a863-3a3ea66e3e09")
    void consultaLetra(String cancion);

    @objid ("b8af3784-7974-41a1-818b-9f502ee0f7b7")
    void consultaVideo(String cancion);

    @objid ("99790e86-7059-4356-9902-154e13a640b2")
    void descargaVideo(String cancion);

    @objid ("9a37a108-97e4-42a6-b82a-944923b08f02")
    void creaCancion(String titulo, String artista, String album, String duracion, String genero, String letra, String video, String descarga);

    @objid ("36fc6cfa-8218-484c-8701-8d07dae0c768")
    void eliminaCancion(String id);

}
