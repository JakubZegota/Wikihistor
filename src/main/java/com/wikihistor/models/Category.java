package com.wikihistor.models;

import com.wikihistor.models.Article;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Entity
public class Category {
    @Id
    @NonNull
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Article> articleList;


}
