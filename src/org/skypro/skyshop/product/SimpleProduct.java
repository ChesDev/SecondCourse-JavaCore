package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final double price;

    public SimpleProduct(String name, double price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException(
                    new StringBuilder("Цена продукции не может быть отрицательной или равна нулю.").toString()
            );
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(getName())
                .append(": ")
                .append(String.format("%.2f ₽", getPrice()))
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}