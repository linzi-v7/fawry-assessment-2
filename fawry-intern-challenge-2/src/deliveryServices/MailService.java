package deliveryServices;

import products.Book;

public class MailService {
    public static void mail(Book book, String email)
    {
        //document stated no implementation required so i will only print some statements.
        System.out.println("** MAIL SERVICE INITIATED **");
        System.out.println("* BOOK SUCCESSFULLY EMAILED");
        System.out.println("* EMAIL OF BUYER: " + email);
        System.out.println("* Book Title: " + book.title);
        System.out.println("** MAIL SERVICE END");
    }
}
