package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Pruebas unitarias para la clase Plantilla.
 */
class PlantillaTest {
    private Plantilla plantilla;

    @BeforeEach
    @DisplayName("Inicialización de la plantilla de empleados")
    void setUp() {
        plantilla = new Plantilla();
    }

    /**
     * Prueba que verifica que no se puedan contratar empleados con el mismo DNI.
     */
    @Disabled
    @Test
    @DisplayName("No permite contratar empleados con el mismo DNI")
    void testContratarEmpleado_Duplicado() {
        Empleado tecnico1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
        Empleado tecnico2 = new Tecnico("11111111H", "Carlos", "Pérez", 1200.0, 2); // Mismo DNI que el primero

        // Se permite el primer contrato
        assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico1));

        // Intentar contratar otro empleado con el mismo DNI debería lanzar una excepción
        Exception ex = assertThrows(IllegalArgumentException.class, () -> plantilla.contratarEmpleado(tecnico2));

        // Verificar el mensaje de la excepción
        assertEquals("El empleado con DNI 11111111H ya está contratado", ex.getMessage());
    
   }
    void testContratarEmpleado() {
		Empleado tecnico = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
		assertDoesNotThrow(() -> plantilla.contratarEmpleado(tecnico));
	}
    
	@Test
	@DisplayName("Buscar empleados por nombre o apellido")
	void testGetEmpleadosPorNombre() {
		Empleado tecnico = new Tecnico("11111111H", "Alejandro", "Fernández", 1000.0, 1);
		Empleado comercial = new Comercial("22222222J", "Jerónima", "Jiménez", 800.0, 2000.0);
		plantilla.contratarEmpleado(tecnico);
		plantilla.contratarEmpleado(comercial);

		// Buscar por nombre
		List<Empleado> resultadoNombre = plantilla.getEmpleadosPorNombre("Alejandro");
		assertEquals(1, resultadoNombre.size());
		assertEquals("Alejandro", resultadoNombre.get(0).getNombre());

		// Buscar por apellido
		List<Empleado> resultadoApellido = plantilla.getEmpleadosPorNombre("Jiménez");
		assertEquals(1, resultadoApellido.size());
		assertEquals("Jiménez", resultadoApellido.get(0).getApellidos());

		// Buscar con filtro que no existe
		List<Empleado> resultadoVacio = plantilla.getEmpleadosPorNombre("NoExiste");
		assertTrue(resultadoVacio.isEmpty());
	}
}
