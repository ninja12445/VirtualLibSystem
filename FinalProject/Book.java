
package virtualLibrarySystem;

/**
 * Project: Virtual Library System
 * @author Naja Pettigrew
 * Date: 4/24/2025
 * The Book class represents a book within the Virtual Library System. 
 * It stores detailed information about each book,
 * such as the title, author, ISBN, availability, and genres. 
 * This class provides methods for checking availability, borrowing, returning, and viewing book details.
 */
import java.util.ArrayList;

/**
 * Represents a book in the library system.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private ArrayList<String> genres;
    private String synopsis;
    private boolean available;
    private User borrowedBy;

    /**
     * Creates a new book with the specified details.
     * 
     * @param title    The title of the book
     * @param author   The author of the book
     * @param isbn     The ISBN of the book (unique identifier)
     * @param genres   List of genres the book belongs to
     * @param synopsis A brief description of the book
     */
    public Book(String title, String author, String isbn, ArrayList<String> genres, String synopsis) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genres = genres;
        this.synopsis = synopsis;
        this.available = true;
        this.borrowedBy = null;
    }

    /**
     * Gets the title of the book.
     * 
     * @return The book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     * 
     * @return The book author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the ISBN of the book.
     * 
     * @return The book ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets the list of genres the book belongs to.
     * 
     * @return ArrayList of genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * Gets the synopsis of the book.
     * 
     * @return The book synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Checks if the book is available for borrowing.
     * 
     * @return true if available, false if borrowed
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Gets the user who has borrowed this book.
     * 
     * @return The user who borrowed the book, or null if not borrowed
     */
    public User getBorrowedBy() {
        return borrowedBy;
    }

    /**
     * Sets the user who is borrowing this book and marks it as unavailable.
     * 
     * @param user The user borrowing the book
     */
    public void setBorrowedBy(User user) {
        this.borrowedBy = user;
        this.available = false;
    }

    /**
     * Marks the book as returned and available.
     */
    public void returnBook() {
        this.borrowedBy = null;
        this.available = true;
    }

    /**
     * Gets all genres of the book as a comma-separated string.
     * 
     * @return String representation of genres
     */
    public String getGenresAsString() {
        if (genres.isEmpty()) {
            return "No genres assigned";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            result.append(genres.get(i));
            if (i < genres.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    /**
     * Returns a string representation of the book.
     * 
     * @return String representation including title, author, ISBN, genres and availability
     */
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (ISBN: " + isbn + ") - Genres: " + getGenresAsString() +
                (available ? " [AVAILABLE]" : " [BORROWED]");
    }
}