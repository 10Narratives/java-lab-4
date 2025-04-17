package org.shapes;

import org.point.Point;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.height = height;
        this.width = width;
    }

    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    @Override
    public Point getCentre() {
        return new Point(point.getX() + width / 2, point.getY() - height / 2);
    }

    @Override
    public Rectangle clone() {
        return (Rectangle) super.clone();
    }
}
