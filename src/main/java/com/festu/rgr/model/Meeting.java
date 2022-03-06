package com.festu.rgr.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
//    List<LocalDateTime> availableTime;
//    List<Vote> votes;

@Entity
@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Meeting {
    @Id
    @GeneratedValue
    UUID id;

    String title;

    @Embedded
    UserEntry author;
}
