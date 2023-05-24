package excepciones.ejercicio2;

public class NegtiveMinuteException extends Exception {

	@Override
	public String toString() {
		return "ERROR: Los minutos no pueden ser negativos";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Los minutos no pueden ser negativos";
	}
}
