package vector;

class vector3D {
    //fields
    private double x;
    private double y;
    private double z;

    /**
     * default constructor
     * @param x double component of vector
     * @param y ''
     * @param z ''
     */
    public vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * no argument constructor
     */
    public vector3D(){

    }

    /**
     * copy constrcutor
     * @param other an object of vector3D class
     */
    public vector3D(vector3D other) {
        this(other.getX(), other.getY(), other.getZ());
    }

    //get and set
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    //methods
    /**
     *  to string
     * @return (x,y,z) round to 2 decimal places
     */
    @Override
    public String toString() {
        if (getX() + getY() + getZ() == 0) {
            return "";
        }
        return String.format("(%.2f, %.2f, %.2f)", getX(), getY(), getZ());
    }

    /**
     * get magnitude method
     * @return double
     * @throws IllegalArgumentException if magnitude is less than 0
     */
    public double getMagnitude() {
         double magnitude =  Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2));
         return magnitude;
    }

    /**
     * normalize vector
     * @return a new vector object with normalized components
     * @throws IllegalStateException if vector 0
     */
    public vector3D normalize() throws IllegalStateException {
        double magnitude = this.getMagnitude();
        if (getX() + getY() + getZ() == 0) {
            throw new IllegalStateException("normalize zero vector");
        }
        return new vector3D(getX() / magnitude,getY() / magnitude, getZ() / magnitude );
    }

    /**
     * equals method
     * @param o an object
     * @return true if the object values are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof vector3D)) return false;
        vector3D vector3D = (vector3D) o;
        return Double.compare(vector3D.getX(), getX()) == 0 &&
                Double.compare(vector3D.getY(), getY()) == 0 &&
                Double.compare(vector3D.getZ(), getZ()) == 0;
    }

    /**
     * adding two vectors together
     * @param other a vector object
     * @return a new vector with the added component values
     */
    public vector3D add(vector3D other) {
        return new vector3D(getX() + other.getX(), getY() + other.getY(), getZ() + other.getZ());
    }

    /**
     * multiply each vector component by constant
     * @param constant double
     * @return new vector with scaled components
     */
    public vector3D multiply(double constant) {
        return new vector3D(getX() * constant, getY() * constant, getZ() * constant);
    }

    /**
     * dotproduct of 2 vectors a1*b1 + a2*b2
     * @param other vector3D object
     * @return new vector3D object
     */
    public double dotProduct(vector3D other) {
        return (getX() * other.getX()) + (getY() * other.getY()) + (getZ() * other.getZ());

    }

    public double angleBetween(vector3D other) throws IllegalStateException {
        if (this.getX() + this.getY() + this.getY() == 0 ||
        other.getX() + other.getY() + other.getZ() == 0) {
            throw new IllegalStateException("vector cannot be 0");
        }
        double radian = Math.acos( (dotProduct(other)) / (this.getMagnitude() * other.getMagnitude()) );
        return Math.toDegrees(radian);
    }

}