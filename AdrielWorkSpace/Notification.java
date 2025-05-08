
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
import java.time.format.DateTimeFormatter;

/**
 * Represents a notification in the library system.
 */
public class Notification {
    private String userId;
    private String message;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Creates a new notification for a user with a message.
     * 
     * @param userId  The ID of the user to notify
     * @param message The notification message
     */
    
    public Notification(String userId, String message) {
        this.userId = userId;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Gets the ID of the user this notification is for.
     * 
     * @return The user ID
     */
    
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the notification message.
     * 
     * @return The message
     */
    
    public String getMessage() {
        return message;
    }

    /**
     * Gets the timestamp when the notification was created.
     * 
     * @return The timestamp
     */
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Displays the notification to the console.
     */
    
    public void display() {
        System.out.println("[" + timestamp.format(formatter) + "] Notification for User " + userId + ": " + message);
    }

    /**
     * Returns a string representation of the notification.
     * 
     * @return String representation including timestamp, user ID, and message
     */
    
    @Override
    public String toString() {
        return "[" + timestamp.format(formatter) + "] User " + userId + ": " + message;
    }
}