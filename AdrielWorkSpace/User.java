
package virtualLibrarySystem;

/**
 * Project: Virtual Library System
 * Author: Tyana Rogers
 * Date: April 24, 2025
 * Description: The User class represents a user in the library system, managing their account and interactions with the system.
 */

import java.util.ArrayList;

/**
 * Represents a user in the library system.
 */

public class User {
    /** Maximum number of books a user can borrow at one time */
    public static final int MAX_BORROW_LIMIT = 5;

    private String name;
    private String userId;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<String> notifications;

    /**
     * Creates a new user with the specified name and ID.
     * 
     * @param name   The name of the user
     * @param userId The unique identifier for the user
     */
    
    
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    /**
     * Gets the name of the user.
     * 
     * @return The user's name
     */
    
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the user.
     * 
     * @return The user's ID
     */
    
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the list of books borrowed by the user.
     * 
     * @return ArrayList of borrowed books
     */
    
    
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * Gets the list of notifications for the user.
     * 
     * @return ArrayList of notification messages
     */
    
    
    public ArrayList<String> getNotifications() {
        return notifications;
    }

    
    /**
     * Adds a notification message for the user.
     * 
     * @param message The notification message
     */
    
    
    public void addNotification(String message) {
        notifications.add(message);
    }

    /**
     * Allows the user to borrow a book.
     * 
     * @param book The book to borrow
     */
    
    public void borrowBook(Book book) {
        if (borrowedBooks.size() < MAX_BORROW_LIMIT) {
            borrowedBooks.add(book);
            book.setBorrowedBy(this);
        }
    }

    /**
     * Allows the user to return a borrowed book.
     * 
     * @param book The book to return
     */
    
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    /**
     * Checks if the user can borrow more books.
     * 
     * @return true if the user can borrow more books, false otherwise
     */
    
    public boolean canBorrowMore() {
        return borrowedBooks.size() < MAX_BORROW_LIMIT;
    }

    /**
     * Gets the number of books the user can still borrow.
     * 
     * @return The number of books that can still be borrowed
     */
    
    public int getBooksToBorrowLimit() {
        return MAX_BORROW_LIMIT - borrowedBooks.size();
    }

    /**
     * Checks if the user has borrowed a specific book.
     * 
     * @param book The book to check
     * @return true if the user has borrowed the book, false otherwise
     */
    
    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    /**
     * Clears all notifications for the user.
     */
    
    public void clearNotifications() {
        notifications.clear();
    }
}