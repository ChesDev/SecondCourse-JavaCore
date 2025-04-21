package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final double price;
    private final int discount;

    public DiscountedProduct(String name, double price, int discount) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException(
                    new StringBuilder("Цена продукции не может быть отрицательной или равна нулю.").toString()
            );
        }
        this.price = price;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(
                    new StringBuilder("Размер скидки должен быть в диапазоне от 0 до 100%.").toString()
            );
        }
        this.discount = discount;
    }

    public double setDiscountedPrice(double price, int discount) {
        return price - (price / 100 * discount);
    }

    @Override
    public double getPrice() {
        return setDiscountedPrice(price, discount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder("Скидка! ")
                .append(getName())
                .append(": ")
                .append(String.format("%.2f", getPrice()))
                .append(" ₽ (")
                .append(discount)
                .append("%)")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(price, that.price) == 0 && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, discount);
    }
}