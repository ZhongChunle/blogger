package com.zcl.service;

import com.zcl.Dao.UserRepository;
import com.zcl.pojo.User;
import com.zcl.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 项目名称：blogger
 * 描述：用户接口是实现类
 *
 * @author zhong
 * @date 2022-06-25 12:15
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        //根据
        User user = userRepository.findByUsernameAndPassword(username, MD5Util.getMD5(password));
        return user;
    }
}
