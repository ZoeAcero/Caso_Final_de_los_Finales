package Ejercicio_5;

public class Retweet extends Tweet {
    private Tweet retweetedTweet;

    public Retweet(LocalDate time, String message, UserAccount sender, Tweet retweetedTweet) {
        super(time, message, sender);
        this.retweetedTweet = retweetedTweet;
    }
}
