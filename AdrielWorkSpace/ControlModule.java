
package max;

/**
 *
 * Copyright (C) 2025 Adriel Nguyen
 * make it into three phrases 
 * Phrase 1: brainstorm pseudocode
 * Phrase 2: begin to code
 * Phrase 3: Debug + test algorithms
 * What's changed: rename class name from ControlMechanics to ControlModule, applied for other 3 class.
 * Last Modified: 2/5/2025 11:24 AM
 */
public class ControlMechanics {
    // 1. make [testing] functions as void 
    // 2. try to see if it a void function or return types, int, String, arrays, object, chars 
    // 3. pseudocode 

    
    //1. insertOneBook(), user want to add a book, one by one to our collection 
    // aim: user can successfully insert book any where in the collection 
    // have an input for the book details. Add Position 
    public void insertOneBook(String[] Collection) {
        // questions to brainstorm 
        // can it insert more than one book ? no 
        // can it insert freely at front, middle, end in the array ? yes 
        
        /*
        creates a function name insertOneBook accepts three params 
        + bookArray (existing array of books) 
        + newBook (book object to insert) 
        + position (where to insert it) 
        
        Input validation: 
        make sure newBook is an object
        Check if position is valid, 'start' , 'end' or a valid index number
        
        duplicate check, check if the book already exists in the array to prevent duplicates. 
        
        if position is start , insert at index 0. 
        if position is end, insert at the end of the array 
        if position is a number, within bounds 
      
        throws errors for invalid input.
        documentation: add comments explain the func purpose, params and return value 
        */
    }
    
    
    
    // 2. removeOneBook(), user then wants to remove a book, one by one from our collection
    public void removeOneBook(String[] Collection) {
       // functionality: 
       // user will successfuly remove a book from the collections
       // 1. find the book
       // 2. remove the book
       // 3. sort back book collection 
        
    }
    
    // 3. addBookToCollection()  ~ add many books at a single time
    public void addBookToCollection(String[] Collection) {
       // functionality : 
       // user will successfully add many books from the collections
       // 1. go through each book 
       // 2. add each book to collection         
       // 3. sort back the collection
    }
    
    // 4. removeBookFromCollection()~ delete many books at a single time    
    public void removeBookFromCollection(String[] Collection) {
       // functionality: 
       // user will successfully remove many books from the collections
       // 1. go through each book 
       // 2. if the specified book is still there
       // 3. sort back the collection
    }
    
    // 5. undoLastBookRemove(), restore last deletion  
    public void undoLastBookRemove(){
       // functionality:
       // user will undo book removal 
       // 1. trace back the previous book 
       // 2. bring back the action (redo phrase, whether user has accidentally removed / add)
        
    }
    
    // 6. filterAlphabeticalOrder(), filter book alphebetical order
    public void filterAlphabeticalOrder() {
       // functionality: 
       // book are sorted in alphabet order 
       // 1. sorted collections
        
    }
    
    // 7. filterYearRange() - filter books within specific published year range
    public void filterYearRange() {
       // functionality: 
       // user will successfully filter to find the books according to the publication year 
       // 1. went through each book 
       // 2. if the specified book is bound between range [specified by the user]
       // 3. reuturn books that matching within those threshold 
        
    }
    
    // 8. filterBooksByTag()- filter books to match when they contain a specific tag  
    public void filterBooksByTag() {
       // functionality: 
       // user will successfully filter books contains tags  
       // 1. went through each book 
       // 2. if the book has included tag(s) that the user is looking for 
       // 3. return books that has those tags.
        
    }
    
    // 9. filterBooksByAvailability()

    public void filterBooksByAvailability() { 
       // functionality: 
       // user will successfully filter the availability status 
       // 1. went through each book 
       // 2. verify status 
       // 3. return matching books 
        
    }
    
    // 10. batchFilterDeletion() - remove all books when it satisfy certain conditions or threshold    
    public void batchFilterDeletion()  {
       // functionality: 
       // user will successfully remove books which has conditions attach to it
       // 1. check conditions each book
       // 2. remove them
        
    }
    
    //12.toggleBookAvailabilityStatus() - (ready to borrow / not ready)
    public void toggleBookAvailabilityStatus() { 
       // functionality: 
       // user will successfully look for the availability status of the book. 
       // 1. user can the book title, isbn and other necessary datas
       
    }    
    
    
    
    
    
    
    
/*    
    generate a random string and alphanumeric random string 
    
    Write File, use FileWriter class to write data to a file. 

    
    getter method returns the copy of class members 
    
    class members are initialized using constructor using this keyword 
    
    Format : 
    Book Title:
    string
    Author: 
    string
    ISBN: 
    strings
    
    
    
    ===================
    Test Strategy 
    
    insert test: 
    1. verify new book can be added to empty collection 
    2. verify insert a book with an ISBN already exists in collection 
    3. verify book with same title / author but different ISBNs can be added successfully 
    4. verify allow case sensitivity 
    5. test for invalid input, inserting a book with missing attributes, can handle it (no title, no isbn) 
    6. verify different datatype, ISBN as an integer instead of a string, verify the response. 
    
    
    remove test:
    1. verity function does nothing when collection empty 
    2. verify ensure becomes empty after removing its only item 
    3. confirm the collection size decreases by one when an item is removed
    4. Item Not present: check that collection remains unchanged if the item isn't found 
    5. only first occurence of item is completely removed 
    6. Edge Case Test: min or max possible item values 
    7. Invalid Item: Handle cases where item type doesn't match the collection 
    8. Null item. 
    9. Assess performance with a large dataset. 
    10. Items with special characters 
    11. case sensitivity 
    12. null collection test 
    
*/    
    
    
}
