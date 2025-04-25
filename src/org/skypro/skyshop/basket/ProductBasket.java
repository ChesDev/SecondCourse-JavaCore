package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();
    private final List<Product> deletedProducts = new LinkedList<>();

    public void addProduct(Product product) {
        String productName = product.getName();
        List<Product> productList = basket.getOrDefault(productName, new ArrayList<>());
        productList.add(product);
        basket.put(productName, productList);
    }

    public List<Product> deleteProductsByName(String name) {
        deletedProducts.clear();
        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            List<Product> products = entry.getValue();
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product != null && Objects.equals(product.getName(), name)) {
                    deletedProducts.add(product);
                    iterator.remove();
                }
            }
        }
        return deletedProducts;
    }

    public void printDeletedProducts() {
        StringBuilder sb = new StringBuilder("Список удаленных продуктов:\n");
        if (!deletedProducts.isEmpty()) {
            for (Product product : deletedProducts) {
                sb.append(product).append("\n");
            }
        } else {
            sb.append("Список пуст");
        }
        System.out.println(sb.toString());
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