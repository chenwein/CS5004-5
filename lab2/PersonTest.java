package practice;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Person class
 */
public class PersonTest {

    private Person john;
    private Person elvis;

    @Before
    public void setUp() {
        john = new Person(1945, "John", "Doe");
        elvis = new Person(1935,"Elvis", "Presley");
    }

    @Test
    public void testFirst() {
        assertEquals("John", john.getFirstName());
        assertEquals("Elvis", elvis.getFirstName());
    }

    @Test
    public void testSecond() {
        assertEquals("Doe", john.getLastName());
        assertEquals("Presley", elvis.getLastName());
    }

    @Test
    public void testYearOfBirth() {
        assertEquals(1945, john.getYearOfBirth());
        assertEquals(1935, elvis.getYearOfBirth());
    }

    @Test
    public void testInitial() {
        assertEquals("JD", john.getOrigFirstName());
    }
}
