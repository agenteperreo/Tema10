package excepciones.ejercicio3;

public class DayOutOfRangeException extends Exception {

	@Override
	public String toString() {
		return "ERROR: Dia introducido invalido";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Dia introducido invalido";
	}
}
