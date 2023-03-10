package com.wikihistor.wikipedia;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchResults {
    private String searchPhrase;
    private List<String> titles;
    private List<String> urls;

    public SearchResults(String searchPhrase, List<String> titles, List<String> urls) {
        this.searchPhrase = searchPhrase;
        this.titles = titles;
        this.urls = urls;

    }

    public String displayTitles() {
        if (titles.isEmpty()) {
            return "No results.";
        } else {
            return titles.toString();
        }
    }

}