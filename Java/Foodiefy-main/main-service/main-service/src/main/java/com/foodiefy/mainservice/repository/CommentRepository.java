package com.foodiefy.mainservice.repository;

import com.foodiefy.mainservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
