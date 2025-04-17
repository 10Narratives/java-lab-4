package org.shapes;

import org.point.Point;

public class Line extends Shape {
    private final Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    @Override
    public Point getCentre() {
        return new Point((point.getX() + to.getX()) / 2, (point.getY() + to.getY()) / 2);
    }

    @Override
    public Line clone() {
        return (Line) super.clone();
    }
}
