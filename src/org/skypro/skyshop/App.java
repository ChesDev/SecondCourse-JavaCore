package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();


//------------------------- Добавление продукта в корзину ---------------------------------------------------------------------------

        productBasket.addProduct(new SimpleProduct("Сыр", 100));
        productBasket.addProduct(new DiscountedProduct("Хлеб", 50, 10));
        productBasket.addProduct(new FixPriceProduct("Колбаса"));
        productBasket.addProduct(new SimpleProduct("Курица", 200));
        productBasket.addProduct(new SimpleProduct("Вино", 700));
        separator();


//------------------------- Добавление продукта в заполненную корзину ---------------------------------------------------------------

        System.out.println("Добавление продукта в заполненную корзину");
        productBasket.addProduct(new SimpleProduct("Вино", 1400));
        separator();

//------------------------- Печать содержимого корзины с несколькими товарами -------------------------------------------------------

        System.out.println("Печать содержимого корзины с несколькими товарами");
        productBasket.printBasket();
        separator();

//------------------------- Получение стоимости корзины с несколькими товарами ------------------------------------------------------

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        separator();

//------------------------- Поиск товара, который есть в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, который есть в корзине");
        String name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        separator();

//------------------------- Поиск товара, которого нет в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, которого нет в корзине");
        name = "Ветчина";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        separator();

//------------------------- Очистка корзины -----------------------------------------------------------------------------------------
        System.out.println("Печать содержимого корзины перед очисткой");
        productBasket.printBasket();
        productBasket.cleanBasket();
        separator();

//------------------------- Печать содержимого пустой корзины -----------------------------------------------------------------------

        System.out.println("Печать содержимого пустой корзины");
        productBasket.printBasket();
        separator();

//------------------------- Получение стоимости пустой корзины ----------------------------------------------------------------------

        System.out.println("Получение стоимости пустой корзины");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        separator();

//------------------------- Поиск товара по имени в пустой корзине ------------------------------------------------------------------

        System.out.println("Поиск товара по имени в пустой корзине");
        name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        separator();

    }

    public static void separator() {
        System.out.println();
        System.out.println("====================================================================================================");
        System.out.println();
    }
}