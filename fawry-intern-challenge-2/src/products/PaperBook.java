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
    public String getBookType() {
        return "PaperBook";
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
