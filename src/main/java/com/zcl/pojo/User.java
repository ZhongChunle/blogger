package com.zcl.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：blogger
 * 描述：用户实体类
 *
 * @author zhong
 * @date 2022-06-25 9:49
 */
@Data
@ToString
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 一个用户对应多篇博客
     */
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;

    private String nikname;

    private String username;
    private String password;
    private String email;
    /**
     * 头像
     */
    private String avatar;
    private Integer type;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", blogs=" + blogs +
                ", nikname='" + nikname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", createdDate=" + createdDate +
                ", updateTime=" + updateTime +
                '}';
    }
}
