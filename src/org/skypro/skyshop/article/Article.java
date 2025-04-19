package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final StringBuilder articleTitle;
    private final StringBuilder articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = new StringBuilder(articleTitle);
        this.articleText = new StringBuilder(articleText);
    }

    public String getArticleTitle() {
        return articleTitle.toString();
    }

    public String getArticleText() {
        return articleText.toString();
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
        return Objects.equals(articleTitle.toString(), article.articleTitle.toString()) &&
                Objects.equals(articleText.toString(), article.articleText.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle.toString(), articleText.toString());
    }
}