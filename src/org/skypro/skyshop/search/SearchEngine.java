package org.skypro.skyshop.search;

import org.skypro.skyshop.exeptions.BestResultNotFound;

import java.util.Arrays;

public final class SearchEngine {
    private final Searchable[] searchableItems;

    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
    }

    public void add(Searchable searchable) {
        int Index = getNullIndex(searchableItems);
        searchableItems[Index] = searchable;
    }

    public static <S> int getNullIndex(S[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static <S> int getIndex(S[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                return i;
            }
        }
        return -1;
    }


    public static final int MAX_RESULTS = 5;

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_RESULTS];
        Arrays.fill(results, null);

        int i = 0;
        for (Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchTerm().contains(query)) {
                results[i++] = searchable;
                if (i >= MAX_RESULTS) {
                    break;
                }
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
        int firstIndex = getIndex(searchableItems);
        if (firstIndex == -1) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        Searchable mostRelevant = searchableItems[firstIndex];
        int maxCount = countMatches(mostRelevant.getSearchTerm(), query);

        for (Searchable searchable : searchableItems) {
            if (searchable != null) {
                int count = countMatches(searchable.getSearchTerm(), query);
                if (count > maxCount) {
                    maxCount = count;
                    mostRelevant = searchable;
                }
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("Не найдено совпадений");
        }

        return mostRelevant;
    }
}