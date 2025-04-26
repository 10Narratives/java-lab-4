package reflection_string;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class Reflection {
    public static String toString(Object object) {
        if (object == null) {
            return "";
        }
        Map<Object, Boolean> visited = new IdentityHashMap<>();
        return toStringHelper(object, visited);
    }

    private static String toStringHelper(Object object, Map<Object, Boolean> visited) {
        if (visited.containsKey(object)) {
            return "[...]";
        }

        visited.put(object, true);

        Class<?> clazz = object.getClass();
        StringBuilder builder = new StringBuilder();

        if (clazz.isArray()) {
            builder.append("[");
            int length = Array.getLength(object);
            for (int i = 0; i < length; i++) {
                if (i > 0) builder.append(", ");
                Object element = Array.get(object, i);
                if (element == null) {
                    builder.append("null");
                } else if (isPrimitiveOrWrapper(element)) {
                    builder.append(element);
                } else {
                    builder.append(toStringHelper(element, visited));
                }
            }
            builder.append("]");
        } else {
            if (clazz.getName().startsWith("java.")) {
                builder.append(clazz.getSimpleName()).append("@").append(Integer.toHexString(object.hashCode()));
            } else {
                builder.append(clazz.getSimpleName()).append("{");

                Field[] fields = clazz.getDeclaredFields();
                boolean firstField = true;

                for (Field field : fields) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) ||
                            java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                        continue;
                    }

                    if (!firstField) builder.append(", ");
                    firstField = false;

                    String fieldName = field.getName();

                    try {
                        field.setAccessible(true);


                        Object fieldValue = field.get(object);
                        if (fieldValue == null) {
                            builder.append(fieldName).append("=null");
                        } else if (isPrimitiveOrWrapper(fieldValue)) {
                            builder.append(fieldName).append("=").append(fieldValue);
                        } else if (field.getType().isArray()) {
                            builder.append(fieldName).append("=").append(toStringHelper(fieldValue, visited));
                        } else {
                            builder.append(fieldName).append("=").append(toStringHelper(fieldValue, visited));
                        }
                    } catch (IllegalAccessException exception) {
                        builder.append(fieldName).append("=<inaccessible>");
                    }
                }

                builder.append("}");
            }
        }

        visited.remove(object);

        return builder.toString();
    }
    private static boolean isPrimitiveOrWrapper(Object obj) {
        return obj instanceof Number || obj instanceof Character || obj instanceof Boolean || obj instanceof String;
    }

    static  class Example {
        int[] values = new int[]{1,2,3,4,5};
        String name = "Example";
        Map<String, String> map = new HashMap<>();
        Example next;

        public Example(int[] values, String name) {
            this.values = values;
            this.name = name;
            map.put("key1", "value1");
            map.put("key2", "value2");
        }
    }

    public static void main(String[] args) {
        Example example1 = new Example(new int[]{1,2,3,4,5}, "Example1");
        Example example2 = new Example(new int[]{5,6,78}, "Example2");
        example1.next = example2;
        example2.next = example1;
        System.out.println(toString(example1));
    }
}

