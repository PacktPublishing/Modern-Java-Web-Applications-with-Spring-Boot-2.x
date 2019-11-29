package org.packt.springboot22.vid03.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBasket is a Querydsl query type for Basket
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBasket extends EntityPathBase<Basket> {

    private static final long serialVersionUID = -2033920137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBasket basket = new QBasket("basket");

    public final StringPath approvedBy = createString("approvedBy");

    public final DatePath<java.time.LocalDate> approvedDate = createDate("approvedDate", java.time.LocalDate.class);

    public final QHarvest harvest;

    public final NumberPath<Long> hid = createNumber("hid", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLogin login;

    public final DatePath<java.time.LocalDate> purchasedDate = createDate("purchasedDate", java.time.LocalDate.class);

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final NumberPath<Long> userid = createNumber("userid", Long.class);

    public QBasket(String variable) {
        this(Basket.class, forVariable(variable), INITS);
    }

    public QBasket(Path<? extends Basket> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBasket(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBasket(PathMetadata metadata, PathInits inits) {
        this(Basket.class, metadata, inits);
    }

    public QBasket(Class<? extends Basket> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.harvest = inits.isInitialized("harvest") ? new QHarvest(forProperty("harvest"), inits.get("harvest")) : null;
        this.login = inits.isInitialized("login") ? new QLogin(forProperty("login"), inits.get("login")) : null;
    }

}

