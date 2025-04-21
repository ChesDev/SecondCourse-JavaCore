package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return new StringBuilder(articleTitle)
                .append(".\n")
                .append(articleText)
                .toString();
    }

    @Override
    public String getSearchTerm() {
        return getArticleTitle();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle) && Objects.equals(articleText, article.articleText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleText);
    }
}