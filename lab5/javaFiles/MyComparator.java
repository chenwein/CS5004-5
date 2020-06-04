import java.util.Comparator;

public class MyComparator implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        if (o1.area() < o2.area()) {
            return -1;
        } else if (o1.area() > o2.area()) {
            return 1;
        } else {
            // equal
            return 0;
        }
    }

    public boolean equals(Object obj) {
        return true;
    }
}
