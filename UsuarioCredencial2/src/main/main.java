package main;

import como.Usuario;

public class main {  

    public static void main(String[] args) {
        
        Usuario[] usuarios = new Usuario[10];
        
        Usuario usuario1 = new Usuario("Mario", "Martin", "mariomartinmaldonado@gmail.com", "Password1");
        Usuario usuario2 = new Usuario("Manolito", "Pérez", "manolitoP@gmail.com", "Password1");
        Usuario usuario3 = new Usuario("Pepe", "Castaño", "Pepep@gmail.com", "Password1");
        
        usuarios[0] = usuario1;
        usuarios[1] = usuario2;
        usuarios[2] = usuario3;
                
  
        String username = usuario1.getUsername();
        System.out.println("Username generado: " + username);

        System.out.println("Login 1: " + usuario1.hacerLogin(username, "Password1"));
        System.out.println("Login 2: " + usuario1.hacerLogin(username, "Password13"));
        System.out.println("Login 3: " + usuario1.hacerLogin(username, "password1"));
        System.out.println("Login 4: " + usuario1.hacerLogin(username, "password1"));

        boolean cambioPassword = usuario1.modificarPassword("Password1", "Password234", "Password234");
        System.out.println("¿Se cambio la contraseña?: " + cambioPassword);
        
        usuario1.mostrarInformacion();
        
        System.out.println("¿Cuenta bloqueada?: " + usuario1.esCuentaBloqueada());
    }
}
