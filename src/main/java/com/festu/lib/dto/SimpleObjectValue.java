package com.festu.lib.dto;

import lombok.*;

/**
 * Created on 3/26/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SimpleObjectValue<T> {
    T value;
}
