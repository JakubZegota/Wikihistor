package com.wikihistor.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
