package excepciones.ejercicio3;

public class FechaMain {

	public static void main(String[] args) {

		// Creamos fecha
		Fecha fecha = new Fecha(2, 9, 2004);

		try {
			// Cambiamos el año
			fecha.setAnho(-3);
		} catch (YearOutOfRangeException e) {
			System.err.println(e.getMessage());
		}

		try {
			// Cambiamos el mes
			fecha.setMes(-8);
		} catch (MonthOutOfRangeException e) {
			System.err.println(e.getMessage());
		}

		try {
			// Cambiamos el dia
			fecha.setDia(-10);
		} catch (DayOutOfRangeException e) {
			System.err.println(e.getMessage());
		}

	}
}
