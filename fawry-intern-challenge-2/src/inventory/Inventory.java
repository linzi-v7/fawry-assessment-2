package inventory;

import products.Book;

import java.util.HashMap;

public class Inventory {
    public static int numOfBooks = 0;

    //<ISBN, Book Object> ISBN is suitable here because
    //its unique even for different formats (according to my research)
    public static HashMap<String, Book> bookMap;
}
