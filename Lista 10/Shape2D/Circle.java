package Shape2D;

public class Circle extends Shape2D {
    private double raio; //
    private static final double PI = 3.1415;
    
    public Circle(double x, double y, double raio) {
        super(x, y);
        if (validaRadius(raio))
            this.raio = raio;
    }

    public Circle() {
        this(0, 0, 1);
    }

    private boolean validaRadius(double radius) {
        if (radius > 0)
            return true;
        else {
            System.out.println("Error: invalid radius");
            return false;
        }
    }

    public double area() {
        return PI * raio * raio;
    }

    public double perimetro() {
        return 2 * PI * raio;
    }

    @Override
    public String toString() {
        return "Origin: (" + x + ", " + y + "), Radius: " + raio;
    }
}
