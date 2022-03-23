package com.instagramclone.service.impl;

import com.instagramclone.exception.UnexpectedException;
import com.instagramclone.payload.userDto.UserSuggestionsDto;
import com.instagramclone.respository.user.UserRepository;
import com.instagramclone.service.UserService;
import com.instagramclone.utils.ErrorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserSuggestionsDto> getUserSuggestions(int pageNo,int pageSize,String sortDir) {
       try{
           Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
           String loggedInUserName = authentication.getName();
           Pageable pageable = PageRequest.of(pageNo,pageSize);
           return userRepository.getUserSuggestions(loggedInUserName,pageable);
       } catch (Exception ex) {
           throw new UnexpectedException("Unexpected exception occurred, failed to fetch data. " + ex, ErrorConstants.UNEXCPECTED_ERROR_CODE);
       }
    }
}
