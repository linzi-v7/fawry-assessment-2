package customer;

import deliveryServices.MailService;
import deliveryServices.ShippingService;
import inventory.InventoryController;
import products.Book;
import products.PaperBook;
import products.interfaces.Sellable;

public class CustomerOperations {

    //email and address should be optional but the document doesnt state so
    public static void buyBook(String ISBN, int quantity, String email, String address) {

        try {
            Book book = validatePurchase(ISBN, quantity);
            processPurchase(book,quantity,email,address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //all the checks needed before processing the transaction goes here
    private static Book validatePurchase(String ISBN, int quantity) throws Exception {
        Book bookToBuy = InventoryController.getBook(ISBN);

        if (bookToBuy == null)
            throw new Exception("** ERROR: BOOK NOT EXIST **");

        if (!(bookToBuy instanceof Sellable))
            throw new Exception("** ERROR: BOOK NOT FOR SALE (DEMO VER.) **");

        if (bookToBuy instanceof PaperBook paperBook)
            validateStock(paperBook, quantity);

        return bookToBuy;
    }

    private static void processPurchase(Book book, int quantity, String email, String address)
    {
        double totalPrice = calculateTotalPrice(book,quantity);
        System.out.println("PRICE TO BE PAID: " + totalPrice);

        if (book instanceof PaperBook paperBook)
        {
            updateStock(paperBook,quantity);
            ShippingService.ship(book,address);
        }
        else {
            MailService.mail(book,email);
        }
    }

    //used to validate if enough stock is available ONLY FOR PaperBooks
    private static void validateStock(PaperBook paperBook, int quantity) throws Exception {
        if (paperBook.stockAvailable < quantity) {
            String message = String.format(
                    "NOT ENOUGH STOCK AVAILABLE%n" +
                            "* STOCK AVAILABLE: %d%n" +
                            "* YOUR DESIRED QUANTITY: %d%n" +
                            "** PLEASE TRY AGAIN WITH APPROPRIATE AMOUNT **",
                    paperBook.stockAvailable, quantity
            );

            throw new Exception(message);
        }
    }

    private static double calculateTotalPrice(Book book, int quantity)
    {
        double totalPrice;
        Sellable sellableBook = (Sellable) book;

        //if its physical (paper) book, we need to multiply by quantity else its quantity is 1 (EBOOK)
        if(sellableBook instanceof PaperBook)
            totalPrice = sellableBook.getPrice() * quantity;
        else
            totalPrice = sellableBook.getPrice();

        return totalPrice;

    }

    private static void updateStock(PaperBook paperBook, int quantity)
    {
        System.out.println("** UPDATING STOCK");
        System.out.println("** BEFORE: " + paperBook.stockAvailable);
        paperBook.stockAvailable -= quantity;
        System.out.println("** AFTER: " + paperBook.stockAvailable);
    }
}
