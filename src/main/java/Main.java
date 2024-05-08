import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Ejercicio_5.UserAccount;
import java.util.Scanner;
import Ejercicio_5.Tweet;
import java.util.*;

public class Main {
    //ordenar por email
    public static void sortUsersByEmail(ArrayList<UserAccount> users) {
        users.sort(Comparator.comparing(UserAccount::getUsername));
    }

    //ordenar por longitud de los tweets
    public static void sortUsersByTweetLength(ArrayList<UserAccount> users) {
        users.sort(Comparator.comparingInt(user -> user.getTweets().stream()
                .mapToInt(tweet -> tweet.getMessage().length())
                .sum()));
    }

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
        sortUsersByEmail(users);
        sortUsersByTweetLength(users);


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

    public static void postTweet(UserAccount user, String text) {
        try {
            Tweet tweet = new Tweet(text);
            user.tweet(tweet);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}