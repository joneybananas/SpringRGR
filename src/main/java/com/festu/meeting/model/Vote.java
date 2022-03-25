package com.festu.meeting.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vote extends BaseEntity {

    @OneToOne
    @JoinColumn(nullable = false)
    Meeting meeting;

    LocalDateTime time;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "authorId")),
            @AttributeOverride(name = "name", column = @Column(name = "authorName"))
    })
    UserEntry author;
}
