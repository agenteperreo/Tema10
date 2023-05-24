package ficheros.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	/**
	 * Metodo principal de la classe.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		// Creamos el buffered writer y lo inicializamos a null
		BufferedWriter bw = null;

		// Abrimos el escaner
		Scanner sc = new Scanner(System.in);

		// Variable que contendra lo que escriba el usuario
		String texto = "";

		try {
			// Instanciamos el buffered writer
			bw = new BufferedWriter(new FileWriter("src/ficheros/ejercicio4/fichero.txt"));

			// Leemos lo que escriba el usuario
			System.out.println("Escriba lo que quiera añadir al fichero(fin para finalizar).");
			texto = sc.nextLine();

			// Mientras no escriba fin
			while (!texto.equals("fin")) {

				// Escribimos el texto
				bw.write(texto);

				// Generamos nueva linea
				bw.newLine();

				// Limpiamos el buffered
				bw.flush();

				// Volvemos a leer lo escrito por el usuario
				texto = sc.nextLine();
			}

			bw.close();

			// Control de excepciones
		} catch (IOException e) {
			System.out.println("Error al crear el fichero");
			System.out.println(e.getMessage());
		}

		// Cerramos el escaner
		sc.close();
	}

}
