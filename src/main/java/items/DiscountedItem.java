package items;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (!(0 <= discount && discount <= 1))
            throw new IllegalArgumentException("discount is out of range");
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        if (!(o instanceof DiscountedItem that))
            return super.equals(o);
        return super.equals(o) && Double.compare(that.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
