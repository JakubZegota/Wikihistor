package com.wikihistor.wikipedia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wikihistor.models.Article;
import java.io.IOException;
import java.net.URL;
import java.text.Normalizer;


public class ArticleImport {
    private final String title;

    public ArticleImport(String title) {
        var removeWhitespaces= title.replaceAll("\\s", "_");
        removeWhitespaces = Normalizer.normalize(removeWhitespaces, Normalizer.Form.NFD);
        this.title = removeWhitespaces.replaceAll("[^\\x00-\\x7F]", ""); //remove non ASCII characters
    }

    public Article searchForArticle() {
        String url = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + title;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(new URL(url));
            JsonNode queryNode = root.get("query");
            JsonNode pagesNode = queryNode.get("pages");
            JsonNode firstPageNode = pagesNode.elements().next();
            String name = firstPageNode.get("title").asText();
            String content = firstPageNode.get("extract").asText();
            return new Article(name, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
