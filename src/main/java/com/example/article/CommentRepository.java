package com.example.article;

import com.example.article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository
        extends JpaRepository<Comment, Long> {
    List<Comment> findAllByArticleId(Long articleId);
}
