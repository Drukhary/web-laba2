package drukhary.laba_2.AreaCheckingModel.Beans;

public class Point {
    public Point() {
    }

    public Point(double x, double y) {
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "AreaChecking.Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
