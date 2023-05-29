import base.Ponto2D;

public class SegmentoReta2 {
    private Ponto2D inicio;
    private Ponto2D fim;
    private double dimensao;

    public SegmentoReta2(Ponto2D P1, Ponto2D P2) {
        inicio = P1;
        fim = P2;
        dimensao = calculaDimensao();

    }

    public String imprimeSegmentoReta() {
        return String.format("O segmento de reta inicia no ponto (%.1f, %.1f) e finaliza no ponto (%.1f, %.1f) com dimensão %.2f.", inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), dimensao);
        
    }

    public double calculaDimensao() {
        return Ponto2D.distance(inicio, fim);
    }

    public static void main(String[] args) {
        Ponto2D P1 = new Ponto2D(1, 1);
        Ponto2D P2 = new Ponto2D(2, 2);

        SegmentoReta2 reta = new SegmentoReta2(P1, P2);

        System.out.println(reta.imprimeSegmentoReta());
    }
}
