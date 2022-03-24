package com.festu.meeting.utls;

@FunctionalInterface
public interface Function2<T1, T2, R> {
    R apply(T1 val1, T2 val2);
}
