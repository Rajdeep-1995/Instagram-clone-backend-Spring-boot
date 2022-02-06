package com.instagramclone.respository;

import com.instagramclone.entity.PostMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostMediaRepository extends JpaRepository<PostMedia,Long> {
    Optional<PostMedia> findByPublicUrl(String publicUrl);
    Optional<PostMedia> findByPublicId(String publicId);
    List<PostMedia> findByPostId(long postId);
}
