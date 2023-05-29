import base.Ponto2D;

public class Triangulo {
    private Ponto2D P1;
    private Ponto2D P2;
    private Ponto2D P3;

    public Triangulo(Ponto2D P1, Ponto2D P2, Ponto2D P3) {
        if (validarTriangulo(P1, P2, P3)) {
            this.P1 = P1;
            this.P2 = P2;
            this.P3 = P3;
        }
        else {
            System.out.println("Error: Invalid triangle!!!");
        }
    }

    private boolean validarTriangulo(Ponto2D P1, Ponto2D P2, Ponto2D P3) {
        double x1 = P1.getX(), y1 = P1.getY();
        double x2 = P2.getX(), y2 = P2.getY();
        double x3 = P3.getX(), y3 = P3.getY();

        double D = (x1 * y2) + (y1 * x3) + (x2 * y3) - ((y2 * x3) + (x1 * y3) + (y1 * x2));

        return D == 0 ? false : true;
    }

    public void imprimeTriangulo() {
        System.out.print("P1: ");
        P1.imprimirPonto();
        System.out.print("P2: ");
        P2.imprimirPonto();
        System.out.print("P3: ");
        P3.imprimirPonto();
    }

    public boolean isRetangulo() {
        double d12 = Ponto2D.distance(P1, P2);
        double d23 = Ponto2D.distance(P2, P3);
        double d31 = Ponto2D.distance(P3, P1);

        if ((d12 * d12 == d23 * d23 + d31 * d31) || (d23 * d23 == d12 * d12 + d31 * d31) || (d31 * d31 == d12 * d12 + d23 * d23))
            return true;
        else
            return false;
    }

    public boolean isIsoceles() {
        double d1 = Ponto2D.distance(P1, P2);
        double d2 = Ponto2D.distance(P2, P3);
        double d3 = Ponto2D.distance(P3, P1);

        if ((d1 == d2) || (d2 == d3) || (d1 == d3))
            return true;
        else
            return false;
    }

    public boolean isEquilatero() {
        double d1 = Ponto2D.distance(P1, P2);
        double d2 = Ponto2D.distance(P2, P3);
        double d3 = Ponto2D.distance(P3, P1);

        if (d1 == d2 && d2 == d3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Ponto2D P1 = new Ponto2D(0, 0);
        Ponto2D P2 = new Ponto2D(0, 3);
        Ponto2D P3 = new Ponto2D(4, 0);
        Triangulo triangulo = new Triangulo(P1, P2, P3);

        triangulo.imprimeTriangulo();
        System.out.println(triangulo.isRetangulo());
        System.out.println(triangulo.isIsoceles());
        System.out.println(triangulo.isEquilatero());
    }
}
