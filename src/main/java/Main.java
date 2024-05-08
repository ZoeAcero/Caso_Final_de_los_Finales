import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Ejercicio_5.UserAccount;

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
}
