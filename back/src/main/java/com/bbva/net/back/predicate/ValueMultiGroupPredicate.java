package com.bbva.net.back.predicate;

import com.bbva.net.back.entity.MultiValueGroup;
import com.bbva.net.core.collection.BbvaPredicate;

public class ValueMultiGroupPredicate extends BbvaPredicate<MultiValueGroup> {

    private String name;

    public ValueMultiGroupPredicate(final String name) {
        this.name = name;
    }

    @Override
    protected boolean eval(MultiValueGroup multiValueGroup) {
        return multiValueGroup != null && multiValueGroup.getValue().equals(name);
    }
}
