package com.example.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QueryController {
    private final ArticleService service;

    // GET /query-example?query=keyword&limit=20 HTTP/1.1
    @GetMapping("/query-example")
    public String queryParams(
            @RequestParam("query")
            String query,
            // 받을 자료형 선택 가능
            // 만약 변환 불가일 경우,BAD_REQUEST (400)
            @RequestParam("limit")
            Integer limit,
            // 반드시 포함해야 하는지 아닌지를 required로 정의 가능
            @RequestParam(value = "notreq",required = false)
            String notRequired,
            // 기본값 설정을 원한다면 defaultValue
            @RequestParam(value = "default",defaultValue = "hello")
            String defaultVal
    ){
        log.info("query: " + query);
        log.info("limit: " + limit);
        log.info("notRequired: " + notRequired);
        log.info("default: " + defaultVal);
        return "done";
    }

    // GET /query-page?page=1&perpage=25
    @GetMapping("/query-page")
    public Object queryPage(
            @RequestParam(value = "page", defaultValue = "1")
            Integer page,
            @RequestParam(value = "perpage", defaultValue = "25")
            Integer perPage
    ){
        log.info("page: " + page);
        log.info("perPage: " + perPage);
        /*Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("page",page);
        responseBody.put("perPage", perPage);
        return responseBody;*/
        return service.readArticlePaged(page,perPage);
    }

    // GET /query-search?q=keyword&cat=writer
    @GetMapping("/query-search")
    public String querySearch(
            @RequestParam("q")
            String keyword,
            @RequestParam(value = "cat",defaultValue = "title")
            String category
    ){
        log.info("keyword: " + keyword );
        log.info("category: " + category);
        return "done";
    }
}
