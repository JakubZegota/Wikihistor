package com.wikihistor;

import com.wikihistor.wikipedia.WikipediaSearcher;
import org.junit.jupiter.api.Test;

public class SearcherTest {

    @Test
    void TestSearching(){
        WikipediaSearcher wikipediaSearcher = new WikipediaSearcher("bem");
        var searchResults = wikipediaSearcher.searchForArticles();
        System.out.println(searchResults.displayTitles());

    }
}
