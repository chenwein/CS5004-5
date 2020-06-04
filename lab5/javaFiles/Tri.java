public class Tri extends Shape {
    //fields
    private double side1;
    private double side2;
    private double side3;

    public Tri(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

        //return area and perimeter of tri
        @Override
        public double area() {
            double P = this.perimeter() / 2;
            double result = Math.sqrt(P * (P - side1) * (P - side2) * (P - side3));
            return result;
        }
        @Override
        public double perimeter() {
            return side1 + side2 + side3;
        }

}

