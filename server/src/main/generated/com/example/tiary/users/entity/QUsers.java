package com.example.tiary.users.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsers is a Querydsl query type for Users
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsers extends EntityPathBase<Users> {

    private static final long serialVersionUID = -1951501553L;

    public static final QUsers users = new QUsers("users");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public final EnumPath<com.example.tiary.users.constant.Role> role = createEnum("role", com.example.tiary.users.constant.Role.class);

    public final StringPath userPicture = createString("userPicture");

    public final EnumPath<com.example.tiary.users.constant.UserStatus> userStatus = createEnum("userStatus", com.example.tiary.users.constant.UserStatus.class);

    public QUsers(String variable) {
        super(Users.class, forVariable(variable));
    }

    public QUsers(Path<? extends Users> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsers(PathMetadata metadata) {
        super(Users.class, metadata);
    }

}

