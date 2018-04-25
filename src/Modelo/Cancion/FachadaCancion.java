package Modelo.Cancion;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("5b8625b1-c138-4296-b8b2-efc923e8a1c0")
public class FachadaCancion implements InterfazFachadaCancion {
    @objid ("09ed8f63-3983-4b0b-b554-bec7deadd5c0")
    public InterfazSASCancion interfazSASCancion;

    @objid ("3e3f7a8f-e518-4868-b7e0-11710f1a3724")
    public void consultaVideo(String cancion) {
    }

    @objid ("454ddb4b-1b68-4815-8bad-d4244a4ecc12")
    public void consultaLetra(String cancion) {
    }

    @objid ("a816df54-dfe9-45ed-8dc9-f0ed9193652b")
    public void consultaCancion(String cancion) {
    }

    @objid ("1fb9927f-1948-43ca-b667-cf1bfa0141ef")
    public void descargaVideo(String cancion) {
    }

    @objid ("50725237-1df6-48c2-9034-9a3d2bb51875")
    public void creaCancion(String titulo, String artista, String album, String duracion, String genero, String letra, String video, String descarga) {
    }

    @objid ("46f74235-c03b-4df8-a5ca-2ee680763e01")
    public void eliminaCancion(String id) {
    }

}
