package com.example.article;

import com.example.article.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
POST /articles/{id}/comments
GET /articles/{id}/comments
PUT /articles/{id}/comments/{commentId}
DELETE /articles/{id}/comments/{commentId}
 */
@Slf4j
@RestController
@RequestMapping("/articles/{articleId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;
    @PostMapping
    public CommentDto create(
            @PathVariable("articleId")
            Long articleId,
            @RequestBody
            CommentDto dto
    ) {
        return service.create(articleId, dto);
    }

    @GetMapping
    public List<CommentDto> readAll(
            @PathVariable("articleId")
            Long articleId
    ) {
        return service.readAll(articleId);
    }

    @PutMapping("{commentId}")
    public CommentDto update(
            @PathVariable("articleId")
            Long articleId,
            @PathVariable("commentId")
            Long commentId,
            @RequestBody
            CommentDto dto
    ) {
        return service.update(articleId, commentId, dto);
    }

    @DeleteMapping("{commentId}")
    public void delete(
            @PathVariable("articleId")
            Long articleId,
            @PathVariable("commentId")
            Long commentId
    ) {
        service.delete(articleId, commentId);
    }
}
