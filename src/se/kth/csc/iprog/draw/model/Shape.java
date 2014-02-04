package se.kth.csc.iprog.draw.model;

public abstract class Shape {

    double x, y, w, h;

    public abstract double getSurface();

    public double getX() {
        return x;
    }

    void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    void setW(double w) {
        if (w < 0)
            throw new IllegalArgumentException("Width must be positive");
        this.w = w;
    }

    public double getH() {
        return h;
    }

    void setH(double h) {
        if (h < 0)
            throw new IllegalArgumentException("Height must be postitive");
        this.h = h;
    }

    @Override
    public String toString() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf('.') + 1).toLowerCase() + " " + x + "," + y + "," + w + "," + h;
    }
}
