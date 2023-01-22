package com.wikihistor.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArticleDTO {
    private long id;
    private String title;
    private String categoryName; //mapped from Category type, needs a mechanism to convert it back
    private String content;
}
