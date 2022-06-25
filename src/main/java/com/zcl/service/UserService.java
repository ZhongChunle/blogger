package com.zcl.service;

import com.zcl.pojo.User;

/**
 * 项目名称：blogger
 * 描述：用户业务层接口
 *
 * @author zhong
 * @date 2022-06-25 12:13
 */
public interface UserService {
    /**
     * 检测用户
     * @param username
     * @param password
     * @return
     */
     User checkUser(String username, String password);
}
