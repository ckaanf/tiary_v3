package com.example.tiary.article.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.tiary.article.entity.Article;
import com.example.tiary.article.stub.TestStub;
import com.example.tiary.category.entity.Category;
import com.example.tiary.category.repository.CategoryRepository;
import com.example.tiary.global.config.JpaConfig;
import com.example.tiary.global.config.QuerydslConfig;
import com.example.tiary.users.entity.Users;
import com.example.tiary.users.repository.UsersRepository;

@ActiveProfiles("test")
@DataJpaTest
@Import({QuerydslConfig.class, JpaConfig.class})
class ArticleRepositoryTest {
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	UsersRepository usersRepository;

	/*
		1. 페이지 사이즈는 10
		2. categoryEquals(category)
		3.
	 */
	@DisplayName("커서 기반 페이지네이션 쿼리 테스트")
	@DirtiesContext
	@Test
	void findArticle(){

		Category category = TestStub.createStubCategory(1L);
		categoryRepository.save(category);

		Users users = TestStub.createStubUser(1L);
		usersRepository.save(users);

		for(long i = 1; i<=10; i++){
			articleRepository.save(
				TestStub.createStubArticle(i, users, category));
		}

		Pageable pageable = Pageable.ofSize(5);

		//When

		List<Article> findArticle = articleRepository.findArticlePagination(category.getCategoryCode(),4,null);
		List<Article> findArticle2 = articleRepository.findArticlePagination(category.getCategoryCode(),4,7L);
		List<Article> findArticle3 = articleRepository.findArticlePagination(category.getCategoryCode(),4,3L);

		Article article = findArticle.get(4);
		Article article2 = findArticle2.get(0);

		Article article3 = findArticle2.get(4);
		Article article4 = findArticle3.get(0);


		//Then
		Assertions.assertEquals(article3,article4);
	}
}