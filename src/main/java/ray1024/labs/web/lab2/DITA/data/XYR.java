package ray1024.labs.web.lab2.DITA.data;

public class XYR implements IXYR {
    double x, y, r;

    @Override
    public double getX() {
        return x;
    }

    @Override
    public IXYR setX(double x) {
        this.x = x;
        return this;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public IXYR setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public double getR() {
        return r;
    }

    @Override
    public IXYR setR(double r) {
        this.r = r;
        return this;
    }
}
