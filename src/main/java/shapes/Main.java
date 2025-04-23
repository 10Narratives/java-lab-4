package shapes;

import point.Point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(0, 0);

        Shape circle = new Circle(point, 4);
        System.out.println(circle.getCenter());

        Shape rectangle = new Rectangle(point, 2, 2);
        System.out.println(rectangle.getCenter());

        Point lineEnd = new Point(2,2);
        Shape line = new Line(point, lineEnd);
        System.out.println(line.getCenter());
    }
}
