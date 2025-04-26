
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
 
Problem statement 
Lib class: user can only borrow maximum 5 books at one time, so the user can only borrow one book at once. Will show warning msg if they go overlimits that already set forth.  



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
        int max = 5;
        // user can only borrow 5 books;            
        String[] selected= {"book1", "book2", "book3", "book4", "book5", "book6", "book7", "book8", "book9", "book10"};
      
        //constructor 
        MaxBorrowLimits borrowAllowance = new MaxBorrowLimits(selected, max);
        
        borrowAllowance.setBorrowLimits();
            
       
    }
    
 
}
