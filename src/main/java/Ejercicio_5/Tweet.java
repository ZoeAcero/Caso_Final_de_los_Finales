package Ejercicio_5;

import java.time.LocalDate;

public class Tweet {
    protected LocalDate time;
    protected String message;
    protected UserAccount sender;

    public String getMessage() {
        return this.message;
    }

    public Tweet(LocalDate time, String message, UserAccount sender) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message exceeds the maximum length of 140 characters");
        }
        this.time = time;
        this.message = message;
        this.sender = sender;
    }

    public Tweet(String text) {
        if (text.length() > 140) {
            throw new IllegalArgumentException("El tweet no puede tener más de 140 caracteres");
        }
        this.message = text;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "time=" + time +
                ", message='" + message + '\'' +
                ", sender=" + sender +
                '}';
    }

}
