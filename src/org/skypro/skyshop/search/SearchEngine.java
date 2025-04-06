package org.skypro.skyshop.search;

import java.util.Arrays;

public final class SearchEngine {
    private final Searchable[] searchableItems;

    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
    }

    public void add(Searchable searchable) {
        int Index = getIndex(searchableItems);
        searchableItems[Index] = searchable;
    }

    public static <S> int getIndex(S[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
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
}