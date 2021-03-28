package drukhary.laba_2.AreaChecking;

public class Point {
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "AreaChecking.Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
