import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Ejercicio_5.UserAccount;
import java.util.Scanner;
import Ejercicio_5.Tweet;
import java.util.*;
import Ejercicio_5.Email;

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
                        System.out.println("1. Sign up");
                        System.out.println("2. Volver");
                        System.out.print("Seleccione una opción: ");
                        int subOption = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        switch (subOption) {
                            case 1:
                                System.out.print("Ingrese el nombre de usuario: ");
                                String newUsername = scanner.nextLine();
                                System.out.print("Ingrese el correo electrónico: ");
                                String email = scanner.nextLine();
                                System.out.print("Ingrese la contraseña: ");
                                String password = scanner.nextLine();
                                UserAccount newUser = new UserAccount(newUsername, email, password);
                                users.add(newUser);
                                System.out.println("Usuario registrado exitosamente: " + newUsername);
                                System.out.println("Número de tweets publicados: " + newUser.getNumberOfTweets());
                                break;
                            case 2:
                                // Volver al menú principal
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    } else {
                        System.out.println("Usuario cargado: " + currentUser);
                        System.out.println("1. Log in");
                        System.out.println("2. Volver");
                        System.out.print("Seleccione una opción: ");
                        int subOption = scanner.nextInt();
                        scanner.nextLine(); // consume newline left-over
                        switch (subOption) {
                            case 1:
                                System.out.print("Ingrese la contraseña: ");
                                String enteredPassword = scanner.nextLine();
                                if (currentUser.getPassword().equals(enteredPassword)) {
                                    System.out.println("Inicio de sesión exitoso");
                                } else {
                                    System.out.println("Contraseña incorrecta");
                                }
                                break;
                            case 2:
                                // Volver al menú principal
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");


                case 3: // Opción para enviar un correo electrónico
                    System.out.print("Ingrese el destinatario del correo electrónico: ");
                    String recipient = scanner.nextLine();
                    System.out.print("Ingrese el asunto del correo electrónico: ");
                    String subject = scanner.nextLine();
                    System.out.print("Ingrese el cuerpo del correo electrónico: ");
                    String body = scanner.nextLine();
                    Email email = new Email(currentUser.getUsername(), recipient, subject, body);
                    UserAccount recipientUser = findUser(users, recipient);
                    if (recipientUser != null) {
                        recipientUser.receiveEmail(email);
                        System.out.println("Correo electrónico enviado exitosamente a " + recipient);
                    } else {
                        System.out.println("El destinatario no existe");
                    }
                    break;
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