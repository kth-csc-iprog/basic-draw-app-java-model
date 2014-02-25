package se.kth.csc.iprog.draw.model;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

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
        return getType() + " " + x + "," + y + "," + w + "," + h;
    }

    public String getType() {
        return getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1).toLowerCase();
    }

    public void writeTo(Writer out) throws IOException {
        Properties p = new Properties();
        p.put("type", getType());
        p.put("x", "" + getX());
        p.put("y", "" + getY());
        p.put("w", "" + getW());
        p.put("h", "" + getH());
        p.store(out, "");
    }

    public static Shape createShape(int type, double x, double y, double w, double h) {
        Shape shape;
        switch (type) {
            case ShapeContainer.ELLIPSE:
                shape = new Ellipse();
                break;
            case ShapeContainer.RECTANGLE:
                shape = new Rectangle();
                break;
            case ShapeContainer.SEGMENT:
                shape = new Segment();
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
        shape.setX(x);
        shape.setY(y);
        shape.setH(h);
        shape.setW(w);
        return shape;
    }

    static public Shape readFrom(Reader in) throws IOException {
        Properties p = new Properties();
        p.load(in);
        in.close();

        int type = -1;
        switch (p.getProperty("type")) {
            case "rectangle":
                type = ShapeContainer.RECTANGLE;
                break;
            case "ellipse":
                type = ShapeContainer.ELLIPSE;
                break;
            case "segment":
                type = ShapeContainer.SEGMENT;
                break;
        }
        return Shape.createShape(type, Double.parseDouble(p.getProperty("x")), Double.parseDouble(p.getProperty("y")),
            Double.parseDouble(p.getProperty("w")), Double.parseDouble(p.getProperty("h")));
    }

}
