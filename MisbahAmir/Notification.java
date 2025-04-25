
package virtualLibrarySystem;

/**
 * Project: Virtual Library System
 * Author: Misbah Amir
 * Date: 4/25/2025
 * The Notification class represents a notification sent to a user within the Virtual Library System. 
 * It stores information about the user, message, and timestamp.
 * This class provides methods to display the notification and convert it to a string for saving to a file.
 */

import java.time.LocalDateTime;

public class Notification {
    private String userId;
    private String message;
    private LocalDateTime timestamp;

    // Constructor to create a new notification with current timestamp
    public Notification(String userId, String message) {
        this.userId = userId;
        this.message = message;
        this.timestamp = LocalDateTime.now(); // Set timestamp to current time
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Method to display the notification in the console
    public void display() {
        System.out.println("[" + timestamp + "] Notification for User " + userId + ": " + message);
    }

    // Converts the notification to a string for saving to a file
    @Override
    public String toString() {
        return "[" + timestamp + "] Notification for User " + userId + ": " + message;
    }
}
