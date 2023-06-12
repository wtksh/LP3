
public class Ponto3DC extends Ponto2D {
    protected float z;

    public Ponto3DC(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Ponto3DC(Ponto3DC ponto) {
        this(ponto.x, ponto.y, ponto.z);
    }

    public Ponto3DC() {
        this(0, 0, 0);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public boolean inAxisZ() {
        return z == 0;
    }

    @Override
    public boolean inAxis() {
        return x == 0 || y == 0 || z == 0;
    }

    @Override
    public boolean isOrigin() {
        return x == 0 && y == 0 && z == 0;
    }

    public float distance(float x, float y, float z) {
        return (float) Math.sqrt(((x - this.x) * (x - this.x)) + ((y - this.y) * (y - this.y)) + ((z - this.z) * (z - this.z)));
    }

    public float distance(Ponto3DC ponto) {
        return distance(ponto.x, ponto.y, ponto.z);
    }
}
