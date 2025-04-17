package org.point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(10, 10);
        System.out.println(point);

        LabeledPoint labeledPoint = new LabeledPoint(10, 10, "Interesting point");
        System.out.println(labeledPoint);

        System.out.println("point == labeledPoint " + point.equals(labeledPoint));
        System.out.println("labeledPoint == point " + labeledPoint.equals(point));
    }
}
