package shapes;

import point.Point;

public class Circle extends Shape {
    private final double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Point getCenter() {
        return this.point;
    }
}
