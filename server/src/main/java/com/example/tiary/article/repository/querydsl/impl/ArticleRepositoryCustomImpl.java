package com.example.tiary.article.repository.querydsl.impl;

import static com.example.tiary.article.entity.QArticle.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.tiary.article.entity.Article;
import com.example.tiary.article.entity.QArticle;
import com.example.tiary.article.repository.querydsl.ArticleRepositoryCustom;
import com.example.tiary.category.entity.QCategory;
import com.example.tiary.users.entity.QUsers;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {
	public ArticleRepositoryCustomImpl(){
		super(Article.class);
	}

	@Override
	public List<Article> findArticlePagination(String categoryCode, int size, Long cursor) {
		QArticle article = QArticle.article;
		QUsers users = QUsers.users;
		QCategory category = QCategory.category;

		JPQLQuery<Article> query =
			from(article)
				.where(
					ltArticleId(cursor),
					eqCategoryCode(categoryCode)
				)
				.limit(size + 1)
				.orderBy(article.id.desc());

		return query.fetch();
	}

	@Override
	public Page<Article> findArticlePaginationTest(Pageable pageable) {
		QArticle article = QArticle.article;
		QUsers users = QUsers.users;
		QCategory category = QCategory.category;

		JPQLQuery<Article> query =
			from(article)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(article.id.desc());

		List<Article> articleList = query.fetch();
		Long total = query.fetchCount();

		return new PageImpl<>(articleList, pageable, total);
	}

	private BooleanExpression ltArticleId(Long cursor) {
		return cursor == null ? null : article.id.lt(cursor);
	}
	private BooleanExpression eqCategoryCode(String categoryCode){
		return categoryCode == null ? null : article.category.categoryCode.eq(categoryCode);
	}
}
