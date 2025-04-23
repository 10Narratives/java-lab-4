package task13;


import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Main {
    public static void printTable(Method method, double lowerBound, double upperBound, double step) {
        try {
            System.out.println("x\t|\t" + method.getName() + "(x)");
            System.out.println("---------------------------");

            for (double x = lowerBound; x <= upperBound; x += step) {
                // Вызываем метод через рефлексию
                Object result = method.invoke(null, x); // null, так как методы Math статические
                System.out.printf("%.2f\t|\t%s%n", x, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printTable(DoubleFunction<Object> function, double lowerBound, double upperBound, double step) {
        System.out.println("x\t|\tf(x)");
        System.out.println("---------------------------");

        for (double x = lowerBound; x <= upperBound; x += step) {
            // Вызываем функцию через apply
            Object result = function.apply(x);
            System.out.printf("%.2f\t|\t%s%n", x, result);
        }
    }

    public static void main(String[] args) {
        try {
            Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
            System.out.println("Таблица значений для Math.sqrt():");
            printTable(sqrtMethod, 0, 10, 1);

            System.out.println();

            Method toHexStringMethod = Double.class.getMethod("toHexString", double.class);
            System.out.println("Таблица значений для Double.toHexString():");
            printTable(toHexStringMethod, 0, 10, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // DoubleFunction<Object>
        System.out.println();

        DoubleFunction<Object> sqrtFunction = Math::sqrt;
        System.out.println("Таблица значений для Math.sqrt():");
        printTable(sqrtFunction, 0, 10, 1);

        System.out.println();

        DoubleFunction<Object> toHexStringFunction = Double::toHexString;
        System.out.println("Таблица значений для Double.toHexString():");
        printTable(toHexStringFunction, 0, 10, 1);

    }
}