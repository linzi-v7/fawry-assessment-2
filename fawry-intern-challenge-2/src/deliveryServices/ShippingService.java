package deliveryServices;

import products.Book;

public class ShippingService {
    public static void ship(Book book, String address)
    {
        //document stated no implementation required so i will only print some statements.
        System.out.println("** SHIPPING SERVICE INITIATED **");
        System.out.println("* Expect delivery withing 3 working days.");
        System.out.println("* ADDRESS OF BUYER: " + address);
        System.out.println("* Book Title: " + book.title);
        System.out.println("** SHIPPING SERVICE END");
    }
}
