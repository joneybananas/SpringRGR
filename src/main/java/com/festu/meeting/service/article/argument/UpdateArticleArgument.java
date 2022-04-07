package com.festu.meeting.service.article.argument;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;


/**
 * Generated by Thanos
 */
@Value
@Builder
public class UpdateArticleArgument {

    String content;

    Integer countDislike;

    Integer countLike;

    String name;

    UUID attachmentId;

}
