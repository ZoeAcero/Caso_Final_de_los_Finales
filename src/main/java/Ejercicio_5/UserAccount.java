package Ejercicio_5;

import java.util.*;

public class UserAccount {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<Tweet> timeline;
    private Set<UserAccount> followers;
    private Set<UserAccount> following;

    public UserAccount(String alias, String email) {
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
}
