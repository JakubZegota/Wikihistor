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
    private String categoryName;
    private String content;
}
