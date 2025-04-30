
import max.MaxBorrowLimits;

/*
 *
 * Copyright (C) 2025 Adriel Nguyen
 *
 * Projects: VirtualLibSystem
 * Authors: Adriel
 * Date: 25/4/2025
 * Action: has a constructor, has objects and reference to the class name.
 * To be added 
 
[Part 1] ADD, REMOVE, INSERT, FILTERING Mechanics
=============================
1. insertOneBook(), user want to add a book, one by one to our collection 
2. removeOneBook(), user then wants to remove a book, one by one from our collection ~ automatically rank in alphabetical order 
can be add at beginning, middle, end.
3. addBookToCollection()  ~ add many books at a single time
4. removeBookFromCollection()~ delete many books at a single time
5. filterAlphabeticalOrder(), filter book alphebetical order 
6. filterYearRange() - filter books within specific published year range
7. filterBooksByTag()- filter books to match when they contain a specific tag  
8. filterBooksByAvailability()
9. insertBookAtPosition() - 
10.undoLastBookRemoveAndLast() - undo the most recent add or remove (undo, redo mechanics) 
11.batchFilterDeletion() - remove all books when it satisfy certain conditions or threshold    
12.toggleBookAvailabilityStatus() - (ready to borrow / not ready)
=============================
[Part 2] Search Functionality 

11. Speed Search
12. smart search, the program should be intelligent enough to guess the user 
intention. "Did you mean ... ? " (suggestion)
13. automatically find other details about the book user trying to find, warn user if insert a book twice
14. predictive order allocation [check books the library have and it decides who get them base on the book the student borrowed] => branching prediction concepts
15. auto complete search + inverted index search (find one word(s), phrases, boolean)
16. keyword Search(input String) - search byKeyword
17. Additional search Title begins with 
18. Additional search Title equals 
19. Additional search contains 
20. searchBookByTag() 
21. searchBookByAvailabilityStatus()


Library – Manages the book collection, searching, filtering, and batch management

=============================
[Part 3] Book Management Unit System
21. listAllAvailableBooks() ~ books are ready for the student to borrow
22. listAllBorrowedBooks()  ~ book are marked as in use by student or others 
23. getBooksDetails() ~ returns book ID
24. batchUpdateBooks() ~ similar to fetch string find and replace, update the books with new informations  
25. sortBookCollectionByRating()
26. shuffleBookOrdering - randomize book order
27. rateBook() - user can rate book 
28. getBookReview(), getTopRatedBooks()  


=============================
arrays 
class definition pg 174
class 173 - 304
write to a text file pg 584 
array list class pg 766
inheritance pg 427 
hash table with chaining pg  872 
sets pg 877 
trees pg 884 
branching prediction

reference: https://www.w3schools.com/dsa/dsa_theory_hashtables.php

=============================
*/
public class Library {

    public static void main(String[] args) {
        int max = 5;
        // user can only borrow 5 books;            
        String[] selected= {"book1", "book2", "book3", "book4", "book5", "book6", "book7", "book8", "book9", "book10"};
      
        //constructor 
        MaxBorrowLimits borrowAllowance = new MaxBorrowLimits(selected, max);
        
        borrowAllowance.setBorrowLimits();
            
       
    }
    
 
}
