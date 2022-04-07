package com.festu.meeting.api.article.dto;

import lombok.*;

import java.util.UUID;


/**
 * Generated by Thanos
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleListDto {

    // TODO edit manual
    UUID id;

    String content;

    Integer countDislike;

    Integer countLike;

    String name;

    UUID attachmentId;

}