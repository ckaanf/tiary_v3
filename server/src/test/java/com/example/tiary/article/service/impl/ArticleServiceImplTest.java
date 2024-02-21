package com.example.tiary.article.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.tiary.article.entity.Article;
import com.example.tiary.article.repository.ArticleImageRepository;
import com.example.tiary.article.repository.ArticleRepository;
import com.example.tiary.article.service.ArticleLikesService;
import com.example.tiary.article.stub.TestStub;
import com.example.tiary.category.entity.Category;
import com.example.tiary.category.service.CategoryService;
import com.example.tiary.global.s3.service.S3UploadService;
import com.example.tiary.users.entity.Users;
import com.example.tiary.users.service.UserService;
@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {
	@InjectMocks
	private ArticleServiceImpl articleService;
	@Mock
	private ArticleRepository articleRepository;
	@Mock
	private ArticleImageRepository articleImageRepository;
	@Mock
	private CategoryService categoryService;
	@Mock
	private S3UploadService s3UploadService;
	@Mock
	private ArticleLikesService articleLikesService;
	@Mock
	private UserService userService;

	@DisplayName("다중 게시물 삭제 서비스 로직")
	@Test
	void testDeleteArticle() {
		// Mock data
		Users testUser = TestStub.createStubUser(1L);
		Category testCategory = TestStub.createStubCategory(1L);
		Article article = TestStub.createStubArticle(1L, testUser , testCategory);
		Long[] articleIdList = new Long[] {1L,2L};

		when(articleRepository.findById(anyLong())).thenReturn(Optional.of(article));

		when(userService.getUserById(anyLong())).thenReturn(testUser);

		String result = articleService.deleteArticle(articleIdList, testUser.getId());

		assertEquals("삭제 완료", result);

		verify(articleRepository, times(articleIdList.length)).findById(anyLong());
		verify(userService, times(1)).getUserById(anyLong());
	}
}
