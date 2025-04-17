package org.shapes;

import org.point.Point;

public class Circle extends Shape {
    private final double radius;

    public Circle(Point centre, double radius) {
        super(centre);
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this(new Point(x, y), radius);
    }

    @Override
    public Circle clone() {
        return (Circle) super.clone();
    }

    public double getRadius() {
        return radius;
    }
}
