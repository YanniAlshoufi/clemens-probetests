package at.htlleonding.fraumantis.model;

public class FmtUser {
    private final String username;

    public FmtUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }
}
