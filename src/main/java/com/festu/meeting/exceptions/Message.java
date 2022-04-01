package com.festu.meeting.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
@AllArgsConstructor
public class Message {

    String message;

    public static Message from(MethodArgumentNotValidException ex) {
        return new Message(ex.getBindingResult()
                             .getFieldError()
                             .getDefaultMessage());
    }

}
