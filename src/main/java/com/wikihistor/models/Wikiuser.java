package com.wikihistor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wikiuser {
    @Id
    private String login;
    private String password;

    @ManyToMany(mappedBy = "assignedWikiusers")
    private Set<Article> assignedArticles = new HashSet<>();

    public Wikiuser(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
