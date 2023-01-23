package com.wikihistor.wikipedia;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wikihistor.wikipedia.SearchResults;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class WikipediaSearcher {
    private final String title;

    public WikipediaSearcher(String title) {
        this.title = "https://en.wikipedia.org/w/api.php?action=opensearch&search="+title+"&format=json";
    }

    public SearchResults searchForArticles() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(new URL(title));
            String searchPhrase = jsonNode.get(0).asText();
            List<String> titles = mapper.convertValue(jsonNode.get(1), new TypeReference<List<String>>(){});
            List<String> urls = mapper.convertValue(jsonNode.get(3), new TypeReference<List<String>>(){});
            return new SearchResults(searchPhrase, titles, urls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}