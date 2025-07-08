package inventory.interfaces;

import inventory.Book;

public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, int yearPublished) {
        super(ISBN, title, yearPublished);
    }

    @Override
    public String getBookType() {
        return "Demo Book (NOT FOR SALE)";
    }
}
