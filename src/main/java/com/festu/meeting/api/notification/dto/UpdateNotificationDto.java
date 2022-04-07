package com.festu.meeting.api.notification.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * Generated by Thanos
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNotificationDto {

    UUID articleId;

    String content;

    LocalDateTime creationDate;

    Boolean read;

    String title;

}