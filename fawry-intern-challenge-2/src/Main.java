import customer.CustomerOperations;
import inventory.Inventory;
import inventory.InventoryController;
import products.BookType;

public class Main {
    public static void main(String[] args) {
        //TEST ADDING BOOKS
        InventoryController.addBookToInventory(BookType.DEMOBOOK,"ISBN1",
                "TITLE 1", 2025);
        InventoryController.addBookToInventory(BookType.PAPER_BOOK,"ISBN2",
                "TITLE 2", 2025, 200.0, 5.0, 5);
        InventoryController.addBookToInventory(BookType.EBOOK,"ISBN3",
                "TITLE 3", 2025 , 100.0, "PDF");
        InventoryController.addBookToInventory(BookType.PAPER_BOOK,"ISBN4",
                "TITLE 4", 2020, 250.0, 2.5, 3);

        Inventory.listAllBooks();

        //TEST BUYING BOOKS

        //should give error as ISBN1 is demo book
        System.out.println();
        CustomerOperations.buyBook("ISBN1",2,"email@gmail.com", "new cairo");

        //should give error not enough stock as only 5 exists
        System.out.println();
        CustomerOperations.buyBook("ISBN2",6,"email@gmail.com", "new cairo");

        //should give error not exist as book with ISBN doesnt currently exist
        System.out.println();
        CustomerOperations.buyBook("ISBN7",6,"email@gmail.com", "new cairo");

        //should work and decrease stock of the book and initiate shipping service
        System.out.println();
        CustomerOperations.buyBook("ISBN2",2,"email@gmail.com", "new cairo");

        //shouldn't work as we bought 2 and new stock is 3
        System.out.println();
        CustomerOperations.buyBook("ISBN2",4,"email@gmail.com", "new cairo");

        //should work and initiate mail service not shipping service, quantity/address is ignored here
        System.out.println();
        CustomerOperations.buyBook("ISBN3",4,"email@gmail.com", "new cairo");

        //TEST REMOVING OUTDATED BOOKS
        //should return ISBN4 as its published in 2020 and today is 2025
        System.out.println();
        System.out.println(InventoryController.getOutdatedBooks(3));

        //should return all
        System.out.println();
        System.out.println(InventoryController.getOutdatedBooks(0));

        //should remove ISBN4 and print the other 3
        System.out.println();
        InventoryController.removeOutdatedBooks(3);
        Inventory.listAllBooks();

        //should give error not exist
        System.out.println();
        CustomerOperations.buyBook("ISBN4",2,"email@gmail.com", "new cairo");

        //edit book test, should list the new book
        System.out.println();
        InventoryController.editBook("ISBN1", "THIS BOOK IS EDITED", 2020);
        Inventory.listAllBooks();

    }
}