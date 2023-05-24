package excepciones.ejercicio2;

public class Hora {

	private int hora;
	private int minuto;
	private int segundo;

	public Hora() {

	}

	public Hora(int hora, int minuto, int segundo) throws NegativeHourException, NegtiveMinuteException, NegativeSecondException {
		
		if (hora >= 0 && hora <= 23) {
			this.hora = hora;
		} else {
			throw new NegativeHourException();
		}
		
		if (minuto >= 0 && minuto <= 60) {
			this.minuto = minuto;
		} else {
			throw new NegtiveMinuteException();
		}

		if (segundo < 0) {
			throw new NegativeSecondException();
		} else {
			this.segundo = segundo;
		}
	}

	public Hora(Hora h) {
		this.hora = h.hora;
		this.minuto = h.minuto;
		this.segundo = h.segundo;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws NegativeHourException {
		if (hora >= 0 && hora <= 23) {
			this.hora = hora;
		} else {
			throw new NegativeHourException();
		}
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) throws NegtiveMinuteException {
		if (minuto >= 0 && minuto <= 23) {
			this.minuto = minuto;
		} else {
			throw new NegtiveMinuteException();
		}
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) throws NegativeSecondException {
		if (segundo < 0) {
			throw new NegativeSecondException();
		} else {
			this.segundo = segundo;
		}
	}
}
