package como;

public class Usuario {
    private static final int NUMERO_MAX_INTENTOS = 3;
    private String nombre;
    private String apellidos;
    private String email;
    private int intentos;
    private Credencial credencial; 

    public Usuario(String nombre, String apellidos, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = ""; 
        this.intentos = 0; 
        this.credencial = new Credencial(nombre, apellidos, password); 
    }

    public Usuario(String nombre, String apellidos, String email, String password) {
        this(nombre, apellidos, password); 
        this.email = email; 
    }

    public boolean esCuentaBloqueada() {
        return intentos >= NUMERO_MAX_INTENTOS;
    }

    private void setCredencial(Credencial credencial) {
        this.credencial = credencial;
    }

    public boolean modificarPassword(String oldpass, String newpass, String newpassverif) {
        if (!credencial.comprobarPassword(oldpass)) {
            System.out.println("La contraseña actual no es correcta.");
            return false;
        }

        if (!newpass.equals(newpassverif)) {
            System.out.println("Las nuevas contraseñas no coinciden.");
            return false;
        }

        if (newpass.equals(oldpass)) {
            System.out.println("La nueva contraseña no puede ser igual a la anterior.");
            return false;
        }

        credencial.setPassword(newpass);
        System.out.println("La contraseña se ha modificado correctamente.");
        return true;
    }

    public boolean esPasswordSegura() {
        return this.credencial.esPasswordSegura();
    }

    public boolean hacerLogin(String username, String password) {
        if (esCuentaBloqueada()) {
            System.out.println("Cuenta bloqueada. No se puede iniciar sesión.");
            return false;
        }

        if (credencial.getUsername().equals(username) && credencial.comprobarPassword(password)) {
            intentos = 0;
            return true;
        } else {
            intentos++;
            System.out.println("Login fallido. Intentos restantes: " + (NUMERO_MAX_INTENTOS - intentos));
            return false;
        }
    }

    public void mostrarInformacion() { 
        if (esCuentaBloqueada()) {
            System.out.println("Cuenta bloqueada.");
        } else {
            System.out.println("Usuario: " + this.nombre + " " + this.apellidos +
                               " con email " + this.email + ", username " + credencial.getUsername() +
                               " y contraseña " + "*".repeat(credencial.getPassword().length()));
        }
    }

	public String getUsername() {
		return null;
	}
}
