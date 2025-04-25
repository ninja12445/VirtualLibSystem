/*
 *
 * Copyright (C) 2025 Adriel Nguyen
 *
Problem statement 
Lib clasS: user can only borrow maximum 5 books at one time, so the user can only borrow one book at once. Will show warning msg if they go overlimits that already set forth.  



class Library, i'm thinking about create another class

1. insertOneBook(), user want to add a book, one by one to our collection 
2. removeOneBook(), user then wants to remove a book, one by one from our collection ~ automatically rank in alphabetical order 
can be add at beginning, middle, end.
3. keywordSearch(input String) - search byKeyword
4. recallAvailableBooks() ~ books are ready for the student to borrow
5. recallBorrowedBooks()  ~ book are marked as in use by student or others 
6. addBookToCollection()  ~ add many books at a single time
7. removeBookFromCollection()~ reduce many books 
8. Additional search Title begins with 
9. Additional search Title equals 
10. Additional search contains 

11. speed search 
12. filtering, alphebetical order 
13. display book covers 
14. smart search, the program should be intelligent enough to guess the user 
intention. "Did you mean ... ? " (suggestion)
15. automatically find other details about the book user trying to find, warn user if insert a book twice
16. use predictive order allocation to solve the problem statement, check what books the virtual library have and decide who get them base on the book they ordered. Make sure the process is just.
17. auto complete search + inverted index search (find one word(s), phrases, boolean) 
18. 
19.
20.
 To be added
21.
22.
23.
24.
25.
26.
27.
28.
29.
30

arrays 
inheritance pg 427 
class definition pg 174
write to a text file pg 584 
array list class pg 766
hash table with chaining pg  872 
sets pg 877 
trees pg 884 
intelligent keyword idea to do further research: branching prediction
class 173 - 304
*/
public class Library {

    public static void main(String[] args) {
        
        int [] maxBorrowLimits = new int [5]; // user can only borrow 5 books; 
        String[] bookNames = {"0"};
        /*
        
        */
        if (bookNames.length > maxBorrowLimits.length) {
            System.out.println("You are only allowed to borrow up to 5 books at the same time");
            System.out.printf("You have borrowed %d more than limit.\n", Math.abs(bookNames.length - maxBorrowLimits.length));
            System.out.println("Please go ahead reselecting the number of books you have chosen. ");
        } else {
            for (String bookName : bookNames) {
                System.out.println(bookName);
            }
        }
            
        // super simple to understand
        // %n, %.2f
        // what if bookNames = null ? no display book names
    }
    
    // instance variable 
    
    // invoke by calling object.writeOutput()(reference to method name)
    // instead sout(month + "" + day + "" + year) 
    // it will be sout(date1.month + "" + date1.day + "" + date1.year)
  
    /* 
    // constructor
    
    priv class which prevents access from other class
    private int MaxBorrowLimits;

    getter 
    public int get MaxBorrowLimits() {
        return this.MaxBorrowLimits;
    }

    setter methods 
    //this method which allows the other code stub outside of the class to call this method (plan to move the constructor, setter, getter to another class name LibConfig 
    // int returns integer value 
    public void setMaxBorrowLimits(int MaxBorrowLimits) { 
        if (MaxBorrowLimits > 5) 
            // bookname.length part here 
        else 
            for loop here
    }
    
    */
}
