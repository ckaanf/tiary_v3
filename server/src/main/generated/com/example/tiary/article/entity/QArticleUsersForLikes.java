package com.example.tiary.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticleUsersForLikes is a Querydsl query type for ArticleUsersForLikes
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QArticleUsersForLikes extends BeanPath<ArticleUsersForLikes> {

    private static final long serialVersionUID = -1260255668L;

    public static final QArticleUsersForLikes articleUsersForLikes = new QArticleUsersForLikes("articleUsersForLikes");

    public final NumberPath<Long> articleId = createNumber("articleId", Long.class);

    public final NumberPath<Long> usersId = createNumber("usersId", Long.class);

    public QArticleUsersForLikes(String variable) {
        super(ArticleUsersForLikes.class, forVariable(variable));
    }

    public QArticleUsersForLikes(Path<? extends ArticleUsersForLikes> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticleUsersForLikes(PathMetadata metadata) {
        super(ArticleUsersForLikes.class, metadata);
    }

}

