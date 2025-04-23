package shapes;

import point.Point;

public class Line extends Shape {
    private final Point end;

    public Line(Point start, Point end) {
        super(start);
        this.end = end;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public Point getCenter() {
        double centerX = (this.point.getX() + this.end.getX()) / 2 ;
        double centerY = (this.point.getY() + this.end.getY()) / 2;
        return new Point(centerX, centerY);
    }
}
