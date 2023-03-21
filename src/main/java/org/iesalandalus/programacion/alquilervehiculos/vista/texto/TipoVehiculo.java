package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public enum TipoVehiculo {
TURISMO,
AUTOBUS,
FURGONETA;
	
	private String nombre;
	
	private TipoVehiculo (String nombre) {
		
	}
	
	private static boolean esOrdinalValido(int ordinal) {
		return ordinal >= 0 && ordinal < TipoVehiculo.values().length; 

	}
	public static TipoVehiculo get(int ordinal) {
		
	}
	public static TipoVehiculo get(Vehiculo vehiculo) {
		
	}
	@Override
	public String toString() {
		return String.format("%s. %s", ordinal(), nombre);
	}
}
