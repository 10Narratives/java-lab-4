package annotation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ExampleClass {
    @Key
    private String name;

    @Key
    private int age;

    @Key
    private int[] array;

    private boolean active;

    @Override
    public String toString() {
        return "ExampleClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", array=" + Arrays.toString(array) +
                ", active=" + active +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Object> keyValuePairs = new HashMap<>();
        keyValuePairs.put("name", "John Doe");
        keyValuePairs.put("age", 30);
        keyValuePairs.put("active", true);
        keyValuePairs.put("array", new int[]{1,2,3,4,5,6});


        ExampleClass example = AnnotationProcessor.set(ExampleClass.class, keyValuePairs);

        System.out.println(example);
    }
}