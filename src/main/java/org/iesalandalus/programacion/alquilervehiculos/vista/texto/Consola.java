package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final String PATRON_MES = "MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private void Consola() {
	}

	public static void mostrarCabecera(String mensaje) {
		StringBuilder cabecera = new StringBuilder(); // creo el objeto cabecera, lo inicializo con cadena vacía.
		cabecera.append("-");
		System.out.println(mensaje);
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print(cabecera);
		}
		System.out.println();
	}

	public static void mostrarMenuAcciones() {
		mostrarCabecera("Plataforma para alquileres de coches.");
		for (Accion pruebaOp : Accion.values()) {
			System.out.println(pruebaOp.toString());
		}
	}

	public static Accion elegirAccion() {
		Accion ordinal = null;
		do {
			try {
				ordinal = Accion.get(leerEntero("Introduzca un número entero: "));
			} catch (Exception e) {
				System.out.println("El ordinal no es válido.");
			}
		} while (ordinal == null && ordinal != Accion.SALIR);
		return ordinal;
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje, String patron) {
		System.out.print(mensaje);
		LocalDate fecha;
		try {
			fecha = LocalDate.parse(leerCadena(mensaje), FORMATO_FECHA);
		} catch (Exception e) {
			fecha = null;
		}
		return fecha;
	}

	public static Cliente leerCliente() {
		return new Cliente(leerCadena("Introduzca su nombre: "), leerCadena("Introduzca su DNI: "),
				leerCadena("Introduzca su teléfono: "));
	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduzca su dni: "));
	}

	public static String leerNombre() {
		return leerCadena("Introduzca su nombre");
	}

	public static String leerTelefono() {
		return leerCadena("Introduzca su número de teléfono");
	}

	public static Vehiculo leerVehiculo() {
		return Vehiculo.copiar(leerCadena("Introduce la marca: "), leerCadena("Introduce el modelo: "),
				leerEntero("Introduce la cilindrada: "), leerCadena("Introduce la matrícula: "));
	}

	private static void mostrarMenuTipoVehiculos() {
		mostrarCabecera("Mostrando los distintos tipos de vehículos.");
		for (Accion pruebaOp : Accion.values()) {
			System.out.println(pruebaOp.toString());
		}
	}

	private static Vehiculo elegirTipoVehiculo(Vehiculo TipoVehiculo) {
		mostrarMenuTipoVehiculos();
		return TipoVehiculo;
	}

	private static Vehiculo leerVehiculo(TipoVehiculo tipoVehiculo) {
		return null;
	}

	public static Vehiculo leerVehiculoMatricula() {
		String matricula = leerCadena("Introduzca su matrícula: ");
		return Vehiculo.getVehiculoConMatricula(matricula);

	}

	public static Alquiler leerAlquiler() {
		return new Alquiler(leerClienteDni(), leerVehiculoMatricula(), leerFecha("Introduzca la fecha de alquiler: "));
	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Introduzca la fecha de devolución: ");
	}

	public static LocalDate leerMes() {
		return PATRON_MES;

	}
}