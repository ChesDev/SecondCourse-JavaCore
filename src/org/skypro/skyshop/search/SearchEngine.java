package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;


public final class SearchEngine {
    private final Set<Searchable> searchableItems = new HashSet<>();

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException("Элемент для поиска не может быть null");
        }
        searchableItems.add(searchable);
    }

    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = Comparator
                .comparingInt((Searchable s) -> s.getSearchTerm().length()).reversed()
                .thenComparing(Searchable::getSearchTerm);

        return searchableItems.stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>((comparator))));
    }

    public static int countMatches(String searchTerm, String query) {
        if (searchTerm.isEmpty() || query.isEmpty()) {
            return 0;
        }

        int count = 0, fromIndex = 0;
        int queryLength = query.length();
        while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) {
            count++;
            fromIndex += queryLength;
        }

        return count;
    }

    public Searchable searchMostRelevant(String query) throws BestResultNotFound {
        if (query == null || query.isEmpty()) {
            throw new IllegalArgumentException("Запрос не может быть пустым");
        }

        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        Searchable mostRelevant = null;
        int maxCount = -1;

        for (Searchable searchable : searchableItems) {
            int count = countMatches(searchable.getSearchTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostRelevant = searchable;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("Не найдено совпадений");
        }

        return mostRelevant;
    }
}