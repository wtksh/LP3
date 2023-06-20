package Shape2D;

public class Triangle extends Shape2D {
    private double x1, y1; // ponto1
    private double x2, y2; // ponto2

    public Triangle(double x, double y, double x1, double y1, double x2, double y2) {
        super(x, y);
        if (validaTriangle(x, y, x1, y1, x2, y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public Triangle() {
        this(0, 0, 1, 0, 0, 1);
    }

    public Triangle(Triangle triangle) {
        this(triangle.x, triangle.y, triangle.x1, triangle.y1, triangle.x2, triangle.y2);
    }

    private boolean validaTriangle(double x, double y, double x1, double y1, double x2, double y2) {
        double D = (x * y1) + (y * x2) + (x1 * y2) - ((y1 * x2) + (x * y2) + (y * x1));
        if (D != 0)
            return true;
        else {
            System.out.println("Error: Invalid coordinates");
            return false;
        }
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    public double perimetro() {
        double d1 = distance(x, y, x1, y1);
        double d2 = distance(x1, y1, x2, y2);
        double d3 = distance(x2, y2, x, y);
        return d1 + d2 + d3;
    }
    
    public String toString() {
        return String.format("Origin: (%f, %f), P1: (%f, %f), P2: (%f, %f)", x, y, x1, y1, x2, y2);
    }
}
