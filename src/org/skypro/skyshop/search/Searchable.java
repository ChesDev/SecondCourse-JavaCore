package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return String.format("%s - %s", getSearchTerm(), getContentType());
    }

}
