package vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class vector3DTest {


    //test default constructor
    @Test
    public void testConstructor() {
        vector3D testVector = new vector3D(10.5, 3, 6);
        //expected, actual, delta precision loss
        //for calculated numbers 5.1 + 0.1 = 5.2, but actual output is 5.19999..
        //delta can be 0.001 or less
        assertEquals(10.5, testVector.getX(), 0);
        assertEquals(3, testVector.getY(), 0);
        assertEquals(6, testVector.getZ(), 0);
    }

    //test empty vector to string
    @Test
    public void toStringEmptyTest() {
        vector3D testVector = new vector3D();
        assertEquals(testVector.toString(), "");
    }

    @Test
    public void toStringTest() {
        vector3D testVector = new vector3D(1.572, 4.336, 6.5);
        testVector.toString();
        assertEquals("(1.57, 4.34, 6.50)", testVector.toString());
    }

    //no exceptions expected
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getMagnitudeTest() {
        //how to implement exception test?
        vector3D testVector = new vector3D(3.5, -2.5, 6);
        assertEquals(Math.sqrt(54.5), testVector.getMagnitude(), 0.1);
    }

    @Test
    public void testNormalizeException() {
        exception.expect(IllegalStateException.class);
        vector3D testVector = new vector3D(0,0,0);
        testVector.normalize();
    }

    @Test
    public void testNormalize() {
        vector3D testVector1 = new vector3D(0.6,0,0.8);
        vector3D testVector2 = new vector3D(9,0,12);
        vector3D testVector3 = testVector2.normalize();
        assertEquals(testVector1, testVector3);
    }

    @Test
    public void testAdd() {
        vector3D testVector1 = new vector3D(6,-2,7);
        vector3D testVector2 = new vector3D(-4,4,1);
        vector3D testVector3 = new vector3D(2, 2, 8);
        assertEquals(testVector3, testVector1.add(testVector2));
    }

    @Test
    public void testMultiply() {
        double constant = 3;
        vector3D testVector1 = new vector3D(6,-2,3);
        vector3D testVector3 = new vector3D(18, -6, 9);
        assertEquals(testVector3, testVector1.multiply(constant));
    }

    @Test
    public void testDotProduct() {
        vector3D testVector1 = new vector3D(1,2,3);
        vector3D testVector3 = new vector3D(-2, 0, 5);
        assertEquals(13, testVector1.dotProduct(testVector3), 0.0001);
    }

    @Test
    public void testAngleBetween() {
        vector3D testVector1 = new vector3D(4,3,0);
        vector3D testVector3 = new vector3D(3, 5, 0);
        assertEquals(22.16634582, testVector1.angleBetween(testVector3), 0.00000001);
    }


}