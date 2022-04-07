package com.festu.meeting.repository;

import com.festu.meeting.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;


/**
 * Generated by Thanos
 */
public interface AttachmentRepository extends JpaRepository<Attachment, UUID>, QuerydslPredicateExecutor<Attachment> {
}