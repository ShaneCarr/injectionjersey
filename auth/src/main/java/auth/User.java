package auth;

public record User(String username) {

    public String getUsername() {
        return this.username;
    }
}