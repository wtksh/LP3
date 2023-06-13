public class Cilindro extends CorpoRedondo {

    public Cilindro(double raio, double altura) {
        super(raio, altura);
    }

    public Cilindro(double raio) {
        this(raio, 1);
    }

    public Cilindro() {
        this(1);
    }

    public double area() {
        return 2 * PI * raio * (raio + altura);
    }

    public double volume() {
        return PI * raio * raio * raio * altura;
    }

    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro(3, 5);
        
        System.out.println(cilindro);
        System.out.println("Area: " + cilindro.area());
        System.out.println("Volume: " + cilindro.volume());
    }
}
