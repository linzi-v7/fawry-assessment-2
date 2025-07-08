package products;

import products.interfaces.Sellable;
import products.interfaces.Shippable;

public class PaperBook extends Book implements Shippable, Sellable {

    public int stockAvailable;
    double price;
    double weight;
    public PaperBook(String ISBN, String title, int yearPublished, double price, double weight,
                     int stockAvailable) {
        super(ISBN, title, yearPublished);
        this.price = price;
        this.weight = weight;
        this.stockAvailable = stockAvailable;
    }

    @Override
    public BookType getBookType() {
        return BookType.PAPER_BOOK;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "stockAvailable=" + stockAvailable +
                ", price=" + price +
                ", weight=" + weight +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }
}
