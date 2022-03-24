package com.festu.meeting.utls;

import java.util.Collection;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static Boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
