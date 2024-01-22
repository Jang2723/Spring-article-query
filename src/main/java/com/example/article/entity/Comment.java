package com.example.article.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
CREATE TABLE comment(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    content TEXT,
    writer TEXT,
    article_id INTEGER
)
 */
@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String content;
    @Setter
    private String writer;

    @Setter
    @ManyToOne
    private Article article;

    public Comment(String content, String writer, Article article) {
        this.content = content;
        this.writer = writer;
        this.article = article;
    }
}
