package reflection_string;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node2.next = node1; // Создаем циклическую ссылку

        System.out.println(Reflection.toString(node1));
    }
}
