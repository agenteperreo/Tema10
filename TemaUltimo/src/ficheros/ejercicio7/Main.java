package ficheros.ejercicio7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Opción del usuario
		int opc;

		// Nombre del contacto
		String nombre;

		// Telefono del contacto
		String telefono;

		// Abrimos el escaner
		Scanner sc = new Scanner(System.in);

		// Si los contactos esta vacio
		if (Utilidades.contactos.isEmpty()) {

			// Mostramos los contactos
			Utilidades.mostrarContactos();
		}

		// Mientras la opción no sea 4
		do {
			// Mostramos el menú
			Utilidades.menu();

			// Le pedimos al usuario que elija una opción
			System.out.print("¿Que quieres hacer?: ");
			opc = sc.nextInt();
			System.out.println();

			// Según opc
			switch (opc) {

			// Si la opción es 1
			case 1 -> {
				try {

					// Le pedimos al usuario que introduzca el nombre del contacto
					System.out.println("Introduce el nombre del contacto:");
					nombre = sc.next();

					// Le pedimos el numero de telefono
					System.out.println("Introduce el teléfono del contacto:");
					telefono = sc.next();

					// Si el nombre del contacto no existe en la agenda
					Utilidades.nuevoContacto(nombre, telefono);
					System.out.println();

					// Control de excepciones
				} catch (MaxSizeException e) {
					System.err.println(e.getMessage());
				} catch (NombreIgualException e) {
					System.err.println(e.getMessage());
				}

			}

			// Si la opcion es 2
			case 2 -> {

				// Le pedimos al usuario que introduzca el nombre del contacto que desea buscar
				System.out.println("Introduce el nombre del contacto:");
				nombre = sc.next();
				sc.nextLine();

				// Buscamos al contacto
				Utilidades.buscarPorNombre(nombre);

				System.out.println();
			}

			// Si la opcion es 3
			case 3 -> {
				// Mostramos mensaje de información
				System.out.println("Estos son los contactos guardados ");

				// Mostramos los contactos
				Utilidades.mostrarTodos();
				
				System.out.println();
			}

			// Si la opción es 4
			case 4 -> {
				// Llamamos al metodo para insertar los contactos en el fichero
				Utilidades.escribirFichero();

				// Mostramos mensaje de despedida
				System.out.println("Hasta pronto...");
			}
			}
		} while (opc != 4); // Fin del do/while

		// Cerramos el scanner
		sc.close();

	}
}
