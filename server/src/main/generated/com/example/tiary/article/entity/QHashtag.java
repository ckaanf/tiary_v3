package com.example.tiary.article.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHashtag is a Querydsl query type for Hashtag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHashtag extends EntityPathBase<Hashtag> {

    private static final long serialVersionUID = -1794080923L;

    public static final QHashtag hashtag = new QHashtag("hashtag");

    public final ListPath<ArticleHashtag, QArticleHashtag> articleHashtags = this.<ArticleHashtag, QArticleHashtag>createList("articleHashtags", ArticleHashtag.class, QArticleHashtag.class, PathInits.DIRECT2);

    public final StringPath hashtagName = createString("hashtagName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QHashtag(String variable) {
        super(Hashtag.class, forVariable(variable));
    }

    public QHashtag(Path<? extends Hashtag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHashtag(PathMetadata metadata) {
        super(Hashtag.class, metadata);
    }

}

