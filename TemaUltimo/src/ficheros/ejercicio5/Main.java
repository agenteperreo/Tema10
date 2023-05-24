package ficheros.ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	// Creamos el linkedhashmap
	public static LinkedHashMap<String, Integer> usuarios = new LinkedHashMap<>();

	public static void main(String[] args) {

		// Nombre del usuario
		String nombre;

		// Edad del usuario
		int edad;

		// Respuesta del usuario
		String respuesta;

		// Abrimos el escaner
		Scanner sc = new Scanner(System.in);

		// Le preguntamos al usuario si quiere introducir un usuario
		System.out.println("Quiere introducir un usuario? (S/N)");
		respuesta = sc.next();

		// Mientras la respuesta sea s
		while (respuesta.equalsIgnoreCase("s")) {
			
			// Le pedimos los datos al usuario
			System.out.print("Ingrese el nombre del usuario: ");
			nombre = sc.next();
			System.out.print("Ingrese la edad del usuario: ");
			edad = sc.nextInt();
			sc.nextLine();

			// Guardamos los datos en el LinkedHashMap
			usuarios.put(nombre, edad);

			// Le preguntamos al usuario si quiere introducir un usuario
			System.out.println("Quiere introducir otro usuario? (S/N)");
			respuesta = sc.next();
		}

		// Escribimos los datos en el fichero
		escribirDatos();
		
		// Mensaje de despedida
		System.out.println("Hasta pronto");

		// Cerramos el scanner
		sc.close();
	}

	/**
	 * Metodo para escribir datos dentro del fichero
	 */
	private static void escribirDatos() {

		// Creamos el buffered a null
		BufferedWriter bw = null; 
		
		// Linea dek fichero
		String linea; 
		
		// Nombre del usuario
		String nombre;
		
		// Edad del usuario
		int edad;
		
		// Fichero donde guardar los datos
		File fichero = new File("src/ficheros/ejercicio5/datos.txt");

		try {
			// Comprobamos si el archivo existe, si no existe lo creamos
			if (!fichero.exists()) {
				fichero.createNewFile();
			}
			// Inicializamos el Buffered
			bw = new BufferedWriter(new FileWriter(fichero, true));

			// Recorremos la colección 
			for (Map.Entry<String, Integer> entrada : usuarios.entrySet()) {

				// Guardamos el nombre y la edad de la colección
				nombre = entrada.getKey();
				edad = entrada.getValue();

				// Guardamos los datos en la variables
				linea = nombre + " " + edad;
				
				// Escribimos la línea en el archivo de texto
				bw.write(linea);
				
				// Pasamos a la siguiente línea el archivo de texto
				bw.newLine();
			}
			// Limpiamos la caché del buffer
			bw.flush();

			// Control de excepciones
		} catch (IOException e) {
			System.err.println("ERROR: Error al insertar información");
		} finally { // Despues del try
			try {
				
				// El buffer no esta a null
				if (bw != null) {
					
					// Lo cerramos
					bw.close();
				}
				
				// Control de excepciones
			} catch (IOException e) {
				System.err.println("ERROR: Error al cerrar el archivo.");
			}
		}
	}

}
