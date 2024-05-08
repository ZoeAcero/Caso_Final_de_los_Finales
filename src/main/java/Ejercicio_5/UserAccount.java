package Ejercicio_5;

import java.util.*;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<Tweet> timeline;
    private Set<UserAccount> followers;
    private Set<UserAccount> following;
    private static String password;

    public List<Tweet> getTweets() {
        return this.tweets;
    }

    public String getPassword() {
        return this.password;
    }

    public UserAccount(String alias, String email, String password) {
        if (!Utils.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (!Utils.isValidAlias(alias)) {
            throw new IllegalArgumentException("Invalid alias");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.timeline = new ArrayList<>();
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public void follow(UserAccount other) {
        if (this.following.contains(other)) {
            throw new IllegalArgumentException("You are already following this user");
        }
        this.following.add(other);
        other.followers.add(this);
    }

    public void tweet(Tweet tweet) {
        this.tweets.add(tweet);
        for (UserAccount follower : this.followers) {
            follower.timeline.add(tweet);
        }
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "alias='" + alias + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static UserAccount fromString(String line) {
        String[] parts = line.split(",");
        String alias = parts[0];
        String email = parts[1];
        UserAccount user = new UserAccount(alias, email, password);
        return user;
    }


    public String getUsername() {
        return this.alias;
    }
}
