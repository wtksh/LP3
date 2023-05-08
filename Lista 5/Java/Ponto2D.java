import java.lang.Math;

public class Ponto2D {
    private final double x;
    private final double y;

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
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

    
    public static void main(String[] args){
        Ponto2D ponto1 = new Ponto2D(4, 0);
        Ponto2D ponto2 = new Ponto2D(0, 3);

        ponto1.imprimirPonto();
        System.out.println(ponto1.isEixoX());
        System.out.println(ponto1.isEixoY());
        System.out.println(ponto1.isEixos());

        System.out.println(ponto1.distancia(ponto2));
    }
}
