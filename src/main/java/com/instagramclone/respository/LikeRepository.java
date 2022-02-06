package com.instagramclone.respository;

import com.instagramclone.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like,Long> {
    List<Like> findByPostId(long postId);
    List<Like> findByUserId(long userId);
}
