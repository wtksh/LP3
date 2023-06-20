package Shape2D;

public class Shape2D {
    protected double x, y; // origin coords

    public Shape2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Shape2D() {
        this(0, 0);
    }

    public Shape2D(Shape2D shape) {
        this(shape.x, shape.y);
    }

    public String toString() {
        return String.format("Origin: (%f, %f)", x, y);
    }

    public static void main(String[] args) {
        Shape2D shape = new Shape2D();
        System.out.println(shape.toString());
    }
}