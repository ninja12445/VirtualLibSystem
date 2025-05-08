
package virtualLibrarySystem;

/* Class: Library
 * Author: Adriel   
 * Date work on : 8/5/2025 
 * Have found a total of more than 50 bugs total
 * The library class creates a collections of books, user and notifications
 */

import java.util.ArrayList;

/**
 * Represents the library that manages books and users.
 */
public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Notification> notifications;

    /**
     * Creates a new library with empty collections of books, users, and notifications.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    /**
     * Gets the list of all books in the library.
     * 
     * @return ArrayList of all books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Gets the list of all users registered in the library.
     * 
     * @return ArrayList of all users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Gets the list of all notifications in the library system.
     * 
     * @return ArrayList of all notifications
     */
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Adds a book to the library.
     * 
     * @param book The book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Registers a user in the library system.
     * 
     * @param user The user to register
     */
    public void registerUser(User user) {
        users.add(user);
    }

    /**
     * Finds a user by their ID.
     * 
     * @param userId The ID of the user to find
     * @return The user with the specified ID, or null if not found
     */
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a book by its ISBN.
     * 
     * @param isbn The ISBN of the book to find
     * @return The book with the specified ISBN, or null if not found
     */
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Creates a new notification for a user.
     * 
     * @param userId  The ID of the user to notify
     * @param message The notification message
     */
    public void createNotification(String userId, String message) {
        Notification notification = new Notification(userId, message);
        notifications.add(notification);
        User user = findUserById(userId);
        if (user != null) {
            user.addNotification(message);
        }
    }

    /**
     * Gets all notifications for a specific user.
     * 
     * @param userId The ID of the user
     * @return ArrayList of notifications for the user
     */
    public ArrayList<Notification> getUserNotifications(String userId) {
        ArrayList<Notification> result = new ArrayList<>();
        for (Notification notification : notifications) {
            if (notification.getUserId().equals(userId)) {
                result.add(notification);
            }
        }
        return result;
    }

    /**
     * Allows a user to borrow a book.
     * 
     * @param user The user borrowing the book
     * @param book The book to borrow
     */
    public void borrowBook(User user, Book book) {
        if (book.isAvailable()) {
            if (user.canBorrowMore()) {
                user.borrowBook(book);
                createNotification(user.getUserId(), "You have borrowed: \"" + book.getTitle() + "\"");
            } else {
                createNotification(user.getUserId(), "Unable to borrow: \"" + book.getTitle() + "\" - Maximum borrow limit reached.");
            }
        } else {
            createNotification(user.getUserId(), "Unable to borrow: \"" + book.getTitle() + "\" - Book unavailable.");
        }
    }

    /**
     * Allows a user to return a book.
     * 
     * @param user The user returning the book
     * @param book The book to return
     */
    public void returnBook(User user, Book book) {
        if (user.hasBorrowedBook(book)) {
            user.returnBook(book);
            createNotification(user.getUserId(), "You have returned: \"" + book.getTitle() + "\"");
        }
    }

    /**
     * Seeds the library with initial data.
     */
    public void seedLibraryData() {
        // Add books
        ArrayList<String> fiction = new ArrayList<>();
        fiction.add("Fiction");
        fiction.add("Mystery");
        addBook(new Book("The Silent Patient", "Alex Michaelides", "9781250301697", fiction, 
                "A psychological thriller about a woman's act of violence against her husband."));

        ArrayList<String> sciFi = new ArrayList<>();
        sciFi.add("Science Fiction");
        addBook(new Book("Dune", "Frank Herbert", "9780441172719", sciFi, 
                "Set in the distant future amidst a feudal interstellar society."));

        ArrayList<String> fantasy = new ArrayList<>();
        fantasy.add("Fantasy");
        addBook(new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227", fantasy, 
                "The tale of a hobbit's journey to the Lonely Mountain."));

        ArrayList<String> classics = new ArrayList<>();
        classics.add("Classics");
        classics.add("Fiction");
        addBook(new Book("Pride and Prejudice", "Jane Austen", "9780141439518", classics, 
                "A classic novel about manners, upbringing, and marriage in the society of early 19th-century England."));

        ArrayList<String> biography = new ArrayList<>();
        biography.add("Biography");
        addBook(new Book("Steve Jobs", "Walter Isaacson", "9781451648539", biography, 
                "The life of the technology entrepreneur and Apple co-founder."));

        ArrayList<String> selfdevelopment = new ArrayList<>();
        selfdevelopment.add("Self-Development");
        addBook(new Book("Atomic Habits", "James Clear", "9780735211292", selfdevelopment, 
                "Tiny changes for remarkable results in building better habits."));

        ArrayList<String> history = new ArrayList<>();
        history.add("History");
        addBook(new Book("Sapiens", "Yuval Noah Harari", "9780062316097", history, 
                "A brief history of humankind."));

        ArrayList<String> philosophy = new ArrayList<>();
        philosophy.add("Philosophy");
        addBook(new Book("Meditations", "Marcus Aurelius", "9780812968255", philosophy, 
                "A series of personal writings by the Roman Emperor Marcus Aurelius."));

        ArrayList<String> science = new ArrayList<>();
        science.add("Science");
        addBook(new Book("A Brief History of Time", "Stephen Hawking", "9780553380163", science, 
                "An exploration of cosmology and the universe."));

        ArrayList<String> poetry = new ArrayList<>();
        poetry.add("Poetry");
        addBook(new Book("Milk and Honey", "Rupi Kaur", "9781449474256", poetry, 
                "A collection of poetry and prose about survival, the experience of violence, love, and femininity."));

        ArrayList<String> thriller = new ArrayList<>();
        thriller.add("Thriller");
        addBook(new Book("Gone Girl", "Gillian Flynn", "9780307588371", thriller, 
                "A thriller about a woman who mysteriously disappears on her wedding anniversary."));

        ArrayList<String> romance = new ArrayList<>();
        romance.add("Romance");
        addBook(new Book("The Notebook", "Nicholas Sparks", "9781455582877", romance, 
                "A love story about a couple who are separated by World War II, then passionately reunited years later."));

        ArrayList<String> mystery = new ArrayList<>();
        mystery.add("Mystery");
        addBook(new Book("The Da Vinci Code", "Dan Brown", "9780307474278", mystery, 
                "A mystery thriller novel that follows symbologist Robert Langdon."));

        ArrayList<String> youngAdult = new ArrayList<>();
        youngAdult.add("Young Adult");
        addBook(new Book("The Hunger Games", "Suzanne Collins", "9780439023481", youngAdult, 
                "A dystopian novel set in a post-apocalyptic society."));

        ArrayList<String> horror = new ArrayList<>();
        horror.add("Horror");
        addBook(new Book("It", "Stephen King", "9781501142970", horror, 
                "A horror novel about a malevolent entity that exploits the fears of its victims."));

        // Add users
        registerUser(new User("Alice Smith", "user101"));
        registerUser(new User("Bob Johnson", "user102"));
        registerUser(new User("Admin", "admin"));
    }
}