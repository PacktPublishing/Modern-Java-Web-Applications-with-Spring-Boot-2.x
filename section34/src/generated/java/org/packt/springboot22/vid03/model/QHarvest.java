package org.packt.springboot22.vid03.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHarvest is a Querydsl query type for Harvest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHarvest extends EntityPathBase<Harvest> {

    private static final long serialVersionUID = -1892523048L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHarvest harvest = new QHarvest("harvest");

    public final DatePath<java.time.LocalDate> approvedDate = createDate("approvedDate", java.time.LocalDate.class);

    public final SetPath<Basket, QBasket> basket = this.<Basket, QBasket>createSet("basket", Basket.class, QBasket.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocation location;

    public final StringPath name = createString("name");

    public final NumberPath<Float> price = createNumber("price", Float.class);

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final StringPath status = createString("status");

    public final StringPath type = createString("type");

    public QHarvest(String variable) {
        this(Harvest.class, forVariable(variable), INITS);
    }

    public QHarvest(Path<? extends Harvest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHarvest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHarvest(PathMetadata metadata, PathInits inits) {
        this(Harvest.class, metadata, inits);
    }

    public QHarvest(Class<? extends Harvest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
    }

}

