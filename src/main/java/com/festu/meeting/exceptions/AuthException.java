package com.festu.meeting.exceptions;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
public class AuthException extends RuntimeException {

    public AuthException() {
        super("Unauthorized");
    }

}
