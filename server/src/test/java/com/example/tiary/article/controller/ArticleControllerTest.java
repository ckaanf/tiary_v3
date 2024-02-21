package com.example.tiary.article.controller;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.tiary.article.WithMockCustomUser;
import com.example.tiary.article.dto.request.RequestArticleDeleteDto;
import com.example.tiary.article.dto.response.ResponseArticleDto;
import com.example.tiary.article.entity.Article;
import com.example.tiary.article.repository.ArticleRepository;
import com.example.tiary.article.service.ArticleLikesService;
import com.example.tiary.article.service.ArticleService;
import com.example.tiary.category.entity.Category;
import com.example.tiary.myPage.repository.UserRepository;
import com.example.tiary.users.constant.Role;
import com.example.tiary.users.constant.UserStatus;
import com.example.tiary.users.dto.UserDto;
import com.example.tiary.users.entity.Users;

@WebMvcTest(controllers = ArticleController.class)
@AutoConfigureMockMvc
class ArticleControllerTest {
	@InjectMocks
	private ArticleController articleController;

	@Autowired
	MockMvc mvc;

	@MockBean
	UserRepository userRepository;
	@MockBean
	ArticleRepository articleRepository;

	@MockBean
	ArticleService articleService;
	@MockBean
	ArticleLikesService articleLikesService;

	// @BeforeEach
	// @WithMockCustomUser
	// @Order(1)
	// void setArticle(){
	// 	UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	// 	Users users = userDto.getUsers();
	// 	Article article1 = new Article(
	// 		1L,
	// 		"title",
	// 		"content",
	// 		0,
	// 		new Category(1L,"001","test"),
	// 		users,
	// 		null
	// 	);
	// 	System.out.println(article1);
	// 	articleRepository.save(article1);
	// }

	private String jwtToken;

	@BeforeEach
	@Order(2)
	void setUpJwt() {
		// Create a JWT token
		this.jwtToken = createToken(1L, "test@gmail.com");

		// You can print the token for debugging purposes
		System.out.println("JWT Token: " + jwtToken);
	}

	private String createToken(Long id, String email) {
		return JWT.create()
			.withSubject(email)
			.withExpiresAt(new Date(System.currentTimeMillis()
				+ 3600000))
			.withClaim("id", id)
			.withClaim("email", email)
			.sign(Algorithm.HMAC512("test"));
	}

	@Test
	@WithMockCustomUser
	void getArticle() throws Exception {
		UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Article article = new Article(
			1L,
			"title",
			"content",
			0,
			new Category(1L, "001", "test"),
			userDto.getUsers(),
			new ArrayList<>()
		);
		when(articleService.readArticle(1L)).thenReturn(ResponseArticleDto.from(article));

		mvc.perform(get("/article/{article-id}", 1L))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(article.getId())) // 실제 반환되는 JSON의 필드와 값에 대한 검증
			.andExpect(jsonPath("$.title").value(article.getTitle()))
			.andExpect(jsonPath("$.content").value(article.getContent()))
			// 필요에 따라 다른 필드들도 검증할 수 있습니다.
			.andDo(print());
	}

	@DisplayName("게시물 단건 삭제 테스트")
	@Test
	@WithMockCustomUser
	void deleteArticle() throws Exception {
		// Given
		Long articleIdToDelete = 1L;
		Users currentUser = new Users(
			1L,
			"test",
			"test@gmail.com",
			Role.USER,
			null,
			UserStatus.ACTIVE
		);

		Article article = new Article(
			articleIdToDelete,
			"Test Title",
			"Test Content",
			0,
			new Category(1L, "001", "TestCategory"),
			currentUser,
			null
		);

		// When
		when(articleRepository.findById(articleIdToDelete)).thenReturn(Optional.of(article));
		doThrow(new RuntimeException("삭제 실패")).when(articleRepository).delete(article);
		when(articleService.deleteArticle(articleIdToDelete, currentUser.getId())).thenReturn("삭제 완료");

		// Then
		mvc.perform(delete("/article/{article-id}", articleIdToDelete)
				.contentType(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken)
				.with(csrf()))
			.andExpect(status().isResetContent())
			.andExpect(content().string("삭제 완료"))
			.andDo(print());

		// Verify
		verify(articleService, times(1)).deleteArticle(articleIdToDelete, currentUser.getId());
	}

	@DisplayName("게시물 다중 삭제 테스트")
	@Test
	@WithMockCustomUser
	void deleteArticleMultiple() throws Exception {

		Long[] list = new Long[] {1L, 2L};

		Map<String, Long[]> articleIdList = new HashMap<>();

		articleIdList.put("articleIdList", list);

		mvc.perform(delete("/article").contentType(MediaType.APPLICATION_JSON)
				.content(Arrays.toString(articleIdList.get("articleIdList"))))
			.andExpect(status().isResetContent())
			.andDo(print());
	}

	@DisplayName("게시물 다중 삭제 테스트")
	@Test
	@WithMockCustomUser
	void deleteArticles() throws Exception {
		// 전체 삭제는 articleId를 리스트로 받아서
		// 개별 삭제를 for문으로 돌게 짜보자

		Long[] list = new Long[] {1L, 2L};
		String requestArticleDeleteDto =
			"""
    			{ 
    				"articleIdList": [1,2]
    				}
				""";
		when(articleService.deleteArticle(list, eq(anyLong()))).thenReturn("삭제 완료");


		mvc.perform(delete("/article")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestArticleDeleteDto.toString())
				.with(csrf()))
			.andExpect(status().isResetContent())
			.andDo(print());
	}
}