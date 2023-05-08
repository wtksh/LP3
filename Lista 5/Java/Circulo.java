public class Circulo {
    private double x;
    private double y;
    private double r;

    public Circulo(double x, double y, double r) {
        validaCirculo(r);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    private boolean validaCirculo(double r) {
        if (r > 0)
            return true;
        throw new IllegalArgumentException("Invalid r.");
    }

    // Setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    // Getters
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }

    public double getR() {
        return this.r;
    }

    public void imprimirCirculo() {
        System.out.println("(" + this.x + ", " + this.y + ", " + this.r + ")");
    }

    public boolean isInnerPoint (Ponto2D ponto) {
        Ponto2D centro = new Ponto2D(this.x, this.y);
        return ponto.distancia(centro) <= this.r;
    }

    public double area() {
        return Math.PI * this.r * this.r;
    }

    public double perimeter() {
        return 2 * Math.PI * this.r;
    }

    public boolean isBiggerThan(Circulo circulo) {
        return this.area() > circulo.area();
    }

    public static void main(String[] args) {
        Circulo circulo = new Circulo(0, 0, 3);
        Circulo circulo2 = new Circulo(0, 0, 1);
        circulo.imprimirCirculo();

        Ponto2D ponto = new Ponto2D(1 , 1);
        System.out.println(circulo.isInnerPoint(ponto));
        System.out.println(circulo.area());
        System.out.println(circulo.perimeter());
        System.out.println(circulo.isBiggerThan(circulo2));
    }

}


