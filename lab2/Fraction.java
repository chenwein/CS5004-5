package practice;

public class Fraction {
    private int numerator;
    private int denominator;

    //constructor
    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
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

    public void setDenominator(int denominator)  { this.denominator = denominator; }

    //method equal

    public boolean isEqualTo(Fraction other) {
        if ((this.getNumerator() * other.getDenominator()) == (this.getDenominator() * other.getNumerator())) {
            return true;
        }
        return false;
    }

}
