package ficheros.ejercicio7;

public class NombreIgualException extends Exception {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ERROR: Contacto ya existente";
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERROR: Contacto ya existente";
	}
}
