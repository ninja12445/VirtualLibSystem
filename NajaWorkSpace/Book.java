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
public class Book {
    private String title;
    private String author;
    private String isbn;
    private ArrayList<String> genres; //uses arraylist directly
    private String synopsis;
    private boolean isAvailable;
    
    //constructor
    public Book(String title, String author, String isbn, ArrayList<String> genres, String synopsis) {
        this.title = title;
        this.author = author;
        this.isbn= isbn;
        this.genres = new ArrayList<>(genres); //creates a copy if list is modified outside the book class
        this.synopsis= synopsis;
        this.isAvailable = true; //default: book is available when created
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
    //marks the book as borrowed or available (toggle status)
    public void markAsBorrowedOrAvailable() {
        isAvailable = !isAvailable;
    }
    //mark as borrowed
    public void borrow() {
        if(isAvailable) {
            isAvailable = false;
        } else {
            System.out.println("Book has already been checked out.");
        }
    }
    //mark as returned
    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
        } else {
            System.out.println("Book is available");
        }
    }
    //display full details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Genres: " + genres);
        System.out.println("Synopsis: " + synopsis);
        System.out.println("Status: " + (isAvailable ? "Available" : "Borrowed"));
    }
}
