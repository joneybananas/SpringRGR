package com.festu.rgr.repository;

import com.festu.rgr.model.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;

public interface MeetingRepository extends
        JpaRepository<Meeting, UUID>,
        JpaSpecificationExecutor<Meeting>,
        QuerydslPredicateExecutor<Meeting> {
}
