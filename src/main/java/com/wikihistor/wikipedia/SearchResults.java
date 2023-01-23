package com.wikihistor.wikipedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Arrays;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SearchResults {
    private String searchPhrase;
    private List<String> titles;
    private List<String> urls;

    public String displayTitles(){
        if(titles.isEmpty()){
            return "No results.";
        }else{
            return titles.toString();
        }
    }

}