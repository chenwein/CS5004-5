import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public final class Rectangle extends Shape implements ColorfulThing{
    private double width;
    private double length;
    // 1 - green; 2 - yellow
    private final int color;

    public Rectangle(double w, double l, int color) {
        this.width = w;
        this.length = l;
        this.color = color;
    }

    @Override
    public double area() {
        return this.width * this.length;
    }

    public double perimeter() {
        return 2 * (this.width + this.length);
    }

    // in order to implement the ColorfulThing interface,
    // we need to implement the getColor() method
    public int getColor() {
        return this.color;
    }

    public String toString() {
        return "rectangle width: " + Double.toString(this.width) + " length: "
                + Double.toString(this.length);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2.0, 3.0, 1);
        Rectangle r2 = new Rectangle(1.5, 2.0, 1);
        System.out.println(r1.compareTo(r2));
        Circle c1 = new Circle(2.0);
        System.out.println(r1.compareTo(c1));
        System.out.println(c1.compareTo(r1));

        //Shape s = new Shape();

        // I'm the user of the drawTool
        // use it to draw a rectangle
        Rectangle rectangleToDraw = new Rectangle(2.0, 3.0, 1);
        //PaintTool pTool = new PaintTool();
        PaintTool.draw(rectangleToDraw);

        // We have an list of shapes, we want to
        // sort them by size
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(r1);
        shapes.add(r2);
        shapes.add(c1);
        Collections.sort(shapes);

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).area());
        }

        // we want to sort our shapes by its perimeter
        Comparator<Shape> c = new MyComparator();
        Collections.sort(shapes, c);

        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(shapes.get(i).perimeter());
        }
    }
}
