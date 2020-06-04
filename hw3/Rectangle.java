import java.util.NoSuchElementException;

public class Rectangle {
    //fields
    private int x;
    private int y;
    private int width; //cannot be negative
    private int height; //cannot be negative


    //constructor
    public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException {
        this.x = x;
        this.y = y;
        if (width < 0 || height < 0){
            throw new IllegalArgumentException("Width or Height cannot be negative");
        }
        this.width = width;
        this.height = height;
    }

    //getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    /**
     * checks if 2 rectangle overlaps
     * @param other Rectangle instance
     * @return true if overlaps
     */
    public boolean overlap(Rectangle other) {
        //max of x is less than the smallest of the larger xs
        //max of y is less than the smallest of the larger ys
       if(
               (Math.max(getX(), other.getX()) < Math.min(getX() + getWidth(), other.getX() + other.getWidth())) &&
               (Math.max(getY(), other.getY()) < Math.min(getY() + getHeight(), other.getY() + other.getHeight()))
       ) {
           return true;
       }
       return false;
    }

    /**
     * equality of 2 objects
     * @param o object of rectangle instance
     * @return boolean true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)){ return false;}
        Rectangle rectangle = (Rectangle) o;
        return x == rectangle.x &&
                y == rectangle.y &&
                width == rectangle.width &&
                height == rectangle.height;
    }

    /**
     * intersect rectangle
     * @param other Rectangle object
     * @return a new rectangle object representing
     * @throws NoSuchElementException
     */
    public Rectangle intersect(Rectangle other) throws NoSuchElementException {
        if (this.overlap(other)) {
            //find lower coordinates of new rectangle
            int newX = Math.max(getX(), other.getX());
            int newY = Math.max(getY(), other.getY());
            //find width by difference of the two overlap rectangle
            int width = Math.min(getX() + getWidth(), other.getX() + other.getWidth());
            int height = Math.min(getY() + getHeight(), other.getY() + other.getHeight());
            return new Rectangle(newX, newY, width, height);
        } else {
            throw new NoSuchElementException("these 2 rectangles do not overlap,no intersecting areas");
            //throw exception
        }

    }

    /**
     * finds union rectangle of the 2 rectangles regarldess of overlap
     * @param other Rectangle object
     * @return union rectangle
     */
    public Rectangle union(Rectangle other) {
        //find lower left corner of union rectangle
        //find the width and length through finding the longest side of each rectangle
        //less the lower left corner coordinates, which then gives the difference that is also the height and width
        int minX = Math.min(this.getX(), other.getX());
        int minY = Math.min(this.getY(), other.getY());
        int width = Math.max(getX() + getWidth(), other.getX() + other.getWidth()) - minX;
        int height = Math.max(getY() + getHeight(), other.getY() + other.getHeight()) - minY;
        return new Rectangle(minX, minY, width, height);
    }
    /**
     * to string
     * @return string information of object
     */
    public String toString() {
        String result = String.format("x:%d, y:%d, w:%d, h:%d", getX(), getY(), getWidth(), getHeight());
        return result;
    }

}
