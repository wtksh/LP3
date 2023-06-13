public class Cone extends CorpoRedondo {

    public Cone(double raio, double altura) {
        super(raio, altura);
    }

    public Cone(double raio) {
        this(raio, 1);
    }

    public Cone() {
        this(1);
    }

    public double area() {
        double geratriz = java.lang.Math.sqrt((raio * raio) + (altura * altura));
        return PI * raio * (raio + geratriz);
    }

    public double volume() {
        return (PI * raio * raio * altura) / 3;
    }

    public double getH() {
        return altura;
    }

    public static void main(String[] args) {
        Cone cone = new Cone(3, 5);
        
        System.out.println(cone);
        System.out.println("Area: " + cone.area());
        System.out.println("Volume: " + cone.volume());
    }
}
