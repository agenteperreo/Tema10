package ficheros.ejercicio7;

public class MaxSizeException extends Exception {
	
	@Override
	public String toString() {
		return "ERROR: No hay mas hueco para contactos, contacto no añadido";
	}
	
	@Override
	public String getMessage() {
		return  "ERROR: No hay mas hueco para contactos, contacto no añadido";
	}

}
