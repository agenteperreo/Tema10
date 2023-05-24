package ficheros.ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {

	private static final String FICHERO = "src\\ficheros\\ejercicio8\\temperaturas.txt";

	public static void main(String[] args) {

		// Opcion del usuario
		int opc;

		// Linea
		String linea;

		// Fecha de la toma de la temperatura
		String fecha;

		// Temperatura minima
		double tempMin;

		// Temperatura maxima
		double tempMax;

		// Tmeperatura minima total
		double tempMinTotal = Double.MAX_VALUE;

		// Temperatura maxima total
		double tempMaxTotal = Double.MIN_VALUE;

		// Array de datos
		String[] datos;

		// Abrimos el escaner
		Scanner sc = new Scanner(System.in);

		// Inicializamos ambos buffereds
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			// Intanciamos el writer
			bw = new BufferedWriter(new FileWriter(FICHERO, true));

			do {

				// Mostramos el menu
				menu();

				// Pedimos la opcion
				opc = sc.nextInt();
				sc.nextLine();

				// En funcion de la opcion
				switch (opc) {
				case 1: // Registrar temperatura

					// Pedimos los datos
					System.out.println("Introduzca la fecha (aaaa-mm-dd):");
					fecha = sc.nextLine();

					System.out.println("Introduzca la temperatura mínima:");
					tempMin = sc.nextDouble();
					sc.nextLine();

					System.out.println("Introduzca la temperatura máxima:");
					tempMax = sc.nextDouble();
					sc.nextLine();

					// Escribimos los datos
					bw.write(fecha + "," + tempMax + "," + tempMin);
					bw.newLine();

					// Limpiamos el cache del buffer
					bw.flush();

					break;

				case 2: // Mostrar historial
					br = new BufferedReader(new FileReader(FICHERO));
					br.readLine();
					linea = br.readLine();
					while (linea != null) {
						datos = linea.split(",");
						System.out.println("Fecha: " + datos[0]);

						tempMax = Double.parseDouble(datos[1]);

						tempMin = Double.parseDouble(datos[2]);

						System.out.println("Temperatura máxima: " + tempMax);
						System.out.println("Temperatura mínima: " + tempMin);
						System.out.println("--------------------------------");

						if (tempMaxTotal < tempMax) {
							tempMaxTotal = tempMax;
						}

						if (tempMinTotal > tempMin) {
							tempMinTotal = tempMin;
						}

						linea = br.readLine();
					}
					System.out.println("Temperatura máxima total: " + tempMaxTotal);
					System.out.println("Temperatura mínima total: " + tempMinTotal);
					System.out.println();
					break;
				}

			} while (opc != 3);

		} catch (IOException e) {
			System.out.println("Error al abrir el fichero");
			System.out.println(e.getMessage());
		} finally {
			if (bw != null) {
				try {
					bw.close();
					br.close();
					sc.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar el fichero");
					System.out.println(e.getMessage());
				}
			}
		}

	}

	/**
	 * Metodo para mostrar el menu
	 */
	public static void menu() {
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");
	}
}
