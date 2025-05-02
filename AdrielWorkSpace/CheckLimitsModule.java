package max;

/**
 *
 * Copyright (C) 2025 Adriel Nguyen
 * make it into three phrases 
 * Phrase 1: brainstorm pseudocode
 * Phrase 2: begin to code
 * Phrase 3: Debug + test algorithms
 * What's changed: rename class name from MaxBorrowLimits to CheckLimitsModule
 * Last Modified: 2/5/2025 11:27 AM
 */

public class MaxBorrowLimits {
    private int maxNumOfBooksBorrowed;
    private String[] bookNames = new String[100]; // for encapsulation & code obfuscation
    
   
    public MaxBorrowLimits(String [] collection, int maxNumOfBooksBorrowed) {
        this.maxNumOfBooksBorrowed = maxNumOfBooksBorrowed;
        
        if (collection != null) 
            this.bookNames = collection;
        else 
            this.bookNames = new String[0];
   
    }
    
    /**
     * Gets number of books the user can possibly borrow / withdraw from the virtual library
     * @return max numbers of books are allowed to borrow (must not pass threshold for validation           check)
     */
    
    public int getBorrowLimits(){
        return maxNumOfBooksBorrowed; // purpose: accessing private int value
    }
    
    /**
     * Sets max number of book user can borrowed 
     * @param l : limit
     * pass as max from main into this 
     */
    public void setBorrowLimits(int l) {
        this.maxNumOfBooksBorrowed = l; // update instance variable with new limitations.
    }

    
    public void setBorrowLimits() {
        // in main: automatically see this prints out when the user selected book is 0
        if (bookNames.length == 0 || bookNames == null) {
            System.out.println("User have not selected any books to borrow. ");
            return;
        }
        
        if (bookNames.length > this.maxNumOfBooksBorrowed) {
            System.out.println("You are only allowed to borrow up to 5 books at the same time");
            System.out.printf("You have borrowed %d more than limit.\n", (bookNames.length - this.maxNumOfBooksBorrowed));
            System.out.println("Please go ahead reselecting the number of books you have chosen. ");
        } else {
            for (String bookName : bookNames) {
                System.out.println(bookName);
            }
        }
    }
    
    
    
}
