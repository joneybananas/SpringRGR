package com.festu.meeting.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


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

    @ElementCollection
    List<LocalDateTime> availableTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "meeting", cascade = CascadeType.REMOVE)
    List<Vote> votes;

    public Integer getVotesAmount() {
        return votes.size();
    }

}
