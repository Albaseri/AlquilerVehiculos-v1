package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum FactoriaVista {
	TEXTO {
		@Override
		public Vista crear() {
			return null;
		}
	};

	public abstract Vista crear();
}
