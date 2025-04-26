package annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

public class AnnotationProcessor {
    public static <T> T set(Class<T> clazz, Map<String, Object> keyValuePairs) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        Map<String, Object> keyValues = keyValuePairs.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Field field : fields) {
            if (field.isAnnotationPresent(Key.class)) {
                String fieldName = field.getName();
                if (keyValues.containsKey(fieldName)) {
                    field.setAccessible(true);
                    Object value = keyValues.get(fieldName);
                    field.set(instance, value);
                }
            }
        }

        return instance;
    }
}
