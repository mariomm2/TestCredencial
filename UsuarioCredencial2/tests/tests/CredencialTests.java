package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import como.Credencial;
import org.junit.jupiter.api.BeforeEach;

class CredencialTests {

	    private Credencial credencial;

	    @BeforeEach
	    void setUp() {
	        credencial = new Credencial("Mario", "Martin", "Password1");
	    }

	    @Test
	    void testGenerarUsername() {
	        String username = credencial.getUsername();
	        assertTrue(username.startsWith("mar") && username.contains("mar"), "Nombre usuario debe crearse bien.");
	    }

	    @Test
	    void testComprobarPassword() {
	        assertTrue(credencial.comprobarPassword("Password1"), "Contraseña debe ser correcta.");
	        assertFalse(credencial.comprobarPassword("Incorrecta"), "Contraseña incorrecta debe dar error.");
	    }

	    @Test
	    void testEsPasswordSegura() {
	        assertTrue(credencial.esPasswordSegura(), "Detectar que la contraseña es segura.");
	        
	        credencial.setPassword("abcdefg");
	        assertFalse(credencial.esPasswordSegura(), "Contraseña no segura.");
	        
	        credencial.setPassword("ABCDEF12");
	        assertTrue(credencial.esPasswordSegura(), "Contraseña segura.");
	    }

	    @Test
	    void testModificarPassword() {
	        credencial.setPassword("NuevaPass123");
	        assertEquals("NuevaPass123", credencial.getPassword(), "Cambiar la contraseña.");
	    }
	}

