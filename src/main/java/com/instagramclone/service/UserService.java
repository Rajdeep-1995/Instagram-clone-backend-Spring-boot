package com.instagramclone.service;

import com.instagramclone.payload.userDto.UserSuggestionsDto;

import java.util.List;

public interface UserService {
    List<UserSuggestionsDto> getUserSuggestions(int pageNo,int pageSize,String sortDir);

}
