package lab3_fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FractionTest {
    //we are not suppose to have any exception
    @Rule
    public ExpectedException exception = ExpectedException.none();

    Fraction number = new Fraction();
    @Test(expected = IllegalArgumentException.class)
    public void testSetDenominator() {
        number.setDenominator(0); //should pass, because 0 is not allowed
    }
}

