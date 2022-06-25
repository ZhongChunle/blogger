package com.zcl.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：blogger
 * 描述：博客分类
 *
 * @author zhong
 * @date 2022-06-25 9:35
 */
@Entity
@Table(name = "t_type")
public class Type {


    @Id
    @GeneratedValue
    private Long id;

    /**
     * 一个类型对应多篇博客,需要指定关系
     */
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs;

    /**
     * 博客分类名称
     */
    private String name;

    public Type() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", blogs=" + blogs +
                ", name='" + name + '\'' +
                '}';
    }
}
