package inventory;

import products.Book;
import products.BookType;

import java.time.Year;
import java.util.ArrayList;

public class InventoryController {

    public static boolean addBookToInventory(BookType type, String isbn, String title,
                                             int yearPublished, Object ...args)
    {

        Book addedBook = BookFactory.createBook(type,isbn,title,yearPublished,args);
        if(addedBook != null)
        {
            Inventory.bookMap.put(isbn, addedBook);
            return true;
        }

        System.out.println("** ERROR ADDING BOOK TO INVENTORY **");
        return false;
    }

    public static Book getBook(String isbn)
    {
        return Inventory.bookMap.get(isbn);
    }

    public static Book removeBook(String isbn)
    {
        return Inventory.bookMap.remove(isbn);
    }

    public static void editBook(String isbn, String title,
                                int yearPublished, Object ...args)
    {
        Book currentBook = getBook(isbn);
        if(currentBook == null) return; //book not found

        BookType currentBookType = currentBook.getBookType();
        Book editedBook = BookFactory.createBook(currentBookType, isbn, title,
                yearPublished, args);

        Inventory.bookMap.put(isbn,editedBook);


    }

    //function required in the document:
    //Remove and return outdated books that passed specific number of years
    //numOfYearsOfExpiry refers to how old the book is.
    //for example, if today is 2025 and num of years is 3
    //any book older than or equal to 2022 is considered outdated and removed.
    public static ArrayList<Book> removeOutdatedBooks(int numOfYearsOfExpiry)
    {

        ArrayList<Book> removedBooks = getOutdatedBooks(numOfYearsOfExpiry);

        for (Book book: removedBooks) {
                InventoryController.removeBook(book.ISBN);
        }
        return removedBooks;
    }

    //in case the document wasnt clear and needs a function that only gets outdated books
    public static ArrayList<Book> getOutdatedBooks(int numOfYearsOfExpiry)
    {
        int currentYear = Year.now().getValue();
        int outdatedYear = currentYear - numOfYearsOfExpiry;
        ArrayList<Book> outDatedBooks = new ArrayList<>();

        for (Book book: Inventory.bookMap.values()) {
            if(book.yearPublished <= outdatedYear)
            {
                outDatedBooks.add(book);
            }
        }
        return outDatedBooks;
    }
}
