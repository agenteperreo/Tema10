package excepciones.ejercicio3;

public class Fecha {

	/**
	 * Atributo que contiene el día en formato entero
	 */
	private int dia = 1;
	/**
	 * Atributo que contiene el mes en formato entero
	 */
	private int mes = 1;
	/**
	 * Atributo que contiene el año en formato entero
	 */
	private int anho = 1970;

	/**
	 * Constructor por defecto
	 */
	public Fecha() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros
	 *
	 * @param dia  Variable que contiene el día
	 * @param mes  Variable que contiene el mes
	 * @param anho Variable que contiene el año
	 */
	public Fecha(int dia, int mes, int anho) {
		if (dia >= 1 && dia <= 31) {
			this.dia = dia;
		}
		if (mes >= 1 && mes <= 12) {
			this.mes = mes;
		}
		if (anho >= 1970) {
			this.anho = anho;
		}
	}

	/**
	 * Getter
	 *
	 * @return Devuelve el día
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * Setter
	 *
	 * @param dia Tiene como parámetro la variable que contiene el día
	 */
	public void setDia(int dia) throws DayOutOfRangeException {
		if (dia >= 1 && dia <= 31) {
			this.dia = dia;
		} else {
			throw new DayOutOfRangeException();
		}
	}

	/**
	 * Getter
	 *
	 * @return Devuelve el mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Setter
	 *
	 * @param mes Tiene como parámetro la variable que contiene el mes
	 */
	public void setMes(int mes) throws MonthOutOfRangeException {
		if (mes >= 1 && mes <= 12) {
			this.mes = mes;
		} else {
			throw new MonthOutOfRangeException();
		}
	}

	/**
	 * Getter
	 *
	 * @return Devuelve el año
	 */
	public int getAnho() {
		return anho;
	}

	/**
	 * Setter
	 *
	 * @param anho Tiene como parámetro la variable que contiene el año
	 */
	public void setAnho(int anho) throws YearOutOfRangeException {
		if (anho < 1962) {
			throw new YearOutOfRangeException();
		}
		this.anho = anho;
	}

	/**
	 * Método que comprueba si el año es bisiesto
	 *
	 * @return Devuelve si el año es bisiesto mediante true o false
	 */
	private boolean esBisiesto() {
		// Variable auxiliar booleana para saber si el año es bisiesto
		boolean estado = false;
		// Comprueba si el año es divisible entre 4
		if (this.anho % 4 == 0 && (this.anho % 100 != 0 || this.anho % 400 == 0)) {
			// En ese caso es true
			estado = true;
		}
		// Devuelve el estado
		return estado;
	}

	/**
	 * Método que comprueba que la fecha es correcta
	 *
	 * @return Devuelve si la fecha es correcta o no mediante un booleano
	 */
	public boolean fechaCorrecta() {
		// Variable auxiliar booleana para saber si la fecha tiene el formato correcto
		boolean estado = false;
		// Comprueba si el día es mayor que 1
		if (this.dia >= 1) {
			// El switch tiene como parámetro el mes
			switch (this.mes) {
			case 1, 3, 5, 7, 8, 10, 12: {
				// Los meses 1,3,5,7,8,10,12 tienen los días hasta el 31
				estado = true;
				break;
			}
			case 2: {
				// El mes dos llega hasta el día 28 o hasta el día 29 en caso de que sea
				// bisiesto
				if ((esBisiesto() && this.dia <= 29) || this.dia <= 28) {
					estado = true;
				}
				break;
			}
			case 4, 6, 9, 11: {
				// Los meses 4,6,9,11 tienen los días hasta el 30
				if (this.dia <= 30) {
					estado = true;
				}
				break;
			}
			}
		}
		// Devuelve el estado
		return estado;
	}

	/**
	 * Método que suma el día y comprueba que la fecha sea correcta
	 */
	public void diaSiguiente() {
		// Le añade a la variable dia uno
		dia++;
		// El switch recibe como parámetro el mes
		switch (this.mes) {
		case 1, 3, 5, 7, 8, 10, 12: {
			// Si los meses 1,3,5,7,8,10,12 llegan a mayor que 31 el día se reinicia y se
			// añade un mes
			if (this.dia > 31) {
				dia = 1;
				mes++;
			}
			break;
		}
		case 2: {
			// Comprueba si el día no entra en el mes
			if ((esBisiesto() && this.dia > 29) || this.dia > 28) {
				// Se reinicia los días
				dia = 1;
				// Se avanza de mes
				mes++;
			}
			break;
		}
		case 4, 6, 9, 11: {
			// Comprueba si los meses 4,6,9,11 superan el día 30
			if (this.dia > 30) {
				// Se reinicia los días
				dia = 1;
				// Se avanza de mes
				mes++;
			}
			break;
		}
		}
		// Comprueba si el mes es mayor que 12
		if (mes > 12) {
			// Se añade un año
			anho++;
			// Se reinician los meses
			mes = 1;
		}
	}

	/**
	 * Método que pasa a una String la fecha y comprueba si el día y el mes
	 *
	 * @return Devuelve el resultado con la fecha
	 */
	public String toString() {
		// Variable que irá guardando la fecha
		String res = "";
		// Comprueba si el número es de una cifra
		if (dia <= 9) {
			// Le añade 0 por delante
			res += "0";
		}
		// A continuación añade el día y dos puntos
		res += dia + "-";
		// Comprueba si el número es de una cifra
		if (mes <= 9) {
			// Le añade 0 por delante
			res += "0";
		}
		// A continuación añade el mes y dos puntos
		res += mes + "-";
		// Por último añade el año
		res += anho;
		// Devuelve el resultado
		return res;
	}
}
