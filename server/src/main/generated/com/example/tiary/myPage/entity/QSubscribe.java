package com.example.tiary.myPage.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubscribe is a Querydsl query type for Subscribe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscribe extends EntityPathBase<Subscribe> {

    private static final long serialVersionUID = -270312762L;

    public static final QSubscribe subscribe = new QSubscribe("subscribe");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> writerId = createNumber("writerId", Long.class);

    public QSubscribe(String variable) {
        super(Subscribe.class, forVariable(variable));
    }

    public QSubscribe(Path<? extends Subscribe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubscribe(PathMetadata metadata) {
        super(Subscribe.class, metadata);
    }

}

