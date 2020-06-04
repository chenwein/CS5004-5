public class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    //return the area of this circle
    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public double perimeter() {
        return 2.0 * this.radius * Math.PI;
    }
}
