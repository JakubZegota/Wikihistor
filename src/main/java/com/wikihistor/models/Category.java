package com.wikihistor.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Entity

public class Category {
    @Id
    @NonNull
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "category")
    private List<Article> articleList = new ArrayList<>();

    public void addArticle(Article article){
        article.setCategory(this);
        articleList.add(article);
    }

}
