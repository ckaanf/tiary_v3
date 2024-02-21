package com.example.tiary.users.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserProviderId is a Querydsl query type for UserProviderId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QUserProviderId extends BeanPath<UserProviderId> {

    private static final long serialVersionUID = -868290576L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserProviderId userProviderId = new QUserProviderId("userProviderId");

    public final EnumPath<com.example.tiary.users.constant.Provider> provider = createEnum("provider", com.example.tiary.users.constant.Provider.class);

    public final QUsers users;

    public QUserProviderId(String variable) {
        this(UserProviderId.class, forVariable(variable), INITS);
    }

    public QUserProviderId(Path<? extends UserProviderId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserProviderId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserProviderId(PathMetadata metadata, PathInits inits) {
        this(UserProviderId.class, metadata, inits);
    }

    public QUserProviderId(Class<? extends UserProviderId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

