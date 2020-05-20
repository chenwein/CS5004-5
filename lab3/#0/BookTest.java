package lab3_fileTests;//import static org.junit.Assert.assertEquals;

//import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BookTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    Person mark = new Person(1950, "Mark", "Miller");
    Book b1 = new Book("Foo", 13.25, mark);

    @Test
    public void test1() {
        exception.expect(IllegalArgumentException.class);
        Book discountedBook2 = b1.discountBook(-0.15); // should pass
    }

    @Test
    public void test2() {
        exception.expect(IllegalStateException.class);
        Book discountedBook3 = b1.discountBook(-0.15); // should fail
    }
}

