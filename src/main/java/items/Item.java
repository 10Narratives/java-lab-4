package items;

import java.util.Objects;

public class Item {
    protected String description;
    protected double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        if (description.isEmpty())
            throw new IllegalArgumentException("description cannot be empty");
        this.description = description;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("price cannot be empty");
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Double.compare(price, item.price) == 0 && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price);
    }
}
