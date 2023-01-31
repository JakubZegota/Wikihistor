package com.wikihistor.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ArticleDTO {
    private long id;
    private String title;
    private String categoryName; //mapped from Category type, needs a mechanism to convert it back
    private String content;
    private Set<String> userSet;
}
