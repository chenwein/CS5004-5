public abstract class Shape implements Comparable<Shape> {
    // compare the area of this shape to another one
    // return true if this one is larger
    // otherwise return false
    /*
    public boolean compareTo(Shape other) {
        // polymorphism:
        // java will figure out the actual type of `other`:
        // Rectangle or Circle
        if (this.area() > other.area()) {
            return true;
        } else {
            return false;
        }
    }
    */

//    public final int compareTo(Shape o) {
//        if (this.area() < o.area()) {
//            return -1;
//        } else if (this.area() > o.area()) {
//            return 1;
//        } else {
//            // equal
//            return 0;
//        }
//    }

//    public final int compareTo(Shape o) {
//        if (this.perimeter() < o.perimeter()) {
//            return -1;
//        } else if (this.perimeter() > o.perimeter()) {
//            return 1;
//        } else {
//            // equal
//            return 0;
//        }
//    }
    //string variable for abstract class
    String color;

    public final int compareTo(Shape other){
        String first = Character.toString(this.color.charAt(0));
        if (this.color.charAt(0) < other.color.charAt(0)) {
            return -1;
        } else if (this.color.charAt(0) > other.color.charAt(0)){
            return 1;
        } else {
            //equal
            return 0;
        }
    }

//


    abstract double area();
    abstract double perimeter();
}
