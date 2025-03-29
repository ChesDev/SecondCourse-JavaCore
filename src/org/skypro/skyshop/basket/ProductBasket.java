package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private final Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");

    }

    public double getSumProducts() {
        double sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    private boolean basketIsNotNull() {
        for (Product product : basket) {
            if (product != null) {
                return true;
            }
        }
        return false;
    }

    public void printBasket() {
        if (basketIsNotNull()) {
            for (Product product : basket) {
                if (product != null) {
                    System.out.println(product);
                }
            }
            System.out.println(getSumProducts());
        } else {
            System.out.println("Корзина пуста!");
        }
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                basket[i] = null;
            }
        }
    }
}