package com.zcl.Dao;

import com.zcl.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 项目名称：blogger
 * 描述：用户数据访问层
 *
 * @author zhong
 * @date 2022-06-25 12:17
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
