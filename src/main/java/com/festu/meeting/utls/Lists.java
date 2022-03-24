package com.festu.meeting.utls;

import java.util.*;

public final class Lists {
    private Lists() {

    }

    public static <E> ArrayList<E> newList(Iterable<? extends E> elements) {
        ArrayList<E> result = new ArrayList<>();
        for (E item : elements) {
            result.add(item);
        }
        return result;
    }
}
