import java.lang.Math;

public class Ponto2D {
    private int x;
    private int y;

    public Ponto2D(int x, int y) {
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
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float distancia(Ponto2D ponto) {
        float distancia = (float) Math.sqrt(((ponto.getX() - x) * (ponto.getX() - x)) + ((ponto.getY() - y) * (ponto.getY() - y)));
        return distancia;
    }

    
    public static void main(String[] args){
        Ponto2D ponto1 = new Ponto2D(5, 1);
        Ponto2D ponto2 = new Ponto2D(0, 3);

        ponto1.imprimirPonto();
        ponto1.setX(4);
        ponto1.setY(0);
        ponto1.imprimirPonto();
        System.out.println(ponto1.isEixoX());
        System.out.println(ponto1.isEixoY());
        System.out.println(ponto1.isEixos());

        System.out.println(ponto2.getX() + ", " + ponto2.getY());
        System.out.println(ponto1.distancia(ponto2));
    }
}
