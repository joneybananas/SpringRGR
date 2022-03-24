package com.festu.meeting.utls;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class WhereClauseBuilder {
    private BooleanBuilder expression;

    private WhereClauseBuilder() {
    }

    private WhereClauseBuilder(BooleanExpression expression) {
        this.expression = new BooleanBuilder(expression);
    }

    public static WhereClauseBuilder getNew() {
        return new WhereClauseBuilder();
    }

    public static WhereClauseBuilder getNew(BooleanExpression initial) {
        return new WhereClauseBuilder(initial);
    }

    public <FieldType> WhereClauseBuilder optionalAnd(@Nullable FieldType value, Function<FieldType, BooleanExpression> doWhenValueExists) {
        if (value != null) {
            this.save((BooleanExpression) doWhenValueExists.apply(value), BooleanBuilder::and);
        }

        return this;
    }

    public WhereClauseBuilder conditionalAnd(boolean condition, Supplier<BooleanExpression> doWhenConditionIsTrue) {
        if (condition) {
            this.save((BooleanExpression) doWhenConditionIsTrue.get(), BooleanBuilder::and);
        }

        return this;
    }

    public WhereClauseBuilder optionalBooleanAnd(@Nullable Boolean flag, Supplier<BooleanExpression> doWhenConditionIsTrue, Supplier<BooleanExpression> doWhenConditionIsFalse) {
        if (flag != null) {
            Supplier<BooleanExpression> doWhenCondition = flag ? doWhenConditionIsTrue : doWhenConditionIsFalse;
            this.save((BooleanExpression) doWhenCondition.get(), BooleanBuilder::and);
        }

        return this;
    }

    public <FieldType> WhereClauseBuilder optionalOr(@Nullable FieldType value, Function<FieldType, BooleanExpression> doWhenValueExists) {
        if (value != null) {
            this.save((BooleanExpression) doWhenValueExists.apply(value), BooleanBuilder::or);
        }

        return this;
    }

    public WhereClauseBuilder conditionalOr(boolean condition, Supplier<BooleanExpression> doWhenConditionIsTrue) {
        if (condition) {
            this.save((BooleanExpression) doWhenConditionIsTrue.get(), BooleanBuilder::or);
        }

        return this;
    }

    public WhereClauseBuilder optionalStringAnd(@Nullable String value, Function<String, BooleanExpression> doWhenStringNotBlank) {
        if (StringUtils.hasText(value)) {
            this.save((BooleanExpression) doWhenStringNotBlank.apply(value), BooleanBuilder::and);
        }

        return this;
    }

    @SafeVarargs
    public final WhereClauseBuilder optionalAnyStringAnd(@Nullable String value, Function<String, BooleanExpression>... conditions) {
        if (!StringUtils.hasText(value)) {
            return this;
        } else if (conditions != null && conditions.length != 0) {
            BooleanExpression predicate = (BooleanExpression) conditions[0].apply(value);

            for (int i = 1; i < conditions.length; ++i) {
                BooleanExpression temp = (BooleanExpression) conditions[i].apply(value);
                predicate = predicate.or(temp);
            }

            this.save(predicate, BooleanBuilder::and);
            return this;
        } else {
            return this;
        }
    }

    public WhereClauseBuilder optionalStringOr(@Nullable String value, Function<String, BooleanExpression> doWhenStringNotBlank) {
        if (StringUtils.hasText(value)) {
            this.save((BooleanExpression) doWhenStringNotBlank.apply(value), BooleanBuilder::or);
        }

        return this;
    }

    public <CollectionType> WhereClauseBuilder optionalCollectionAnd(@Nullable Collection<CollectionType> value, Function<Collection<CollectionType>, BooleanExpression> doWhenCollectionIsNotEmpty) {
        if (!CollectionUtils.isEmpty(value)) {
            this.save((BooleanExpression) doWhenCollectionIsNotEmpty.apply(value), BooleanBuilder::and);
        }

        return this;
    }

    public <CollectionType> WhereClauseBuilder optionalCollectionOr(@Nullable Collection<CollectionType> value, Function<Collection<CollectionType>, BooleanExpression> doWhenCollectionIsNotEmpty) {
        if (!CollectionUtils.isEmpty(value)) {
            this.save((BooleanExpression) doWhenCollectionIsNotEmpty.apply(value), BooleanBuilder::or);
        }

        return this;
    }

    private void save(BooleanExpression value, Function2<BooleanBuilder, BooleanExpression, BooleanBuilder> joinExpression) {
        if (this.expression == null) {
            this.expression = new BooleanBuilder(value);
        } else {
            this.expression = (BooleanBuilder) joinExpression.apply(this.expression, value);
        }

    }

    public BooleanBuilder build() {
        return this.expression != null ? this.expression : new BooleanBuilder();
    }
}
