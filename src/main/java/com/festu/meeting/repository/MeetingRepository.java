package com.festu.meeting.repository;

import com.festu.meeting.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MeetingRepository extends
        JpaRepository<Meeting, UUID>,
        QuerydslPredicateExecutor<Meeting> {
}
