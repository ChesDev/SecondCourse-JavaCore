package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

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
        System.out.println("Список удаленных продуктов:\n");
        if (deletedProducts == null || deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            deletedProducts.forEach(System.out::println);
        }
    }

    public double getSumProducts() {
        return basket.values().stream().flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private boolean basketIsNull() {
        return basket.isEmpty();
    }

    private long getSpecialCount() {
        return basket.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (basketIsNull()) {
            System.out.println("Корзина пуста!");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Stream<Product> productBasket = basket.values().stream().flatMap(Collection::stream);
            productBasket.forEach(System.out::println);
            sb.append("--------------------------------------------------\n")
                .append(String.format("Итого: %.2f ₽\n", getSumProducts()))
                .append(String.format("Специальных товаров: %d\n", getSpecialCount()));
        System.out.println(sb);
    }

    public boolean checkProduct(String name) {
        return basket.values().stream().flatMap(Collection::stream)
                .anyMatch(p->p.getName().equalsIgnoreCase(name));
    }

    public void cleanBasket() {
        basket.clear();
    }
}