package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public final class SearchEngine {
    private final List<Searchable> searchableItems = new ArrayList<>();

    public void add(Searchable searchable) {
        if (searchable == null) {
            throw new IllegalArgumentException(
                    new StringBuilder("Элемент для поиска не может быть null").toString()
            );
        }
        searchableItems.add(searchable);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable searchable : searchableItems) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }
        return results;
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
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound(
                    new StringBuilder("Массив элементов для поиска пуст").toString()
            );
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
            throw new BestResultNotFound(
                    new StringBuilder("Не найдено совпадений").toString()
            );
        }

        return mostRelevant;
    }
}