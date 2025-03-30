package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private final double FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Фикс. цена! %s: %.2f ₽ ".formatted(getName(), getPrice());
    }
}
