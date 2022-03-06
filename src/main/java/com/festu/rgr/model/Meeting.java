package com.festu.rgr.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
//    List<LocalDateTime> availableTime;
//    List<Vote> votes;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Meeting extends BaseEntity {
    String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "authorId")),
            @AttributeOverride(name = "name", column = @Column(name = "authorName"))
    })
    UserEntry author;
}
