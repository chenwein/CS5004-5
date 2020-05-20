package lab3_fileTests;

/**
 * @author weinienchen
 */

public class Book {
    // member variables
    private String title;
    private double price; // $10.50
    private Person author;

    /**
     * constructor for book class
     * @param title string input for book title
     * @param price double input for book price
     * @param author person object for book author
     */
    public Book(String title, double price, Person author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // overloading the constructor
    public Book(String title, Person author) {
        this.title = title;
        this.author = author;
    }

    // methods
    public Person getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * calculates the price of book after discount
     * @param discount a double input for the discount amount
     * @return a new book of this book with discount, e.g., 0.15 -- 15% off
     * @throws IllegalArgumentException if discount less than 0
     */
    public Book discountBook(double discount) throws IllegalArgumentException {
        if (discount < 0) {
            // invalid discount
            throw new IllegalArgumentException("Discount must not be negative!");
        }

        // calculate the new price
        double newPrice = this.price * (1.0 - discount);
        // create the discounted book
        return new Book(this.title, newPrice, this.author);
    }

    /**
     * overloads dicountbook method
     * @param anotherBook object
     * @return returns the price of book with new price
     */
    public Book discountBook(Book anotherBook) {
        double newPrice = anotherBook.price;
        //double newPrice = anotherBook.getPrice();
        return new Book(this.title, newPrice, this.author);
    }

    public String toString() {
       return title + " " + author.toString();
    }

    public static void main(String[] args) {
        Person p = new Person(1989, "Tom", "Cheng");
        Book book = new Book("Java Programming", 20.50, p);

        Person author = book.getAuthor();
        System.out.println(author.getName());

        System.out.println("Before discount: " + Double.toString(book.getPrice()));
        Book discountedBook = book.discountBook(0.15);
        System.out.println("After discount: " + Double.toString(discountedBook.getPrice()));

        Book book1 = new Book("C++ Programming", 40.0, p);
        System.out.println("Before discount: " + Double.toString(book1.getPrice()));
        Book discountedBook1 = book.discountBook(discountedBook);
        //Book discountedBook1 = book.discountBook(book);
        System.out.println("After discount: " + Double.toString(discountedBook1.getPrice()));

        System.out.println(book1);

        System.out.println("Before discount: " + Double.toString(book.getPrice()));

        try {
            Book discountedBook2 = book.discountBook(-0.15);
            System.out.println("After discount: " + Double.toString(discountedBook2.getPrice()));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
