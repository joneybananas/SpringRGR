package com.festu.meeting.api.meeting.dto;

import com.festu.meeting.model.UserEntry;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
@Getter
@Setter
@Builder
public class MeetingDto {

    UUID id;

    String title;

    UserEntry author;

    List<LocalDateTime> availableTime;

    List<VoteDto> votes;

}
