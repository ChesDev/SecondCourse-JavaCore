package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        String productName = product.getName();
        List<Product> productList = basket.getOrDefault(productName, new ArrayList<>());
        productList.add(product);
        basket.put(productName, productList);
    }


    public List<Product> deleteProductsByName(String name) {
        return basket.remove(name);
    }

    public void deleteAndPrintProductsByName(String name) {
        List<Product> deletedProducts = deleteProductsByName(name);
        StringBuilder sb = new StringBuilder("Список удаленных продуктов:\n");
        if (deletedProducts == null || deletedProducts.isEmpty()) {
            sb.append("Список пуст");
        } else {
            for (Product product : deletedProducts) {
                sb.append(product).append("\n");
            }
        }
        System.out.println(sb);
    }

    public double getSumProducts() {
        double sum = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    private boolean basketIsNotNull() {
        return !basket.isEmpty();
    }

    public void printBasket() {
        if (!basketIsNotNull()) {
            System.out.println("Корзина пуста!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        double sum = 0;
        int specialCount = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null) {
                    sb.append(product).append("\n");
                    sum += product.getPrice();
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
        }

        sb.append("--------------------------------------------------\n")
                .append(String.format("Итого: %.2f ₽\n", sum))
                .append(String.format("Специальных товаров: %d\n", specialCount));

        System.out.println(sb.toString());
    }

    public boolean checkProduct(String name) {
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null && Objects.equals(product.getName(), name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cleanBasket() {
        basket.clear();
    }
}