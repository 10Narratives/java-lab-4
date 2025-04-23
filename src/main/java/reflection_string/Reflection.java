package reflection_string;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Reflection {
    public static String toString(Object obj) {
        Set<Object> visited = new HashSet<>();
        return toStringHelper(obj, visited);
    }

    private static String toStringHelper(Object obj, Set<Object> visited) {
        if (obj == null) {
            return "null";
        }

        if (visited.contains(obj)) {
            return "[cyclic reference]";
        }

        visited.add(obj);

        StringBuilder result = new StringBuilder();
        Class<?> clazz = obj.getClass();

        result.append(clazz.getName()).append(" {");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String fieldName = field.getName();
            Object fieldValue;
            try {
                fieldValue = field.get(obj);

                if (fieldValue != null && !isPrimitiveOrWrapper(fieldValue.getClass())) {
                    fieldValue = toStringHelper(fieldValue, visited);
                }

                result.append(fieldName).append("=").append(fieldValue);

                if (i < fields.length - 1) {
                    result.append(", ");
                }
            } catch (IllegalAccessException e) {
                result.append(fieldName).append("=[inaccessible]");
            }
        }

        result.append("}");
        return result.toString();
    }

    private static boolean isPrimitiveOrWrapper(Class<?> target) {
        return target.isPrimitive() ||
                target == Integer.class ||
                target == Long.class ||
                target == Double.class ||
                target == Float.class ||
                target == Boolean.class ||
                target == Character.class ||
                target == Byte.class ||
                target == Short.class;
    }
}
