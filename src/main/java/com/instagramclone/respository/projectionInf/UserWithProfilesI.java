package com.instagramclone.respository.projectionInf;

import com.instagramclone.entity.user.ProfilePhoto;

import java.util.List;

public interface UserWithProfilesI {
    Long getId();
    String getFullName();
    List<ProfilePhoto> getProfilePhotos();
}
