package com.example.demo090.service;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.domain.User;

import java.util.List;

public interface UserService {
    public User findUserByUsernameAndPassword(String username, String password);
    public User createOne(UserReq userReq);
    public boolean isUserAlreadyReg(UserReq userReq);
}
