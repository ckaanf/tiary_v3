package com.example.tiary.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = 1070960783L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QArticle article = new QArticle("article");

    public final com.example.tiary.global.audit.QAuditingFields _super = new com.example.tiary.global.audit.QAuditingFields(this);

    public final ListPath<ArticleHashtag, QArticleHashtag> articleHashtags = this.<ArticleHashtag, QArticleHashtag>createList("articleHashtags", ArticleHashtag.class, QArticleHashtag.class, PathInits.DIRECT2);

    public final com.example.tiary.category.entity.QCategory category;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath title = createString("title");

    public final com.example.tiary.users.entity.QUsers users;

    public final NumberPath<Integer> view = createNumber("view", Integer.class);

    public QArticle(String variable) {
        this(Article.class, forVariable(variable), INITS);
    }

    public QArticle(Path<? extends Article> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QArticle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QArticle(PathMetadata metadata, PathInits inits) {
        this(Article.class, metadata, inits);
    }

    public QArticle(Class<? extends Article> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.example.tiary.category.entity.QCategory(forProperty("category")) : null;
        this.users = inits.isInitialized("users") ? new com.example.tiary.users.entity.QUsers(forProperty("users")) : null;
    }

}

