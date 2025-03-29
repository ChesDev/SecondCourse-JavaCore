package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();


//------------------------- Добавление продукта в корзину ---------------------------------------------------------------------------

        productBasket.addProduct(new Product("Сыр", 100));
        productBasket.addProduct(new Product("Хлеб", 50));
        productBasket.addProduct(new Product("Колбаса", 300));
        productBasket.addProduct(new Product("Курица", 200));
        productBasket.addProduct(new Product("Вино", 700));
        line();


//------------------------- Добавление продукта в заполненную корзину ---------------------------------------------------------------

        System.out.println("Добавление продукта в заполненную корзину");
        productBasket.addProduct(new Product("Вино", 1400));
        line();

//------------------------- Печать содержимого корзины с несколькими товарами -------------------------------------------------------

        System.out.println("Печать содержимого корзины с несколькими товарами");
        productBasket.printBasket();
        line();

//------------------------- Получение стоимости корзины с несколькими товарами ------------------------------------------------------

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        line();

//------------------------- Поиск товара, который есть в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, который есть в корзине");
        String name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        line();

//------------------------- Поиск товара, которого нет в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, которого нет в корзине");
        name = "Ветчина";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        line();

//------------------------- Очистка корзины -----------------------------------------------------------------------------------------
        System.out.println("Печать содержимого корзины перед очисткой");
        productBasket.printBasket();
        productBasket.cleanBasket();
        line();

//------------------------- Печать содержимого пустой корзины -----------------------------------------------------------------------

        System.out.println("Печать содержимого пустой корзины");
        productBasket.printBasket();
        line();

//------------------------- Получение стоимости пустой корзины ----------------------------------------------------------------------

        System.out.println("Получение стоимости пустой корзины");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        line();

//------------------------- Поиск товара по имени в пустой корзине ------------------------------------------------------------------

        System.out.println("Поиск товара по имени в пустой корзине");
        name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        line();

    }

    public static void line() {
        System.out.println();
        System.out.println("====================================================================================================");
        System.out.println();
    }
}