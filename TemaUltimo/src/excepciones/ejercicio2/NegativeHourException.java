package excepciones.ejercicio2;

public class NegativeHourException extends Exception {

	@Override
	public String toString() {

		return "ERROR: Las horas no pueden ser negativas";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Las horas no pueden ser negativos";
	}
}
