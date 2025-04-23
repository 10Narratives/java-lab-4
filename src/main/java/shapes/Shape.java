package shapes;

import point.Point;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        double newX = this.point.getX() + dx;
        double newY = this.point.getY() + dy;
        this.point = new Point(newX, newY);
    }

    public abstract Point getCenter();
}
