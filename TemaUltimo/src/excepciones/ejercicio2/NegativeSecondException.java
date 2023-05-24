package excepciones.ejercicio2;

public class NegativeSecondException extends Exception {

	@Override
	public String toString() {
		return "ERROR: Los segundos no pueden ser negativos";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Los segundos no pueden ser negativos";
	}

}
