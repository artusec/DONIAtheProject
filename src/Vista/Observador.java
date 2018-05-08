package Vista;

public interface Observador<T> {
	
	public void addObservador(T o);
	public void removerObservador (T o); 
}
