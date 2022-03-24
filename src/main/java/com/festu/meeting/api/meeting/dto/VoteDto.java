package com.festu.meeting.api.meeting.dto;

import com.festu.meeting.model.UserEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Builder
@Setter
public class VoteDto {
    LocalDateTime time;
    UserEntry author;
}
