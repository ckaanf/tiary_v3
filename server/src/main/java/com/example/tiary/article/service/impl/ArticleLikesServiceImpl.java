package com.example.tiary.article.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tiary.article.entity.Article;
import com.example.tiary.article.entity.ArticleLikes;
import com.example.tiary.article.entity.ArticleUsersForLikes;
import com.example.tiary.article.repository.ArticleLikesRepository;
import com.example.tiary.article.repository.ArticleRepository;
import com.example.tiary.article.service.ArticleLikesService;
import com.example.tiary.article.service.ArticleService;
import com.example.tiary.global.exception.BusinessLogicException;
import com.example.tiary.global.exception.ExceptionCode;
import com.example.tiary.users.entity.Users;
import com.example.tiary.users.repository.UsersRepository;
import com.example.tiary.users.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArticleLikesServiceImpl implements ArticleLikesService  {
	private final ArticleLikesRepository articleLikesRepository;
	private final ArticleService articleService;
	private final UserService userService;

	@Transactional(readOnly = true)
	@Override
	public boolean getLikeState(Long articleId, Long usersId) {
		boolean result = false;
		Users users = userService.verifyingUsers(usersId);
		Article article = articleService.verifyingArticle(articleId);

		ArticleLikes articleLikes = articleLikesRepository.findArticleLikesByArticleUsersForLikes_ArticleIdAndArticleUsersForLikes_UsersId(
			article.getId(), users.getId());
		if (articleLikes != null)
			result = true;
		return result;
	}

	@Transactional
	@Override
	public boolean choiceLikes(Long articleId, Long usersId) {
		Users users = userService.verifyingUsers(usersId);
		Article article = articleService.verifyingArticle(articleId);

		ArticleUsersForLikes articleUsersForLikes = ArticleUsersForLikes.of(users.getId(), article.getId());
		ArticleLikes articleLikes = ArticleLikes.of(articleUsersForLikes);

		articleLikesRepository.save(articleLikes);
		return true;
	}

	@Transactional
	@Override
	public boolean cancleLikes(Long articleId, Long usersId) {
		Users users = userService.verifyingUsers(usersId);
		Article article = articleService.verifyingArticle(articleId);

		articleLikesRepository.deleteArticleLikesByArticleUsersForLikes(
			ArticleUsersForLikes.of(users.getId(), article.getId()));
		return true;
	}

	@Transactional
	@Override
	public boolean deleteLikes(Long articleId) {
		articleLikesRepository.deleteAllByArticleUsersForLikes_ArticleId(articleId);
		return true;
	}
}
