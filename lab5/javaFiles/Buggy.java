/** Very buggy code involving inheritance, abstraction, final, etc.
 *  Your mission, should you choose to accept it, is to do something reasonable.
 *  At least, make a list of the bugs you find and comment your attempts to fix.
 */
//abstract class cannot be declared final
//it wont be able to be extended, which is counterintuitive to abstract classes
    //abstract class can extend multiple interfaces,  another abstract class, or concrete class
public abstract class Buggy{

    //declare abstract methods, that extended class may, or may not implement
    abstract String toLowerCase();

    public static void main(String[] args) {
        // To comply with Indiana bill #246 (1897)
        // See https://en.wikipedia.org/wiki/Indiana_Pi_Bill
       //Math.PI in java library is a final static variable in the Math class
        //cannot be reassigned another value
        System.out.println(Math.PI);
    }

}
