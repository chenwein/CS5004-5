import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RectangleTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Rectangle testRectangle;
    private Rectangle otherRectangle;

    @Before
    public void setUp() throws IllegalArgumentException {
        testRectangle = new Rectangle(0,0,5,6);
        otherRectangle = new Rectangle(0,0,10,3);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWidth() {
        testRectangle = new Rectangle(0,0,-5,1); //should pass
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHeight() {
        testRectangle = new Rectangle(0,0,5,-6); //should pass
    }

    //overlap
    @Test
    public void overlap1() {
        boolean check1 = testRectangle.overlap(otherRectangle);
        assertTrue(check1);
    }
    //left right
    @Test
    public void overlap2(){
        boolean check2;
        otherRectangle = new Rectangle(15,0,4,4);
        check2 = testRectangle.overlap(otherRectangle);
        assertFalse(check2);
    }
    //top bottom
    @Test
    public void overlap3(){
        boolean check3;
        otherRectangle = new Rectangle(0,10,4,4);
        check3 = testRectangle.overlap(otherRectangle);
        assertFalse(check3);
    }

    @Test
    public void testEqual() {
        otherRectangle = new Rectangle(0,0,5,6);
        assertEquals(testRectangle, otherRectangle);
        //assert Equals uses the .equals method in Java
        //make sure the equals method in code compares the necessary values.
    }

    @Test(expected = NoSuchElementException.class)
    public void testIntersectFalse() {
        otherRectangle = new Rectangle(20,20,10,3);
        testRectangle.intersect(otherRectangle); //should pass cuz dont overlap
    }

    @Test
    public void testIntersectTrue(){
        Rectangle answer = new Rectangle(0,0,5,3);
        Rectangle compare = testRectangle.intersect(otherRectangle);
        assertEquals(answer, compare);
    }

    @Test
    public void testUnion() {
        Rectangle answer = new Rectangle(0,0,10,6);
        Rectangle compare = testRectangle.union(otherRectangle);
        assertEquals(answer, compare);
    }

    @Test
    public void testString() {
        assertEquals("x:0, y:0, w:5, h:6", testRectangle.toString());
    }
}