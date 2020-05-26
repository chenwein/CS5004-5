package practice;

/**
 * This class represents a book. A book has a title, a Person object as the author
 * a price of type float
 */
public class Book {
    /** The title of this Book. */
    private String title;
    /** The author for this Book. */
    private Person author;
    /** The price for this Book. */
    private float price;

    /**
     * Construct a Book object that has the provided title, author and price
     *
     * @param title  the title to be given to this book
     * @param author the author to be given to this book
     * @param price  the price to be assigned to this book
     */
    public Book(String title, Person author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    /**
     * Return the title of this book
     *
     * @return the title of this book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Return the price of this book
     *
     * @return the price of this book
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * Return the author of this object
     *
     * @return the author of this object as a @link{Person}
     */
    public Person getAuthor() {
        return this.author;
    }

    public int authorAge() {
        return this.author.getYearOfBirth();
    }

}
