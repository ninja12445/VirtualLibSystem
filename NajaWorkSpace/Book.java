/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import java.util.*;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int edition;
    private ArrayList<String> genres; //uses arraylist directly
    private String synopsis;
    private boolean isAvailable;
    private ArrayList<String> contentWarnings;
    private Queue<String> waitlist; // Stores names or IDs of students
    private String callNumber;
    private String coverType; // e.g., paperback, digital, journal article
    private double lateFeePerDay;
    
    //constructor
    public Book(String title, String author, String isbn, int edition, ArrayList<String> genres, String synopsis,
                ArrayList<String> contentWarnings, String callNumber, String coverType, double lateFeePerDay) {
        if (!isValidISBN(isbn)) {
            throw new IllegalArgumentException("Invalid ISBN. Must be 10 or 13 digits.");
        }
        this.title = title;
        this.author = author;
        this.isbn= isbn;
        this.genres = new ArrayList<>(genres); //creates a copy if list is modified outside the book class
        this.synopsis= synopsis;
        this.isAvailable = true; //default: book is available when created
        this.contentWarnings = new ArrayList<>(contentWarnings);
        this.waitlist = new LinkedList<>();
        this.callNumber = callNumber;
        this.coverType = coverType;
        this.lateFeePerDay = lateFeePerDay;
    }
     // Validates 10 or 13 digit ISBN
    private boolean isValidISBN(String isbn) {
        return isbn.matches("\\d{10}|\\d{13}");
    }
    public boolean borrow(String userId, boolean acceptsWarnings) {
        if (!acceptsWarnings && !contentWarnings.isEmpty()) {
            System.out.println("Borrowing denied. You must accept content warnings to borrow this book.");
            return false;
        }
         if (isAvailable) {
            isAvailable = false;
            System.out.println(userId + " successfully borrowed the book.");
            return true;
        } else {
            waitlist.add(userId);
            System.out.println("Book is currently unavailable. " + userId + " added to the waitlist.");
            return false;
        }
    }
    public void returnBook() {
        if (!waitlist.isEmpty()) {
            String nextUser = waitlist.poll();
            System.out.println("Book is now assigned to next user in waitlist: " + nextUser);
            // In real system, notify the user here
        } else {
            isAvailable = true;
            System.out.println("Book returned and marked as available.");
        }
    }
    
    public double calculateLateFee(int daysLate) {
        return lateFeePerDay * daysLate;
    }
        
    //getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public ArrayList<String> getGenres() {
        return genres;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getEdition() {
    return edition;
    }
    public ArrayList<String> getContentWarnings() {
    return contentWarnings;
    }
    public String getCallNumber() {
    return callNumber;
    }
    public String getCoverType() {
    return coverType;
    }
    public double getLateFeePerDay() {
    return lateFeePerDay;
    }
    public Queue<String> getWaitlist() {
    return waitlist;
    }
    //setters
    public void setTitle(String title) {
        this.title= title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setGenres(ArrayList<String>genres) {
        this.genres = new ArrayList<>(genres);
    }
    public void setSynopsis (String synopsis) {
        this.synopsis = synopsis;
    }
    public void setAvailability (boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setCallNumber(String callNumber) {
    this.callNumber = callNumber;
    }
    public void setCoverType(String coverType) {
    this.coverType = coverType;
    }
    public void setLateFeePerDay(double lateFeePerDay) {
    this.lateFeePerDay = lateFeePerDay;
    }
    //marks the book as borrowed or available (toggle status)
    public void markAsBorrowedOrAvailable() {
        isAvailable = !isAvailable;
    }
    public void setEdition(int edition) {
    this.edition = edition;
    }
   
    
    //display full details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Genres: " + genres);
        System.out.println("Synopsis: " + synopsis);
        System.out.println("Content Warnings: " + (contentWarnings.isEmpty() ? "None" : contentWarnings));
        System.out.println("Call Number: " + callNumber);
        System.out.println("Cover Type: " + coverType);
        System.out.println("Late Fee Per Day: $" + lateFeePerDay);
        System.out.println("Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
}
