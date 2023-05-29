import base.Ponto2D;

public class SegmentoReta1 {
    private Ponto2D inicio;
    private Ponto2D fim;
    private double dimensao;

    public SegmentoReta1(int x1, int y1, int x2, int y2) {
        inicio = new Ponto2D(x1, y1);
        fim = new Ponto2D(x2, y2);
        dimensao = calculaDimensao();

    }

    public String imprimeSegmentoReta() {
        return String.format("O segmento de reta inicia no ponto (%.1f, %.1f) e finaliza no ponto (%.1f, %.1f) com dimensão %.2f.", inicio.getX(), inicio.getY(), fim.getX(), fim.getY(), dimensao);
        
    }

    public double calculaDimensao() {
        return Ponto2D.distance(inicio, fim);
    }

    public static void main(String[] args) {
        SegmentoReta1 reta = new SegmentoReta1(1, 1, 2, 2);

        System.out.println(reta.imprimeSegmentoReta());
    }
}
