package customer;

import deliveryServices.MailService;
import deliveryServices.ShippingService;
import inventory.InventoryController;
import products.Book;
import products.PaperBook;
import products.interfaces.Sellable;

public class CustomerOperations {

    //email and address should be optional but the document doesnt state so
    public static void buyBook(String ISBN, int quantity, String email, String address)
    {
        Book bookToBuy = InventoryController.getBook(ISBN);
        double totalPrice;

        //check if exists
        if(bookToBuy == null)
        {
            System.out.println("** ERROR: BOOK NOT AVAILABLE **");
            return;
        }

        assert bookToBuy instanceof Sellable; //check if not demo book

        if(bookToBuy instanceof PaperBook paperBook)
        {
            if(paperBook.stockAvailable < quantity)
            {
                System.out.println("** ERROR: NOT ENOUGH STOCK AVAILABLE **");
                System.out.println("* STOCK AVAILABLE: " + paperBook.stockAvailable);
                System.out.println("* YOUR DESIRED QUANTITY: " + quantity);
                System.out.println("** PLEASE TRY AGAIN WITH APPROPRIATE AMOUNT **\n");
                return;
            }

            totalPrice = paperBook.getPrice() * quantity;
            System.out.println("PRICE TO BE PAID: " + totalPrice);
            ((PaperBook) bookToBuy).stockAvailable = paperBook.stockAvailable - quantity;
            ShippingService.ship(paperBook,address);
            return;
        }
        totalPrice = ((Sellable) bookToBuy).getPrice();
        System.out.println("PRICE TO BE PAID: " + totalPrice);
        MailService.mail(bookToBuy,email);
    }
}
