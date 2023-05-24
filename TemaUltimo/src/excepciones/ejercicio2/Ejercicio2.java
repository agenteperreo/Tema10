package excepciones.ejercicio2;

public class Ejercicio2 {

	public static void main(String[] args) {

		try {
			Hora h = new Hora(12, 25, 47);
			h.setSegundo(-25);
		} catch (NegativeSecondException e) {
			System.err.println(e.toString());
		} catch (NegativeHourException e) {
			System.err.println(e.getMessage());
		} catch (NegtiveMinuteException e) {
			System.err.println(e.getMessage());
		}
	}

}
