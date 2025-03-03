package tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import como.Usuario;
import org.junit.jupiter.api.BeforeEach;

class UsuarioTests {

	    private Usuario usuario;

	    @BeforeEach
	    void setUp() {
	        usuario = new Usuario("Mario", "Martin", "mariomartinmaldonado@gmail.com", "Password1");
	    }

	    @Test
	    void testEsCuentaBloqueada() {
	        assertFalse(usuario.esCuentaBloqueada(), "Cuenta no bloqueada.");

	        usuario.hacerLogin("marmar100", "incorrecta");
	        usuario.hacerLogin("marmar100", "incorrecta");
	        usuario.hacerLogin("marmar100", "incorrecta");

	        assertTrue(usuario.esCuentaBloqueada(), "Cuenta bloqueada tras 3 intentos");
	    }

	    @Test
	    void testHacerLogin() {
	        String username = usuario.getUsername();
	        
	        assertTrue(usuario.hacerLogin(username, "Password1"), "Login correcto.");
	        assertFalse(usuario.hacerLogin(username, "Incorrecta"), "Login incorrecto.");
	    }

	    @Test
	    void testModificarPassword() {
	        assertTrue(usuario.modificarPassword("Password1", "NuevaPass123", "NuevaPass123"), "Cambiar contraseña.");
	        assertFalse(usuario.modificarPassword("Password1", "NuevaPass123", "DiferentePass"), "No cambia contraseña.");
	    }

	    @Test
	    void testEsPasswordSegura() {
	        assertTrue(usuario.esPasswordSegura(), "Contraseña segura.");

	        usuario.modificarPassword("Password1", "abcdefg", "abcdefg");
	        assertFalse(usuario.esPasswordSegura(), "Contraseña no segura.");
	    }
	}

