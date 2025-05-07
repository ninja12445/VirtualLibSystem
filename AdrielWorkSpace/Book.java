
package app;

/**
 * Project: Virtual Library System
 * @author: Naja Pettigrew
 * @fix-contributor: Adriel Nguyen 
 * Date: 4/4/2025
 * Date working on: 5/5/2025, 6/5/2025, 7/5/2025
 * The Book class represents a book within the Virtual Library System. 
 * It stores detailed information about each book,
 * such as the title, author, ISBN, availability, and genres. 
 * This class provides methods for checking availability, borrowing, returning, and viewing book details.
 * Changes Made: remove return() and borrow() methods and move it into Library class, removed synopsis, try out multiple test cases for 
 * this class. 
 */


import java.util.ArrayList;
import java.util.List;
/*  
    Book title
    BookID (ISBN) 
    publicationYear - year publish
    tags - topic phrases
    available - ready for user to borrow or no
    ratings - average user rating of the book 
    reviews - submit review for books 
    average rating = (sum from from 1 - 5) / number of ratings; 
    Formula to compute: 3 + 4 + 5 / 3 (rate three times). I think will make it applicable for all books 
    
*/

public class Book {
    private String isbn;
    private String title;
    private String author; 
    private ArrayList <String> genres; //uses arraylist directly
    private boolean available;
    private int publicationYear;
    private List<String> tags;
    private List<String> reviews;
    private List<List<String>> undo = new ArrayList<>();
    private List<List<String>> redo = new ArrayList<>();
    private List<Integer> ratings;
    private static final int TAGS_LIMIT = 3;
    private static final int REVIEWS_LIMIT = 5;
    private static final int RATINGS_LIMIT = 5;
    private String[] tagsArr;
    private String[] reviewsArr;
    private int[] ratingsArr;
    private int reviewsCount;
    private int tagsCount;
    private int ratingsCount;
    private double rate;
    private double totalRatingScore;

    // constructor
    public Book () {
        isbn = "";
        title = "";
        author = "";
        this.genres = new ArrayList<>();
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
        rate = 0.0;
        totalRatingScore = 0.0;

    }
    
    /**
     * @param isbn
     * @param title
     * @param author
     * @param genres
     * @param available
     * @param publicationYear
     * @param tags
     * @param reviews
     * @param ratings
     */
    
    public Book (String isbn, String title, String author, ArrayList<String> genres, boolean available, int publicationYear,List<String> tags, List<String> reviews, List<Integer> ratings) {
        this.genres = new ArrayList<>(genres); //creates a copy if list is modified outside the book class

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
        
        this.genres.add("Fantasy");
        this.genres.add("Adventure");
        this.genres.add("History");
        
        
     
        

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
    
    public double getAvgRating() {
        if (ratingsCount == 0) 
            return 0.0;
        return (double) totalRatingScore / ratingsCount;
    }
    
    // ----- Setters -----
    

    
    public void setAvailable(boolean a) {
        available = a;
    }
    
    @Override // Minor change: output display into this. 
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nISBN: %s\nGenres: %s\nStatus: %s", title, author, isbn, genres,
                available ? "Available" : "Borrowed");
    }
  
    // cannot be more than current year and below zero
    public void setPublicationYear (int year) {
        if (year > 2025 || year < 0){
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
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Error: Review cannot be null or empty.");
        return;
    }

        if (reviews.size() >= REVIEWS_LIMIT) {
            System.out.println("Limit reached. Cannot add more reviews.");
            return;
        }

        String trimmedReview = review.trim();
      
        
        undo.add(new ArrayList<> (reviews));
        redo.clear();
        
        reviews.add(trimmedReview);
        System.out.println("Review added: " + trimmedReview);
       
    }
    

    
    public void displayReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews are available at the moment.");
            
        }
        
        System.out.println("User Review: ");
        for (String r : reviews) {
            System.out.println(" " + r);
        }
    }
    
    
    
    public void addRatings(int ratings) {
        
        if (ratings < 1 || ratings > 5) {
            System.out.println("Invalid rating value" + ".Must be between 1 and 5");
        } 
        
        if (ratingsCount >= RATINGS_LIMIT) {
            System.out.println("Limits Reached. Cannot add more ratings! " + ratings);
        }   
        
        totalRatingScore += ratings;
        ratingsCount++;
        
        System.out.println("Add rating: " + ratings);
        
    }
    
    public void undo() {
        if (undo.isEmpty()) {
            System.out.println("No undo state.");
            return;
        }
        
        redo.add(new ArrayList<>(reviews));
        
        reviews = undo.remove(undo.size()-1);
        System.out.println("Successfully undo");
    }
    
    
    public void redo() {
        if (redo.isEmpty()) {
            System.out.println("No redo state.");
        }
        
        undo.add(new ArrayList<>(reviews));
        reviews = redo.remove(redo.size()-1);
        System.out.println("Successfully redo");
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
        ArrayList <String> genres = new ArrayList<>();
        genres.add("Mystery"); //add mystery genre as place holder
        genres.add("Thriller");
        genres.add("Philosophy");
        genres.add("Biography");
    
        Book firstBook = new Book("12345", "Book1", "Author1", new ArrayList<>(List.of("Fantasy", "Adventure", "History")), 
                true, 2020, List.of(), List.of(), List.of());
        System.out.println(firstBook);
        firstBook.addTag("hello");
        firstBook.addRatings(3);
        firstBook.addReview("This is a good book");
        firstBook.addRatings(4);
        firstBook.addRatings(5);
        System.out.println("Average Rating: " + firstBook.getAvgRating());
        firstBook.undo();
        firstBook.displayReviews();
        firstBook.redo();
        firstBook.displayReviews();
        
        System.out.println();
        
        for (String g : firstBook.getGenres()) {
            System.out.println(g);
        }
       
        
    }
    
}

/*
================ PROGRAM OUTPUT ==============

Title: Book1
Author: Author1
ISBN: 12345
Genres: [Fantasy, Adventure, History, Fantasy, Adventure, History]
Status: Available
Add rating: 3
Review added: This is a good book
Add rating: 4
Add rating: 5
Average Rating: 4.0
Successfully undo
No reviews are available at the moment.
User Review: 
Successfully redo
User Review: 
 This is a good book

Fantasy
Adventure
History
Fantasy
Adventure
History

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

Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "this.genresWord" is null
	at app.Book.<init>(Book.java:119)
	at app.Book.main(Book.java:338)
*/
