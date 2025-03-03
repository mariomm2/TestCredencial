package como;

public class Credencial {
    private String username;
    private String password;
    private static int secuencia = 100;

    public Credencial(String nombre, String apellidos, String password) {
        this.username = generarUsername(nombre, apellidos);
        this.password = password;
        secuencia++;
    }

    private String generarUsername(String nombre, String apellidos) {
        String tresNombre = (nombre.length() >= 3) ? nombre.substring(0, 3).toLowerCase() : nombre.toLowerCase();
        String tresUltimasApellido = (apellidos.length() >= 3) ? apellidos.substring(0, 3).toLowerCase() : apellidos.toLowerCase();

        return tresNombre + tresUltimasApellido + secuencia;
    }

    public boolean comprobarPassword(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean esPasswordSegura() {
        boolean tieneMayuscula = false;
        boolean tieneDigito = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    tieneMayuscula = true;
                }
                if (Character.isDigit(c)) {
                    tieneDigito = true;
                }
            }
        }

        return tieneMayuscula && tieneDigito;
    }

    public void setPassword(String newpass) {
        this.password = newpass;
    }

    public String getPassword() {
        return password;
    }
}
