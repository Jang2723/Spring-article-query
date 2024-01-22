package com.example.article;

import com.example.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // ID 순서대로 큰 최상위 20개
    List<Article> findTop20ByOrderByIdDesc();
    // ID 순서대로 큰, 특정 ID 이후의 게시글들 상위 20개
    // 특정 ID 이전 > ID가 특정 ID보다 작은
    List<Article> findTop20ByIdLessThanOrderByIdDesc(Long id);
}
