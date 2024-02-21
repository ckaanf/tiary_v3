package com.example.tiary.article.stub;

import java.util.ArrayList;

import com.example.tiary.article.entity.Article;
import com.example.tiary.category.entity.Category;
import com.example.tiary.users.constant.Role;
import com.example.tiary.users.constant.UserStatus;
import com.example.tiary.users.entity.Users;

public class TestStub {

	public static Article createStubArticle(Long id, Users users, Category category){
		return Article.of(
			id,
			"title" + id,
			"content" + id,
			0,
			category,
			users,
			new ArrayList<>()
		);
	}

	public static Category createStubCategory(Long id){
		return Category.of(
			id,
			"001"
			, "test"
		);
	}

	public static Users createStubUser(Long id){
		return new Users(
			id,
			"test",
			"test@gmail.com",
			Role.USER,
			null,
			UserStatus.ACTIVE
		);
	}

}
