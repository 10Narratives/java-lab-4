package shapes;

import point.Point;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point tl, double width, double height) {
        super(tl);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Point getCenter() {
        double centerX = this.point.getX() + width / 2;
        double centerY = this.point.getY() + height / 2;
        return new Point(centerX, centerY);
    }
}
