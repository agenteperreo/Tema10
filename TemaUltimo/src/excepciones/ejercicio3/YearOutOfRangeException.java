package excepciones.ejercicio3;

public class YearOutOfRangeException extends Exception{

	@Override
	public String toString() {
		return "ERROR: Año introducido invalido";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Año introducido invalido";
	}
}
