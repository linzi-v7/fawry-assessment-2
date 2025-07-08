package inventory;

import products.Book;
import products.BookType;
import products.Ebook;
import products.PaperBook;
import products.interfaces.DemoBook;

public class BookFactory {

    //args should contain the optional parameters for the different types of books
    //price -> weight -> stock for Paperbooks
    //price -> filetype for ebooks
    public static Book createBook(BookType type, String isbn, String title, int yearPublished, Object ...args)
    {
        switch (type)
        {
            case PAPER_BOOK :
                return new PaperBook(isbn,title,yearPublished,
                        (Double) args[0],
                        (Double) args[1],
                        (Integer) args[2]);
            case EBOOK:
                return new Ebook(isbn,title,yearPublished,
                        (Double) args[0],
                        (String) args[1]);

            case DEMOBOOK:
                return new DemoBook(isbn,title,yearPublished);

            default:
                System.out.println("** ERROR CREATING BOOK **\n");
                break;
        }

        return null;
    }
}
