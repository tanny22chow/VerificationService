package com.SpringDemo.VerificationService.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVerificationDetails is a Querydsl query type for VerificationDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVerificationDetails extends EntityPathBase<VerificationDetails> {

    private static final long serialVersionUID = 2138803138L;

    public static final QVerificationDetails verificationDetails = new QVerificationDetails("verificationDetails");

    public final StringPath applicantDetails = createString("applicantDetails");

    public final StringPath status = createString("status");

    public final NumberPath<Long> verification_id = createNumber("verification_id", Long.class);

    public final StringPath verifier_name = createString("verifier_name");

    public final DatePath<java.time.LocalDate> verifyDate = createDate("verifyDate", java.time.LocalDate.class);

    public QVerificationDetails(String variable) {
        super(VerificationDetails.class, forVariable(variable));
    }

    public QVerificationDetails(Path<? extends VerificationDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVerificationDetails(PathMetadata metadata) {
        super(VerificationDetails.class, metadata);
    }

}

