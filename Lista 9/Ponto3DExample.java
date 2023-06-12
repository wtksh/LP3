
public class Ponto3DExample {
    public static void main(String[] args) {
        // Ponto 3D composição
        System.out.println("----------COMPOSIÇÃO----------");
        Ponto3DA pontoA0 = new Ponto3DA();
        Ponto3DA pontoA1 = new Ponto3DA(1, 2, 3);

        System.out.println("Ponto0: " + pontoA0);
        System.out.println("Ponto0 isOrigin: " + pontoA0.isOrigin());
        System.out.println("Ponto0 inAxis: " + pontoA0.inAxis());

        System.out.println("Ponto1 isAxisX: " + pontoA1.inAxisX());
        System.out.println("Ponto1 isAxisY: " + pontoA1.inAxisY());
        System.out.println("Distance ponto1 -> ponto0: " + pontoA1.distance(pontoA0));
        

        // Ponto3D agregação
        System.out.println("\n----------AGREGAÇÃO----------");
        Ponto3DB pontoB0 = new Ponto3DB();
        Ponto2D ponto2d = new Ponto2D(1, 2);
        Ponto3DB pontoB1 = new Ponto3DB(ponto2d, 3);

        System.out.println("Ponto0: " + pontoB0);
        System.out.println("Ponto0 isOrigin: " + pontoB0.isOrigin());
        System.out.println("Ponto0 inAxis: " + pontoB0.inAxis());

        System.out.println("Ponto1 isAxisX: " + pontoB1.inAxisX());
        System.out.println("Ponto1 isAxisY: " + pontoB1.inAxisY());
        System.out.println("Distance ponto1 -> ponto0: " + pontoB1.distance(pontoB0));


        // Ponto3D herança
        System.out.println("\n----------HERANÇA----------");
        Ponto3DC pontoC0 = new Ponto3DC();
        Ponto3DC pontoC1 = new Ponto3DC(1, 2, 3);

        System.out.println("Ponto0: " + pontoC0);
        System.out.println("Ponto0 isOrigin: " + pontoC0.isOrigin());
        System.out.println("Ponto0 inAxis: " + pontoC0.inAxis());

        System.out.println("Ponto1 isAxisX: " + pontoC1.inAxisX());
        System.out.println("Ponto1 isAxisY: " + pontoC1.inAxisY());
        System.out.println("Distance ponto1 -> ponto0: " + pontoC1.distance(pontoC0));
        }
}
