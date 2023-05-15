import java.lang.Math;

public class Ponto2D {
    private final double x;
    private final double y;

    Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Ponto2D() {
        this(0, 0);
    }
    
    public void imprimirPonto() {
        System.out.println("(" + x + ", " + y + ")");
    }

    public boolean isEixoX() {
        return x == 0;
    }

    public boolean isEixoY() {
        return y == 0;
    }

    public boolean isEixos() {
        return (x == 0 || y == 0);
    }

    public int quadrante() {
        if (x == 0 || y == 0)
            return 0;
        
        if (x > 0)
            return ((y > 0) ? 1 : 4);
        else
            return ((y > 0) ? 2 : 3);
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(Ponto2D ponto) {
        double distancia = Math.sqrt(((ponto.getX() - x) * (ponto.getX() - x)) + ((ponto.getY() - y) * (ponto.getY() - y)));
        return distancia;
    }
    public double distancia(double x, double y) {
        return this.distancia(new Ponto2D(x, y));
    }
    public double distancia() {
        return this.distancia(new Ponto2D());
    }

    
    public static void main(String[] args){
        Ponto2D ponto1 = new Ponto2D(3, 4);
        Ponto2D ponto2 = new Ponto2D();

        ponto1.imprimirPonto();
        ponto2.imprimirPonto();
       
        System.out.println(ponto1.distancia());
        System.out.println(ponto2.distancia(2, 0));
    }
}
