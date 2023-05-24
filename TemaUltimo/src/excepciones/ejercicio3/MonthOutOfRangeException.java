package excepciones.ejercicio3;

public class MonthOutOfRangeException extends Exception{

	@Override
	public String toString() {
		return "ERROR: Mes introducido invalido";
	}
	
	@Override
	public String getMessage() {
		return "ERROR: Mes introducido invalido";
	}
}
