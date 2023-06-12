
public class Ponto2DExample {
    public static void main(String[] args) {
        Ponto2D ponto0 = new Ponto2D();
        Ponto2D ponto1 = new Ponto2D(3, 4);

        System.out.println("Ponto0: " + ponto0);
        System.out.println("Ponto0 isOrigin: " + ponto0.isOrigin());
        System.out.println("Ponto0 inAxis: " + ponto0.inAxis());

        System.out.println("Ponto1 isAxisX: " + ponto1.inAxisX());
        System.out.println("Ponto1 isAxisY: " + ponto1.inAxisY());
        System.out.println("Distance ponto1 -> ponto0: " + ponto1.distance(ponto0));
    }
}
