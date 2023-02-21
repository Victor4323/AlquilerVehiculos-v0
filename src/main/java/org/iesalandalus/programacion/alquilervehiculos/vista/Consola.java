package org.iesalandalus.programacion.alquilervehiculos.vista;


	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;

	import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
	import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
	import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
	import org.iesalandalus.programacion.utilidades.Entrada;

	public class Consola {

		private static final String PATRON_FECHA = "dd/MM/yyyy";
		private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

		private Consola() {
		}

		public static void mostrarCabecera(String mensaje) {
			StringBuilder rayas = new StringBuilder();
			for (int i = 0; i < mensaje.length(); i++) {
				rayas.append("-");
			}
			System.out.printf("%n%s%n%s%n", mensaje, rayas);
		}

		public static void mostrarMenu() {
			mostrarCabecera("         MENÚ         ");
			for (Opcion opcion : Opcion.values()) {
				System.out.println(opcion);
			}
			System.out.println("");
		}

		private static String leerCadena(String mensaje) {
			System.out.print(mensaje);
			return Entrada.cadena();
		}

		private static Integer leerEntero(String mensaje) {
			System.out.print(mensaje);
			return Entrada.entero();
		}

		private static LocalDate leerFecha(String mensaje) {
			System.out.print(mensaje);
			LocalDate fecha = null;
			try {
				fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
			} catch (DateTimeParseException e) {
				System.out.printf("%s", e.getMessage());
			}
			return fecha;
		}

		public static Opcion elegirOpcion() {
			int escogerOpcion = 0;
			Opcion opcion = null;
			do {
				try {
					escogerOpcion = leerEntero("Pon una opción: ");
					opcion = Opcion.get(escogerOpcion);
				} catch (IllegalArgumentException e) {
					System.out.printf("%s",e.getMessage());
				}
			} while (opcion == null);
			return opcion;
		}

		public static Cliente leerCliente() {
			return new Cliente(leerNombre(), leerCadena("Pon un DNI que sea válido: "), leerTelefono());
		}

		public static Cliente leerClienteDni() {
			return Cliente.getClienteConDni(leerCadena("Pon un DNI que sea válido: "));
		}

		public static String leerNombre() {
			return leerCadena("Mete el nombre de un cliente: ");
		}

		public static String leerTelefono() {
			return leerCadena("Mete el teléfono de un cliente: ");
		}

		public static Turismo leerTurismo() {
			return new Turismo(leerCadena("Indica la marca del turismo: "),
					leerCadena("Indica el modelo del turismo: "), leerEntero("Indica las cilindradas del turismo: "),
					leerCadena("Indica la matrícula: "));
		}

		public static Turismo leerTurismoMatricula() {
			return Turismo.getTurismoConMatricula(leerCadena("Indica la matrícula que sea válida: "));
		}

		public static Alquiler leerAlquiler() {
			return new Alquiler(leerClienteDni(), leerTurismoMatricula(), leerFecha("Indica la fecha del alquiler: "));
		}

		public static LocalDate leerFechaDevolucion() {
			return leerFecha("Indica la fecha de devolución: ");
		}

	}

