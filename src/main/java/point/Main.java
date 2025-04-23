package point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(10, 20);
        Point anotherPoint = new Point(10, 20);
        LabeledPoint labeledPoint = new LabeledPoint(10, 20, "label");
        System.out.println(point);
        System.out.println(labeledPoint);

        System.out.println(point.equals(anotherPoint));
        System.out.println(labeledPoint.equals(point));
    }
}
