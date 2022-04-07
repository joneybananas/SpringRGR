package com.festu.meeting.repository;

import com.festu.meeting.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.UUID;


/**
 * Generated by Thanos
 */

public interface ArticleRepository extends JpaRepository<Article, UUID>, QuerydslPredicateExecutor<Article> {
}