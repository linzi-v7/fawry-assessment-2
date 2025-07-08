package products;

public abstract class Book {
    //better to use private with getters and setters, but i went this way for convenience
    public String ISBN;
    public String title;
    public int yearPublished;

    public Book(String ISBN, String title, int yearPublished) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public abstract String getBookType();
}
