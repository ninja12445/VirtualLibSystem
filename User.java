

/**
 * Project: Virtual Library System
 * Author: Tyana Rogers
 * Date: April 24, 2025
 * Description: The User class represents a user in the library system, managing their account and interactions with the system.
 */

public class User {
    private String username;
    private String password;
    private String email;

    // Default constructor
    public User() {
        this.username = "";
        this.password = "";
        this.email = "";
    }

    // Constructor with parameters
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}
