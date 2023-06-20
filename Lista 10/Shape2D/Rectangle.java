package Shape2D;

public class Rectangle extends Shape2D {
    private double comprimento;
    private double altura;

    public Rectangle(double x, double y, double comprimento, double altura) {
        super(x, y);
        if (validaLado(comprimento) && validaLado(altura)) {
            this.comprimento = comprimento;
            this.altura = altura;
        }
    }

    public Rectangle() {
        this(0, 0, 2, 1);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.x, rectangle.y, rectangle.comprimento, rectangle.altura);
    }

    private boolean validaLado(double lado) {
        if (lado > 0)
            return true;
        else {
            System.out.println("Error: invalid value of length or height");
            return false;
        }
    }

    public double area() {
        return altura * comprimento;
    }

    public double perimetro() {
        return 2 * (altura + comprimento);
    }

    @Override
    public String toString() {
        return String.format("Origin: (%f, %f), Altura: %f, Comprimento: %f", x, y, altura, comprimento);
    }
}
