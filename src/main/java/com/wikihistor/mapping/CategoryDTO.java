package com.wikihistor.mapping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private String categoryName;
    private List<String> articleNames; //Converted from List<Article>. Needs a mechanism to convert it back.
}
