package com.example.tiary.admin.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWriteApproval is a Querydsl query type for WriteApproval
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWriteApproval extends EntityPathBase<WriteApproval> {

    private static final long serialVersionUID = 1806446178L;

    public static final QWriteApproval writeApproval = new QWriteApproval("writeApproval");

    public final NumberPath<Integer> articleCount = createNumber("articleCount", Integer.class);

    public final StringPath email = createString("email");

    public final StringPath nickname = createString("nickname");

    public final EnumPath<com.example.tiary.admin.constant.WriterStatus> status = createEnum("status", com.example.tiary.admin.constant.WriterStatus.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userPicture = createString("userPicture");

    public final EnumPath<com.example.tiary.users.constant.UserStatus> userStatus = createEnum("userStatus", com.example.tiary.users.constant.UserStatus.class);

    public QWriteApproval(String variable) {
        super(WriteApproval.class, forVariable(variable));
    }

    public QWriteApproval(Path<? extends WriteApproval> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWriteApproval(PathMetadata metadata) {
        super(WriteApproval.class, metadata);
    }

}

