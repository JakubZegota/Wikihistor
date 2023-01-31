package com.wikihistor.mapping;

import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    @NonNull
    private String categoryName;
    private List<String> articleNames; //Converted from List<Article>. Needs a mechanism to convert it back.
    private List<String> userNames;
}
