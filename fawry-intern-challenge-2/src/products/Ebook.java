package products;

import products.interfaces.Emailable;
import products.interfaces.Sellable;

public class Ebook extends Book implements Sellable, Emailable {

    String fileType;
    double price;

    public Ebook(String ISBN, String title, int yearPublished, String fileType, double price) {
        super(ISBN, title, yearPublished);
        this.fileType = fileType;
        this.price = price;
    }

    @Override
    public String getBookType() {
        return "E-Book";
    }

    @Override
    public String getFileType() {
        return fileType;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
