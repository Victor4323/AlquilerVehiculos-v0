package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
public class Alquileres {

	     List<Alquiler> coleccionAlquileres;

	    public Alquileres() {
	        this.coleccionAlquileres = new ArrayList<>();
	    }

	    public List<Alquiler> get() {
	        return new ArrayList<>(this.coleccionAlquileres);
	    }

	    public List<Alquiler> get(Turismo turismo) {
	        List<Alquiler> alquileresTurismo = new ArrayList<>();
	        for (Alquiler alquiler : this.coleccionAlquileres) {
	            if (alquiler.getTurismo().equals(turismo)) {
	                alquileresTurismo.add(alquiler);
	            }
	        }
	        return alquileresTurismo;
	    }

	    public List<Alquiler> get(Cliente cliente) {
	        List<Alquiler> alquileresCliente = new ArrayList<>();
	        for (Alquiler alquiler : this.coleccionAlquileres) {
	            if (alquiler.getCliente().equals(cliente)) {
	                alquileresCliente.add(alquiler);
	            }
	        }
	        return alquileresCliente;
	    }

	    public int getCantidad() {
	        return this.coleccionAlquileres.size();
	    }

	    public boolean comprobarAlquiler(Alquiler alquiler) {
	        if (alquiler == null || coleccionAlquileres.contains(alquiler)) {
	            return false;
	        }
	        for (Alquiler a : coleccionAlquileres) {
	            if (a.getCliente().equals(alquiler.getCliente()) && a.getFechaDevolucion() == null) {
	                return false;
	            }
	            if (a.getTurismo().equals(alquiler.getTurismo()) && a.getFechaDevolucion() == null) {
	                return false;
	            }
	            if (a.getCliente().equals(alquiler.getCliente()) && a.getTurismo().equals(alquiler.getTurismo())
	                    && a.getFechaAlquiler().isBefore(alquiler.getFechaDevolucion())
	                    && (a.getFechaDevolucion() == null || a.getFechaDevolucion().isAfter(alquiler.getFechaAlquiler()))) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public void insertar(Alquiler alquiler) throws Exception {
	        if (!comprobarAlquiler(alquiler)) {
	            coleccionAlquileres.add(alquiler);
	        }else {
	        	throw new Exception("ERROR: No se puede insertar el alquiler");
	        }

	    }
	    

	    public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
	        if (alquiler == null) {
	            throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
	        }

	        if (buscar(alquiler) == null) {
	            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
	        }
	        alquiler.devolver(fechaDevolucion);
	    }

	    public Alquiler buscar(Alquiler alquiler) {
	        if (alquiler == null) {
	        	throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
	        	}
	        	int indice = coleccionAlquileres.indexOf(alquiler);
	     
	        return (indice == -1) ? null : coleccionAlquileres.get(indice);
	    }
	    public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
	    	if(alquiler == null) {
	    		throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
	    	}
	    	if (buscar(alquiler) == null) {
	    		throw new OperationNotSupportedException("ERROR; No exisiste ningún alquiler igual.");
	    	}
	    	coleccionAlquileres.remove(alquiler);
	    }
	    }
	

