package se.kth.csc.iprog.draw.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class ShapeContainer extends Observable {

    public static final int ELLIPSE = 10;

    public static final int RECTANGLE = 20;

    public static final int SEGMENT = 30;

    List<Shape> shapes = new ArrayList<Shape>();

    public void removeShape(Shape shape) throws IllegalArgumentException {
        if (!shapes.contains(shape))
            throw new IllegalArgumentException("Shape doesn't exist in the model");
        shapes.remove(shape);
        setChanged();
        notifyObservers();
    }

    public Shape addShape(int type, double x, double y, double w, double h) throws IllegalArgumentException {
        return addShape(type, x, y, w, h, shapes.size());
    }

    public Shape addShape(int type, double x, double y, double w, double h, int index) throws IllegalArgumentException {
        Shape shape;
        switch (type) {
            case ELLIPSE:
                shape = new Ellipse();
                break;
            case RECTANGLE:
                shape = new Rectangle();
                break;
            case SEGMENT:
                shape = new Segment();
                break;
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
        shape.setX(x);
        shape.setY(y);
        shape.setH(h);
        shape.setW(w);
        shapes.add(index, shape);
        setChanged();
        notifyObservers();
        return shape;
    }

    /**
     * List the shapes in the model
     * 
     * @return an unmodifiable list of shapes
     */
    public List<Shape> getAllShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public void modifyShape(Shape shape, double x, double y, double w, double h) throws IllegalArgumentException {
        shape.setX(x);
        shape.setY(y);
        shape.setH(h);
        shape.setW(w);
        setChanged();
        notifyObservers();
    }
}
