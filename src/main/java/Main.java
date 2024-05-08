import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Ejercicio_5.UserAccount;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<UserAccount> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                UserAccount user = UserAccount.fromString(line);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        UserAccount currentUser = null;
        while (true) {
            System.out.println("1. Cargar usuario");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over
            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de usuario: ");
                    String username = scanner.nextLine();
                    currentUser = findUser(users, username);
                    if (currentUser == null) {
                        System.out.println("Usuario no encontrado");
                    } else {
                        System.out.println("Usuario cargado: " + currentUser);
                    }
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    public static UserAccount findUser(ArrayList<UserAccount> users, String username) {
        for (UserAccount user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Devuelve null si no se encuentra el usuario
    }
}