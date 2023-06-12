
public class Ponto2D {
    protected float x;    // Ordenada
    protected float y;    // Abscissa

    public Ponto2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public Ponto2D(Ponto2D ponto) {
        this(ponto.x, ponto.y);
    }

    public Ponto2D() {
        this(0, 0);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean inAxisX() {
        return x == 0;
    }

    public boolean inAxisY() {
        return y == 0;
    }

    public boolean inAxis() {
        return x == 0 || y == 0;
    }

    public boolean isOrigin() {
        return x == 0 && y == 0;
    }

    public float distance (float x, float y) {
        return (float) Math.sqrt(((x - this.x) * (x - this.x)) + ((y - this.y) * (y - this.y)));
    }

    public float distance (Ponto2D ponto) {
        return distance(ponto.x, ponto.y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}