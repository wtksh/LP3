package Shape2D;

public class Square extends Shape2D {
    private double lado;

    public Square(double x, double y, double lado) {
        super(x, y);
        if (validaLado(lado)) {
            this.lado = lado;
        }
    }

    public Square() {
        this(0, 0, 1);
    }

    public Square(Square square) {
        this(square.x, square.y, square.lado);
    }

    private boolean validaLado(double lado) {
        if (lado > 0) 
            return true;
        else {
            System.out.println("Error: invalid value of side");
            return false;
        }
    }

    public double area() {
        return lado * lado;
    }
    
    public double perimetro() {
        return 4 * lado;
    }

    public String toString() {
        return String.format("Origin: (%f, %f), Side: %f", x, y, lado);
    }
}
