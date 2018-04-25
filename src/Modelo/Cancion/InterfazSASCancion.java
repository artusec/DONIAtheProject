import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("aa421039-e37c-4254-a80a-887a3f8b1c50")
public interface InterfazSASCancion {
    @objid ("2fc9f96e-4e26-4a50-8e5d-72968218d06a")
    void descargaVideo(String cancion);

    @objid ("9dbb85c6-11bb-46c4-9f20-9c80409332f9")
    void consultaCancion(String cancion);

    @objid ("51e37923-04e7-4807-8509-3e3eee344931")
    void consultaLetra(String cancion);

    @objid ("7fc3a31f-53f1-4f64-a791-255e4efba758")
    void consultaVideo(String cancion);

}
