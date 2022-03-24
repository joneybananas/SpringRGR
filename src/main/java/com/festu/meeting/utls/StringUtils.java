package com.festu.meeting.utls;

import org.springframework.lang.Nullable;

public class StringUtils {
    private StringUtils() {

    }

    public static Boolean hasText(@Nullable String text) {
        return text != null && text.replace(" ", "").length() > 0;
    }
}
