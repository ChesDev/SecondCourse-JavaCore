package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;
import org.skypro.skyshop.article.Article;

import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Хомяк", 100);
        Product product2 = new DiscountedProduct("Хлеб", 50, 10);
        Product product3 = new FixPriceProduct("Колбаса");
        Product product4 = new SimpleProduct("Курица", 200);
        Product product5 = new SimpleProduct("Вино", 700);
        Product product6 = new SimpleProduct("Колбаса", 150);


        //Добавление продуктов в корзину
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.addProduct(product6);
        productBasket.addProduct(product3);
        printSeparator();


        //Демонстрация метода удаления продукта по имени из корзины
        System.out.print(new StringBuilder()
                .append("Демонстрация метода удаления продукта по имени из корзины\n")
                .append("Печать содержимого корзины перед демонстрацией\n\n"));
        productBasket.printBasket();

        System.out.println(new StringBuilder("\nУдаляем продукт с именем - Колбаса"));
        productBasket.deleteAndPrintProductsByName("Колбаса");
        System.out.println();
        productBasket.printBasket();

        System.out.println(new StringBuilder("\nУдаляем продукт с именем - Удочка"));
        productBasket.deleteAndPrintProductsByName("Удочка");
        System.out.println();
        productBasket.printBasket();
        printSeparator();


        //Печать содержимого корзины с несколькими товарами
        System.out.println(new StringBuilder("Печать содержимого корзины с несколькими товарами"));
        productBasket.printBasket();
        printSeparator();


        //Получение стоимости корзины с несколькими товарами
        System.out.println(new StringBuilder()
                .append("Получение стоимости корзины с несколькими товарами\n")
                .append("Общая стоимость корзины: ")
                .append(productBasket.getSumProducts()));
        printSeparator();


        //Поиск товара, который есть в корзине
        String name = "Хлеб";
        System.out.println(new StringBuilder()
                .append("Поиск товара, который есть в корзине\n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();


        //Поиск товара, которого нет в корзине
        name = "Ветчина";
        System.out.println(new StringBuilder()
                .append("Поиск товара, которого нет в корзине\n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();


        //Очистка корзины
        System.out.println(new StringBuilder("Печать содержимого корзины перед очисткой"));
        productBasket.printBasket();
        productBasket.cleanBasket();
        printSeparator();


        //Печать содержимого пустой корзины
        System.out.println(new StringBuilder("Печать содержимого пустой корзины"));
        productBasket.printBasket();
        printSeparator();


        //Получение стоимости пустой корзины
        System.out.println(new StringBuilder()
                .append("Получение стоимости пустой корзины\n")
                .append("Общая стоимость корзины: ")
                .append(productBasket.getSumProducts()));
        printSeparator();


        //Поиск товара по имени в пустой корзине
        name = "Хлеб";
        System.out.println(new StringBuilder()
                .append("Поиск товара по имени в пустой корзине\n")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();


        //Тестирование движка поиска
        Article article1 = new Article("Обучаем хомяка понимать ООП",
                """
                        Объектно-ориентированное программирование (ООП) — это мощная парадигма,
                        которая позволяет разработчикам создавать гибкие и масштабируемые программные решения.
                        Но как объяснить концепции ООП так, чтобы они стали понятны даже хомяку?
                        В этой статье мы проведем параллели между повадками хомяков и основными принципами ООП,
                        чтобы сделать обучение увлекательным и доступным.""");

        Article article2 = new Article("Маленькие мастера уюта. Хомяки",
                """
                        Хомяки — это крошечные пушистики, чья жизнь выглядит как нескончаемый сериал\s
                        о еде, сне и неожиданном беге в колесе. Эти грызуны, несмотря на свои скромные размеры,
                        обладают харизмой, достойной блокбастера.""");

        Article article3 = new Article("Карманные интроверты. Хомяки",
                """
                        Эти ребята обожают уединение. Посади двух взрослых хомяков в одну клетку — и это уже не милый мультик,
                        а триллер со смертельным исходом. Особенно, если это сирийские хомяки: у них личное пространство размером с Сахару.
                        В общем, если вам нужен пушистый социопат, который смотрит на мир с подозрением,\s
                        но всё равно милый — хомяк подойдёт идеально.""");

        Article article4 = new Article("Генералы диванной обороны. Хомяки",
                """
                        Хомяк — это животное, которое выглядит как комочек счастья, но ведёт себя как ветеран постапокалипсиса.
                        Он всё прячет, всё боится, на всякий случай роет окопы в углу клетки и не доверяет даже своей поилке.""");

        SearchEngine searchEngine = new SearchEngine();
        try {
            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(product4);
            searchEngine.add(product5);
            searchEngine.add(product6);
            searchEngine.add(product3);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
            searchEngine.add(article4);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder("Ошибка: " + ex.getMessage()));
            return;
        }

        String query = "Колбаса";
        System.out.println(new StringBuilder()
                .append("Результаты поиска ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "диван";
        System.out.println(new StringBuilder()
                .append("Результаты поиска ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "молоко";
        System.out.println(new StringBuilder()
                .append("Результаты поиска ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "Хлеб";
        System.out.println(new StringBuilder()
                .append("Результаты поиска ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));


        query = "омя";
        System.out.println(new StringBuilder()
                .append("Результаты поиска ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        System.out.println(new StringBuilder("Представление результатов поиска в виде имён:"));
        Map<String, Searchable> searchResults = searchEngine.search(query);
        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
            Searchable searchResult = entry.getValue();
            if (searchResult != null) {
                System.out.println(new StringBuilder()
                        .append("Имя searchable: ")
                        .append(searchResult.getStringRepresentation()));
            }
        }
        printSeparator();


        //Тестирование исключений класса Product и его наследников
        System.out.println(new StringBuilder("Создание SimpleProduct с пустым именем:"));
        try {
            Product product99 = new SimpleProduct("", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание SimpleProduct с пустым именем:"));
        try {
            Product product99 = new SimpleProduct("  ", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание SimpleProduct с некорректной ценой:"));
        try {
            Product product99 = new SimpleProduct("Курица", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание SimpleProduct с некорректной ценой:"));
        try {
            Product product99 = new SimpleProduct("", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание FixPriceProduct с некорректным именем:"));
        try {
            Product product99 = new FixPriceProduct(" ");
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание DiscountedProduct с некорректным именем:"));
        try {
            Product product99 = new DiscountedProduct(" ", 50, 10);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание DiscountedProduct с некорректной ценой:"));
        try {
            Product product99 = new DiscountedProduct("Хлеб", -1, 10);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создание DiscountedProduct с некорректной скидкой:"));
        try {
            Product product99 = new DiscountedProduct("Хлеб", 50, 101);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }
        printSeparator();


        //Тестирование обновленного движка поиска
        Searchable bestResult;

        query = "омя";
        System.out.println(new StringBuilder()
                .append("Поиск лучшего результата для ")
                .append(query)
                .append("..."));
        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Результаты поиска ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));
        } catch (BestResultNotFound ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }
        System.out.println();

        query = "Гиперболойд";
        System.out.println(new StringBuilder()
                .append("Поиск лучшего результата для ")
                .append(query)
                .append("..."));
        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Результаты поиска ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));
        } catch (BestResultNotFound ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

    }

    public static void printSeparator() {
        System.out.println(new StringBuilder("\n====================================================================================================\n"));
    }
}