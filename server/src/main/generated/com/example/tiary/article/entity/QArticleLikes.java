package com.example.tiary.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticleLikes is a Querydsl query type for ArticleLikes
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticleLikes extends EntityPathBase<ArticleLikes> {

    private static final long serialVersionUID = 260686957L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticleLikes articleLikes = new QArticleLikes("articleLikes");

    public final QArticleUsersForLikes articleUsersForLikes;

    public QArticleLikes(String variable) {
        this(ArticleLikes.class, forVariable(variable), INITS);
    }

    public QArticleLikes(Path<? extends ArticleLikes> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticleLikes(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticleLikes(PathMetadata metadata, PathInits inits) {
        this(ArticleLikes.class, metadata, inits);
    }

    public QArticleLikes(Class<? extends ArticleLikes> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.articleUsersForLikes = inits.isInitialized("articleUsersForLikes") ? new QArticleUsersForLikes(forProperty("articleUsersForLikes")) : null;
    }

}

