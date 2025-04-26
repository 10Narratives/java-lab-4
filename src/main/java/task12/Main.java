package task12;

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class NormalCaller {
    public long call() {
        long startTimeNormal = System.currentTimeMillis();
        PrintStream out = System.out;
        out.println("Hello, World");
        long endTimeNormal = System.currentTimeMillis();
        return endTimeNormal - startTimeNormal;
    }
}

class ReflectionCaller {
    public long call() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTimeReflection = System.currentTimeMillis();
        Class<?> printStreamClass = Class.forName("java.io.PrintStream");
        Method printlnMethod = printStreamClass.getDeclaredMethod("println", String.class);
        Object printStream = System.out;
        printlnMethod.invoke(printStream, "Hello, World");
        long endTimeReflection = System.currentTimeMillis();
        return endTimeReflection - startTimeReflection;
    }
}

public class Main {
    public static int iterations = 1_000_000;

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            NormalCaller normal = new NormalCaller();
            ReflectionCaller reflection = new ReflectionCaller();

            long timeNormal = 0;
            long timeReflection = 0;

            for (int i = 0; i < iterations; i++) {
                timeNormal += normal.call();
                timeReflection += reflection.call();
            }

            System.out.println("Время обычного вызова: " + timeNormal + " миллисекунд");
            System.out.println("Время вызова через рефлексию: " + timeReflection + " миллисекунд");
            System.out.println("Разница: " + (timeReflection - timeNormal) + " миллисекунд");

        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.err.println("Метод не найден: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
