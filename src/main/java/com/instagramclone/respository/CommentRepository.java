package com.instagramclone.respository;

import com.instagramclone.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(long postId);
    List<Comment> findByUserId(long userId);
}
