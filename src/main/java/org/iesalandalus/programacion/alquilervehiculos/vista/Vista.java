package org.iesalandalus.programacion.alquilervehiculos.vista;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {
	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: No puede ser nulo el controlador");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}

	public void terminar() {
		System.out.println("ERROR: La vista ha terminado");
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			controlador.terminar();
			break;
		case 1:
			insertarCliente();
			comenzar();
			break;
		case 2:
			insertarTurismo();
			comenzar();
			break;
		case 3:
			insertarAlquiler();
			comenzar();
			break;
		case 4:
			buscarCliente();
			comenzar();
			break;
		case 5:
			buscarTurismo();
			comenzar();
			break;
		case 6:
			buscarAlquiler();
			comenzar();
			break;
		case 7:
			modificarCliente();
			comenzar();
			break;
		case 8:
			devolverAlquiler();
			comenzar();
			break;
		case 9:
			borrarCliente();
			comenzar();
			break;
		case 10:
			borrarTurismo();
			comenzar();
			break;
		case 11:
			borrarAlquiler();
			comenzar();
			break;
		case 12:
			listarClientes();
			comenzar();
			break;
		case 13:
			listarTurismos();
			comenzar();
			break;
		case 14:
			listarAlquileres();
			comenzar();
			break;
		case 15:
			listarAlquileresCliente();
			comenzar();
			break;
		case 16:
			listarAlquileresTurismo();
			comenzar();
			break;
		}
	}

	private void insertarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		try {
			controlador.insertar(Consola.leerCliente());
			System.out.printf("ERROR: Se ha insertado el cliente");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}

	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		try {
			controlador.insertar(Consola.leerTurismo());
			System.out.printf("ERROR: Se ha insertado el turismo");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.printf("ERROR: Se ha insertado el alquiler");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerCliente()));
			System.out.printf("ERROR: Se ha buscado el cliente");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerTurismo()));
			System.out.printf("ERROR: Se ha buscado el turismo");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerAlquiler()));
			System.out.printf("ERROR: Se ha encontrado el alquiler");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		try {
			controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.printf("ERROR: Se ha cambiado el cliente");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");
		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.printf("ERROR: Se ha devuelto el turismo");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			controlador.borrar(Consola.leerCliente());
			System.out.printf("ERROR: Se ha eliminado el cliente");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera("Eliminar turismo");
		try {
			controlador.borrar(Consola.leerTurismo());
			System.out.printf("ERROR: Se ha eliminado el turismo");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("Eliminar alquiler");
		try {
			controlador.borrar(Consola.leerAlquiler());
			System.out.printf("ERROR: Se ha eliminado el alquiler");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Eliminar clientes");
		try {
			for (Cliente cliente : controlador.getClientes()) {
				System.out.printf("%s%n", cliente);
			}
			System.out.printf("ERROR: Se han ordenado los clientes");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("ordenar turismos");
		try {
			for (Turismo turismo : controlador.getTurismos()) {
				System.out.printf("%s%n", turismo);
			}
			System.out.printf("ERROR: Se han ordenado turismos");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listar alquileres");
		try {
			for (Alquiler alquiler : controlador.getAlquileres()) {
				System.out.printf("%s%n", alquiler);
			}
			System.out.printf("ERROR: Se han ordenado los alquileres");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres clientes");
		try {
			for (Alquiler alquilerCliente : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.printf("%s%n", alquilerCliente);
			}
			System.out.printf("ERROR: Se han ordenado los alquileres del cliente");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listar alquileres turismos");
		try {
			for (Alquiler alquilerTurismo : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.printf("%s%n", alquilerTurismo);
			}
			System.out.printf("ERROR: Se han ordenado los alquileres del turismo");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}
}
