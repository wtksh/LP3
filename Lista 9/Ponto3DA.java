
public class Ponto3DA {
    private Ponto2D ponto2d;
    private float z;

    public Ponto3DA(float x, float y, float z) {
        ponto2d = new Ponto2D(x, y);
        this.z = z;
    }
    
    public Ponto3DA(Ponto3DA ponto) {
        this(ponto.ponto2d.getX(), ponto.ponto2d.getY(), ponto.z);
    }

    public Ponto3DA() {
        this(0, 0, 0);
    }

    public String toString() {
        return "(" + ponto2d.getX() + ", " + ponto2d.getY() + ", " + z + ")";
    }

    public boolean inAxisX() {
        return ponto2d.inAxisX();
    }

    public boolean inAxisY() {
        return ponto2d.inAxisY();
    }

    public boolean inAxisZ() {
        return z == 0;
    }

    public boolean inAxis() {
        return ponto2d.inAxis() || z == 0;
    }

    public boolean isOrigin() {
        return ponto2d.isOrigin() && z == 0;
    }

    public float distance(float x, float y, float z) {
        return (float) Math.sqrt(((x - ponto2d.getX()) * (x - ponto2d.getX())) + ((y - ponto2d.getY()) * (y - ponto2d.getY())) + ((z - this.z) * (z - this.z)));
    }

    public float distance(Ponto3DA ponto) {
        return distance(ponto.ponto2d.getX(), ponto.ponto2d.getY(), ponto.z);
    }
}
