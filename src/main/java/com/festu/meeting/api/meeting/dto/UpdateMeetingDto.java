package com.festu.meeting.api.meeting.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created on 3/24/2022
 *
 * @author Fedor Ishchenko
 */
public class UpdateMeetingDto {
    @NotBlank
    String title;
    @NotNull
    UUID authorId;
}
