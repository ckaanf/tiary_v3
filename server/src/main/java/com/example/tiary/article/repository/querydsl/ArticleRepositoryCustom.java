package com.example.tiary.article.repository.querydsl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.tiary.article.entity.Article;

public interface ArticleRepositoryCustom {


	List<Article> findArticlePagination(String categoryCode, int size, Long cursor);


	Page<Article> findArticlePaginationTest(Pageable pageable);
}
