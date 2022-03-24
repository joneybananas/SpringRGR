package com.festu.meeting.api.meeting.dto;

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
public class MeetingListDto {

    UUID id;

    String title;

    List<LocalDateTime> availableTime;

    Integer totalVotes;

}
