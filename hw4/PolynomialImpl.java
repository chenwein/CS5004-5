package Polynomial;


import org.w3c.dom.Node;

public class PolynomialImpl implements Polynomial {
    //polynomial is the linkedlist.
    //a term is a node in the linkedlist

    //class variables
    NodeTerm termHead;

    //class constructor
    public PolynomialImpl(){
        termHead = null;
    }

    //static NodeTerm class
    static class NodeTerm {
        private int coefficient;
        private int exponent;
        NodeTerm next;

        //constructor
        NodeTerm(int coefficient, int exponent) {
            setCoefficient(coefficient);
            setExponent(exponent);
            next = null;
        }

        //setter for coefficient and exponent
        public void setCoefficient(int coefficient) {
            this.coefficient = coefficient;
        }

        public void setExponent(int exponent) {
            if (exponent < 0) {
                throw new IllegalArgumentException("Exponent cannot be negative");
            }
            this.exponent = exponent;
        }
    }


    //methods add the node
    @Override
    public void addTerm(int coefficient, int power) throws IllegalArgumentException {
        //add term to the node
        NodeTerm newNode = new NodeTerm(coefficient, power);
        //1. if there is no head, set newNode as head
        //2. traverse list until you find exponent that is less than newNode.exponent, insert newnode
        //exponent before that term
        //3. if traverse till end, insert newNode at the end
        if (termHead == null) {
            //if termhead is non existent or term head happens to already be smaller than newNode exponent
            newNode.next = termHead;
            termHead = newNode;
            return;
        }
        NodeTerm current = termHead;
        NodeTerm ahead = termHead.next;
        //stops when next exponent <= newNode exponent

        //only one term and if the exponent is the same
        if (current.exponent == newNode.exponent) {
            newNode.coefficient += current.coefficient;
            newNode.next = termHead.next;
            termHead = newNode;
            return;
        } else {
            //2 conditions to continue
            //1. if ahead is not NULL
            //2. when ahead.exponent > newNode.exponent
            while (ahead != null && ahead.exponent > newNode.exponent) {
                //java evaluates first condition first.
                current = current.next;
                ahead = ahead.next;
            }
            //2 cases
            //1. we're at the end, ahead == null
            //2. not at the end. we insert before ahead /sum the term for same exponent
            if (ahead == null) {
                newNode.next = ahead;
                current.next = newNode;
            } else {
                if (ahead.exponent == newNode.exponent) {
                     ahead.coefficient += newNode.coefficient;
                } else {
                    //insert after current before next
                    newNode.next = ahead;
                    current.next = newNode;
                }

            }
        }
    }

    @Override
    public void removeTerm(int exponent) {
        //finding node with the power
        //if no term at all
        if (termHead == null ) {
            throw new IllegalArgumentException("empty list");
        }
        //if there is only one head term
        if (termHead.next == null && termHead.exponent != exponent) {
            throw new IllegalArgumentException("invalid entry");
        }
        //all other case
        NodeTerm current = termHead;
        NodeTerm ahead = termHead.next;
        if (current.exponent == exponent) {
            termHead = ahead;
        } else {
            while (ahead.exponent != exponent && ahead.next != null) {
                ahead = ahead.next;
                current = current.next;
            }
            //2 situations
            //ahead is at end
            if (ahead.exponent == exponent) {
                current.next = ahead.next; //ahead.next = null
            } else {
                //all else, means it is not on list
                throw new IllegalArgumentException("invalid entry");
            }
        }

    }

    @Override
    public int getDegree() {
        //highest power of the polynomial/
        //get head power
        return termHead.exponent;
    }

    @Override
    public int getCoefficient(int exponent) {
        if (termHead == null ) {
            throw new IllegalArgumentException("empty list");
        }
        //if there is only one head term
        if (termHead.next == null && termHead.exponent != exponent) {
            throw new IllegalArgumentException("invalid entry");
        }
        //all other case
        NodeTerm current = termHead;
        NodeTerm ahead = termHead.next;
        if (current.exponent == exponent) {
           return current.coefficient;
        } else {
            while (ahead.exponent != exponent && ahead.next != null) {
                ahead = ahead.next;
                current = current.next;
            }
            //2 situations
            //ahead is at end
            if (ahead.exponent == exponent) {
                return ahead.coefficient;
            } else {
                //all else, means it is not on list
                throw new IllegalArgumentException("invalid entry");
            }
        }
    }

    @Override
    public double evaluate(double number) {
        if (termHead == null ) {
            throw new IllegalArgumentException("empty list");
        }
        NodeTerm current = termHead;
        double sumTotal = 0.0;
        while (current != null) {
            //returns double
            sumTotal += Math.pow(number,current.exponent) * current.coefficient;
            current = current.next;
        }
        //f(x) substitute number into the polynomial
        // (number raise to power) * coefficient + Node
        return sumTotal;
    }

    @Override
    public Polynomial add(Polynomial object) throws IllegalArgumentException {
        //create result list
        PolynomialImpl result = new PolynomialImpl();

        //cast object into PolynomialImpl
        //create pointers for all three list
        PolynomialImpl other = (PolynomialImpl) object;
        NodeTerm current = this.termHead;
        NodeTerm otherCurrent = other.termHead;
        //traverse lists
        while (current != null && otherCurrent != null) {
            if (current.exponent <= otherCurrent.exponent) {
                result.addTerm(otherCurrent.coefficient, otherCurrent.exponent);
                otherCurrent = otherCurrent.next;
            } else {
                result.addTerm(current.coefficient, current.exponent);
                current = current.next;
            }
        }
        //connect rest of term;
        if (current == null) {
           while(otherCurrent != null) {
               result.addTerm(otherCurrent.coefficient, otherCurrent.exponent);
               otherCurrent = otherCurrent.next;
           }
        } else {
            while (current != null) {
                result.addTerm(current.coefficient, current.exponent);
                current = current.next;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        if (termHead == null) {
            return "empty";
        }
        //string to start building sequence
        String term = "";
        //take care of all head terms
        term += String.format("%dX^%d", termHead.coefficient, termHead.exponent);
        //pointer for tranversing rest of list
        NodeTerm curr = termHead.next;
        while (curr != null) {
            if (curr.exponent == 0) {
                //exponent is 0, variable should be removed (since it equals to 1)
                //3x^0         term + "+"
                term += (curr.coefficient) > 0 ? "+" : " " ;
                //term +  "3"  just the number
                term += curr.coefficient;
            } else {
                term += (curr.coefficient > 0) ? "+" : " " ;
                term += String.format("%dX^%d", curr.coefficient, curr.exponent);
            }
            curr = curr.next;
        }
        return term;
    }
}
