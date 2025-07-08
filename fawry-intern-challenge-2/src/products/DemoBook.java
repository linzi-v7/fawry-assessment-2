package products;

import products.Book;

public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, int yearPublished) {
        super(ISBN, title, yearPublished);
    }

    @Override
    public BookType getBookType() {
        return BookType.DEMOBOOK;
    }
}
