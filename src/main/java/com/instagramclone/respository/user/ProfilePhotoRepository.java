package com.instagramclone.respository.user;

import com.instagramclone.entity.user.ProfilePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto,Long> {
    Optional<ProfilePhoto> findByPublicUrl(String publicUrl);
    Optional<ProfilePhoto> findByPublicId(String publicId);
    List<ProfilePhoto> findByUserId(long userId);
}
