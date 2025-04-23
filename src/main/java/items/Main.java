package items;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Book", 10.0);
        DiscountedItem discountedItem1 = new DiscountedItem("Book", 10.0, 1.0);
        DiscountedItem discountedItem2 = new DiscountedItem("Book", 10.0, 2.0);

        System.out.println("item1.equals(discountedItem1): " + item1.equals(discountedItem1)); // true
        System.out.println("discountedItem1.equals(item1): " + discountedItem1.equals(item1)); // true

        System.out.println("item1.equals(discountedItem1): " + item1.equals(discountedItem1)); // true
        System.out.println("discountedItem1.equals(discountedItem2): " + discountedItem1.equals(discountedItem2)); // false
        System.out.println("item1.equals(discountedItem2): " + item1.equals(discountedItem2)); // true
    }
}
