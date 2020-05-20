package lab3_fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    // Constructor
    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        //could i declare the exception in the constructor and the try-catch block inside my setter?
        setNumerator(numerator);
        setDenominator(denominator);
    }

    //Copy Constructor
    public Fraction(Fraction other) {
        this(other.getNumerator(), other.getDenominator());
    }

    //default no argument constructor
    public Fraction() {
    }

    //get set
    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator)  {
        //if you do a try catch, it will catch the exception, and continues to print
        //i.e it only executes the block inside the catch, since you 'customized' message
        //happen with the exception
        if (denominator <= 0) {
            //if you only throw the exception, then the exception will be raised
            //with a custom message after it
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.denominator = denominator;
    }

    //methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;
        Fraction fraction = (Fraction) o;
        return getNumerator() == fraction.getNumerator() &&
                getDenominator() == fraction.getDenominator();
    }

    public String toString() {
        String result = "";
        if (this.getNumerator() > this.getDenominator()) {
            //return mixed numeral 13/7 = 1 6/7
            int newNumerator = this.getNumerator() % this.getDenominator();
            int wholeNum = this.getNumerator() / this.getDenominator();
            result = "the number is " + wholeNum + " " + newNumerator + "/" + this.getDenominator();
        } else if (this.getNumerator() == this.getDenominator()) {
            //whole number  7/7 = 1
            result = "the number is 1";

        } else if (this.getDenominator() == 1) {
            // whole number 7 /1 = 7
            result = "the number is " + this.getNumerator();
        } else if (this.getNumerator() < this.getDenominator()) {
            //proper fraction 2/7 = 2/7
            result = "the number is " + this.getNumerator() + "/" + this.getDenominator();
        }
        return result;
    }

    public Double toDouble() {
        double top = getNumerator();
        double bottom = getDenominator();
        return top/bottom;
    }

    public boolean isEqualTo(Fraction other) {
        if ((this.getNumerator() * other.getDenominator()) == (this.getDenominator() * other.getNumerator())) {
            return true;
        }
        return false;
    }

    public Fraction getReciprocal() {
        try {
            if (this.getNumerator() == 0) {
                throw new IllegalStateException("Reciprical will be undefined because of 0");
            }
            this.setDenominator(this.getNumerator());
            this.setNumerator(this.getDenominator());
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        return this;
    }
}
