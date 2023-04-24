public class Lampada {
    private int luminosidade;

    public Lampada(int luminosidade) {
        if (luminosidade < 0)
            luminosidade = 0;
        if (luminosidade > 100)
            luminosidade = 100;
        this.luminosidade = luminosidade;
    }

    public int getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(int luminosidade) {
        if (luminosidade < 0)
            luminosidade = 0;
        if (luminosidade > 100)
            luminosidade = 100;
        this.luminosidade = luminosidade;
    }

    public void acende() {
        luminosidade = 100;
    }

    public void apaga() {
        luminosidade = 0;
    }

    public void meiaLuz() {
        luminosidade = 50;
    }

    public void mostraEstado() {
        System.out.println((luminosidade == 0) ? "A lampada esta apagada." : "A lampada esta com " + luminosidade + "% de sua luminosidade total.");
    }

    public boolean estaLigada() {
        return ((luminosidade > 0) ? true : false);
    }

    
    public static void main(String[] args) {
        Lampada lampada = new Lampada(0);

        System.out.println(lampada.estaLigada());
        lampada.acende();
        lampada.mostraEstado();
        lampada.apaga();
        lampada.mostraEstado();
        lampada.meiaLuz();
        System.out.println(lampada.getLuminosidade());
        lampada.setLuminosidade(1);
        lampada.mostraEstado();
    }
}
