package com.endes.entidad;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ComercialTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetSueldo() {
		Comercial Comercial = new Comercial("12345678A", "Juan", "Pérez", 1000.0, 5);
		double SueldoBase = 1000.0;
		int ventas = 5;
		double sueldoEsperado = SueldoBase + (ventas * 0.10);
		assertEquals(sueldoEsperado, Comercial.getSueldo());
		
	}

	@Test
	void testCalcularExtra() {
		Comercial Comercial = new Comercial("12345678A", "Juan", "Pérez", 1000.0, 5);
		double extraEsperado = 5 * 0.10;
		assertEquals(extraEsperado, Comercial.calcularExtra());	
	}

	@Test
	void testGetVentas() {
		int ventas = 5;
		int ventasEsperadas = 5;
		int ventasObtenidas = 5;
		assertEquals(ventasEsperadas, ventasObtenidas);
	}

	@Test
	void testSetVentas() {
		double SeTventas;
		SeTventas = -1;
		IllegalArgumentException ex0 = assertThrows(IllegalArgumentException.class, () -> new Comercial(null, null, null, SeTventas, 0),
				"Las ventas no pueden ser negativas");
	}
}

	
