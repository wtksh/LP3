public class CorpoRedondo {
    protected static final double PI = 3.14159265; // PI
    protected double raio; // raio
    protected double altura; // altura

    public CorpoRedondo(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public CorpoRedondo(double raio) {
        this(raio, 1);
    }

    public CorpoRedondo() {
        this(1);
    }

    public String toString() {
        return "Raio: " + raio + "\nAltura: " + altura;
    }

    public double getR() {
        return raio;
    }

    public double getH() {
        return altura;
    }

    public static void main(String[] args) {
        CorpoRedondo corpoRedondo = new CorpoRedondo();

        System.out.println(corpoRedondo);
    }
}
