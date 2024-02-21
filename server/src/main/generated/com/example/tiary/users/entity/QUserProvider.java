package com.example.tiary.users.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserProvider is a Querydsl query type for UserProvider
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserProvider extends EntityPathBase<UserProvider> {

    private static final long serialVersionUID = -255651851L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserProvider userProvider = new QUserProvider("userProvider");

    public final StringPath providerSub = createString("providerSub");

    public final QUserProviderId userProviderId;

    public QUserProvider(String variable) {
        this(UserProvider.class, forVariable(variable), INITS);
    }

    public QUserProvider(Path<? extends UserProvider> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserProvider(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserProvider(PathMetadata metadata, PathInits inits) {
        this(UserProvider.class, metadata, inits);
    }

    public QUserProvider(Class<? extends UserProvider> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userProviderId = inits.isInitialized("userProviderId") ? new QUserProviderId(forProperty("userProviderId"), inits.get("userProviderId")) : null;
    }

}

