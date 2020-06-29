package Polynomial;

//polynomial ADT
public interface Polynomial {
    //no body methods

    void addTerm(int coefficient, int exponent) throws IllegalArgumentException;

    void removeTerm(int exponent);

    int getDegree();

    int getCoefficient(int exponent);

    double evaluate(double number);

    Polynomial add(Polynomial object) throws IllegalArgumentException;

    String toString();
}
