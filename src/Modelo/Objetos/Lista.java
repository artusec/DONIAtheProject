package Modelo.Objetos;

import Excepciones.ErrorCreacionObjeto;

public interface Lista {
	
    public String getId();
    public void setId(String id) throws ErrorCreacionObjeto;
    public String getNombre();
    public void setNombre(String nombre);
    
    
    //¿Habria que hacaer insertar cancion y eliminar cancion no?
    
    public void insertaCancion(Cancion cancion);
    public void eliminaCancion(Cancion cancion);
    
 
}
