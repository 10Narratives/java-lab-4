package org.shapes;

import org.point.Point;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public Shape(double x, double y) {
        point = new Point(x, y);
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    public Point getCentre() {
        return point;
    }

    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            cloned.point = new Point(this.point.getX(), this.point.getY());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone Not Supported Exception for Shape", e);
        }
    }

}
