
package app;

/**
 *
 * Class: Book
 * Changes made, add tags, reviews, ratings, publication year, remodify constructor, parameterized constructor, 
 * 
 */

/**
 * Project: Virtual Library System
 * @author: Naja Pettigrew
 * @fix-contributor: Adriel Nguyen 
 * Date: 4/4/2025
 * Date working on: 5/5/2025
 * The Book class represents a book within the Virtual Library System. 
 * It stores detailed information about each book,
 * such as the title, author, ISBN, availability, and genres. 
 * This class provides methods for checking availability, borrowing, returning, and viewing book details.
 * Changes Made: remove return() and borrow() methods and move it into Library class, 
 */
import java.util.ArrayList;
import java.util.List;
/*
Book: isbn, title, author, genres, synopsis, status
*/
public class Book {
    private String isbn;
    private String title;
    private String author; 
    private ArrayList <String> genres; //uses arraylist directly
    private String synopsis;
    private boolean available;
    private int publicationYear;
    private List<String> tags;
    private List<String> reviews;
    private List<Integer> ratings;
    private static final int TAGS_LIMIT = 5;
    private static final int REVIEWS_LIMIT = 5;
    private static final int RATINGS_LIMIT = 5;
    private String[] tagsArr;
    private String[] reviewsArr;
    private int[] ratingsArr;
    private int reviewsCount;
    private int tagsCount;
    private int ratingsCount;
    
    // constructor
    public Book () {
        isbn = "";
        title = "";
        author = "";
        this.genres = new ArrayList<>();
        this.synopsis = "";
        this.available = true;
        this.publicationYear = 0;
        this.tags = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.ratings = new ArrayList<>();
        tagsArr = new String[TAGS_LIMIT];
        reviewsArr = new String[REVIEWS_LIMIT];
        ratingsArr = new int[RATINGS_LIMIT];
        reviewsCount = 0;
        tagsCount = 0;
        ratingsCount = 0;
        
    }
    
    /**
     * @param isbn
     * @param title
     * @param author
     * @param genres
     * @param synopsis
     * @param available
     * @param publicationYear
     * @param tags
     * @param reviews
     * @param ratings
     */
    
    public Book (String isbn, String title, String author, ArrayList<String> genres, String synopsis, boolean available, 
            int publicationYear,List<String> tags, List<String> reviews, List<Integer> ratings) {
        this.genres = new ArrayList<>(genres); //creates a copy if list is modified outside the book class
        this.synopsis = synopsis;
        this.available = true; //default: book is available when created
        this.publicationYear = publicationYear;
        this.tags = new ArrayList<>(tags);
        this.reviews = new ArrayList<>(reviews);
        this.ratings = new ArrayList<>(ratings);
        validateISBN(isbn, "ISBN");
        validateTitle(title, "Title");
        validateAuthor(author, "Author");
        this.isbn = isbn.trim();
        this.title = title.trim();
        this.author = author.trim(); 
        tagsArr = new String[TAGS_LIMIT];
        reviewsArr = new String[REVIEWS_LIMIT];
        ratingsArr = new int[RATINGS_LIMIT];
        reviewsCount = 0;
        tagsCount = 0;
        ratingsCount = 0;
    }
    
    // ---- Getters ------
    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public ArrayList<String> getGenres() {
        return new ArrayList<>(genres);
    }
    
    public String getSynopsis() {
        return synopsis;
    }
    
    public boolean isAvailable() {
        return available; 
    }
    
    public int getpublicationYear() {
        return publicationYear;
    }
    
    public List<String> getTags() {
        return new ArrayList<>(tags);
    }
    
    public List<String> getReviews() {
        return new ArrayList<>(reviews);
    }
    
    public List<Integer> getRatings() {
        return new ArrayList<> (ratings);
    }
    
    // ----- Setters -----
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    public void setAvailable(boolean a) {
        available = a;
    }
    
    @Override // Minor change: output display into this. 
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nISBN: %s\nGenres: %s\nSynopsis: %s\nStatus: %s", title, author, isbn, genres,
                synopsis, available ? "Available" : "Borrowed");
    }
  
    
    public void setPublicationYear (int year) {
        if (year > 2026 || year < 0){
            throw new IllegalArgumentException("Unknown publication year");
        }
        this.publicationYear = year;
    }
    
    public void setTags(List<String> tags) {
        this.tags = new ArrayList<>(tags);
    }
    
    public void setReviews(List<String> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }
    
    public void setRatings(List<Integer> ratings) {
        this.ratings = new ArrayList<>(ratings);
        
    }
    
    public void addTag(String tag) {
        if (tag == null) {
            System.out.println("Cannot insert null tag in this place");
        }
        
        String trimmedTag = tag.trim();
        
        if(trimmedTag.isEmpty()) {
            System.out.println("Error, user cannot add an empty tag");
        }
        
        if (tagsCount >= TAGS_LIMIT) {
            System.out.println("Limits Reached. Cannot add more tag! " + trimmedTag);
        }   
        
        tagsArr[tagsCount] = trimmedTag;
        tagsCount++;
        
    }
    
    public void addReview(String review) {
        if (review == null) {
            System.out.println("Cannot insert null review in this place");
        }
        
        String trimmedReview = review.trim();
        
        if(trimmedReview.isEmpty()) {
            System.out.println("Error, user cannot add an empty review");
        }
        
        if (reviewsCount >= REVIEWS_LIMIT) {
            System.out.println("Limits Reached. Cannot add more review! " + trimmedReview);
        }   
        
        reviewsArr[reviewsCount] = trimmedReview;
        reviewsCount++;
        
    }
    
    public void addRatings(int ratings) {
        
        if (ratings < 1 || ratings > 5) {
            System.out.println("Invalid rating value" + ".Must be between 1 and 5");
        }

        
        if (ratingsCount >= RATINGS_LIMIT) {
            System.out.println("Limits Reached. Cannot add more tag! " + ratings);
        }   
        
        ratingsArr[ratingsCount] = ratings;
        ratingsCount++;
        //for debug log
        System.out.println("Add rating: " + ratings);
        
    }
    /* Compare two book objects by ISBN validation
     * @param different book to compare
     * @return ture if two books are having the same ISBN
     */
    
    public boolean compare(Book different) {
        if (different == null)
            return false;
        return this.isbn.equals(different.isbn);
    }
    
    
    private void validateTitle (String title, String titlField){
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(titlField + " cannot be empty or null");
        }
    }
    
    private void validateAuthor (String author, String authField){
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(authField + " cannot be empty or null");
        }
    }
   
    private void validateISBN (String isbn, String isbnField){
        if (isbn== null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException(isbnField + " cannot be empty or null");
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> genres = new ArrayList<>();
        Book firstBook = new Book("12345", "Book1", "Author1", genres, "", true, 2020, List.of(), List.of(), List.of());
        System.out.println(firstBook);
        firstBook.addTag("hello");
        firstBook.addRatings(5);
        firstBook.addReview("This is a good book");
        
        
    }
    
}

/*
Bug Found & Fixed : 30
Observe: encounter null pointer reference twice during test. 
TODO: REMINDER: move into Library class
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

===============================================
User class 
private ArrayList<String> borrowedISBNs;
private static final int max = 5;

public boolean canBorrow() {
    return borrowedISBNs.size() < max;
}

handle display later 
===============================================
LibraryUI {
    public void displayBookDetails(Book book) {
        System.out.println(book.toString());
    } 
}
===============================================
Javadoc on class and every public method 
params, return, throw exceptions 

*/