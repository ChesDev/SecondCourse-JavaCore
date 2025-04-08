package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Хомяк", 100);
        Product product2 = new DiscountedProduct("Хлеб", 50, 10);
        Product product3 = new FixPriceProduct("Колбаса");
        Product product4 = new SimpleProduct("Курица", 200);
        Product product5 = new SimpleProduct("Вино", 700);

//------------------------- Добавление продукта в корзину ---------------------------------------------------------------------------

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        printSeparator();


//------------------------- Добавление продукта в заполненную корзину ---------------------------------------------------------------

        System.out.println("Добавление продукта в заполненную корзину");
        productBasket.addProduct(new SimpleProduct("Вино", 1400));
        printSeparator();

//------------------------- Печать содержимого корзины с несколькими товарами -------------------------------------------------------

        System.out.println("Печать содержимого корзины с несколькими товарами");
        productBasket.printBasket();
        printSeparator();

//------------------------- Получение стоимости корзины с несколькими товарами ------------------------------------------------------

        System.out.println("Получение стоимости корзины с несколькими товарами");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        printSeparator();

//------------------------- Поиск товара, который есть в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, который есть в корзине");
        String name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        printSeparator();

//------------------------- Поиск товара, которого нет в корзине --------------------------------------------------------------------

        System.out.println("Поиск товара, которого нет в корзине");
        name = "Ветчина";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        printSeparator();

//------------------------- Очистка корзины -----------------------------------------------------------------------------------------
        System.out.println("Печать содержимого корзины перед очисткой");
        productBasket.printBasket();
        productBasket.cleanBasket();
        printSeparator();

//------------------------- Печать содержимого пустой корзины -----------------------------------------------------------------------

        System.out.println("Печать содержимого пустой корзины");
        productBasket.printBasket();
        printSeparator();

//------------------------- Получение стоимости пустой корзины ----------------------------------------------------------------------

        System.out.println("Получение стоимости пустой корзины");
        System.out.println("Общая стоимость корзины: " + productBasket.getSumProducts());
        printSeparator();

//------------------------- Поиск товара по имени в пустой корзине ------------------------------------------------------------------

        System.out.println("Поиск товара по имени в пустой корзине");
        name = "Хлеб";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        printSeparator();


        // Тестирование движка поиска
        Article article1 = new Article("Обучаем хомяка понимать ООП",
                "Объектно-ориентированное программирование (ООП) — это мощная парадигма,\n" +
                        "которая позволяет разработчикам создавать гибкие и масштабируемые программные решения.\n" +
                        "Но как объяснить концепции ООП так, чтобы они стали понятны даже хомяку?\n" +
                        "В этой статье мы проведем параллели между повадками хомяков и основными принципами ООП,\n" +
                        "чтобы сделать обучение увлекательным и доступным.");

        Article article2 = new Article("Маленькие мастера уюта",
                "Хомяки — это крошечные пушистики, чья жизнь выглядит как нескончаемый сериал \n" +
                        "о еде, сне и неожиданном беге в колесе. Эти грызуны, несмотря на свои скромные размеры,\n" +
                        "обладают харизмой, достойной блокбастера.");

        Article article3 = new Article("Карманные интроверты",
                "Эти ребята обожают уединение. Посади двух взрослых хомяков в одну клетку — и это уже не милый мультик,\n" +
                        "а триллер со смертельным исходом. Особенно, если это сирийские хомяки: у них личное пространство размером с Сахару.\n" +
                        "В общем, если вам нужен пушистый социопат, который смотрит на мир с подозрением, \n" +
                        "но всё равно милый — хомяк подойдёт идеально.");

        Article article4 = new Article("Генералы диванной обороны",
                "Хомяк — это животное, которое выглядит как комочек счастья, но ведёт себя как ветеран постапокалипсиса.\n" +
                        "Он всё прячет, всё боится, на всякий случай роет окопы в углу клетки и не доверяет даже своей поилке.");

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        String query = "Вино";
        Searchable[] searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "диван";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "молоко";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "Хлеб";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        query = "омя";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        System.out.println("Представление результатов поиска в виде имён:");
        for (Searchable searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println("Имя searchable: " + searchResult.getStringRepresentation());
            }
        }
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println("====================================================================================================");
        System.out.println();
    }
}