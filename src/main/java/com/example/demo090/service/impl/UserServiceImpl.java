package com.example.demo090.service.impl;

import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.BookEntity;
import com.example.demo090.dao.entity.UserEntity;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.domain.Book;
import com.example.demo090.domain.User;
import com.example.demo090.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);
        User user = new User();
        BeanUtils.copyProperties(userEntity,user);
        return user;

    }

    @Override
    public User createOne(UserReq userReq) {
        //创建数据库实体类对象
        UserEntity userEntity = new UserEntity();
        //使用工具类进行拷贝
        BeanUtils.copyProperties(userReq, userEntity);
        //保存至数据库
        userRepository.save(userEntity);

        //创建domain对象用于返回
        User user = new User();
        //拷贝
        BeanUtils.copyProperties(userEntity, user);

        //返回
        return user;
    }

    /**
     * 查找看看用户名是否被使用
     * @param userReq
     * @return
     */
    @Override
    public boolean isUserAlreadyReg(UserReq userReq) {
        String username = userReq.getUsername();
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            return false;
        }
        else
            return true;
    }
}
