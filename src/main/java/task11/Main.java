package task11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            Class<?> systemClass = Class.forName("java.lang.System");

            Field outField = systemClass.getDeclaredField("out");
            outField.setAccessible(true);

            Object printStream = outField.get(null);

            Class<?> printStreamClass = Class.forName("java.io.PrintStream");
            Method printlnMethod = printStreamClass.getDeclaredMethod("println", String.class);

            printlnMethod.invoke(printStream, "Hello, World");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
