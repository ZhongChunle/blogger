package com.zcl.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 项目名称：blogger
 * 描述：博客标签
 *
 * @author zhong
 * @date 2022-06-25 9:38
 */
@Entity
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 一个标签对应多个篇博客，多对多关系
     */
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs;

    private String name;

    public Tag() {
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
        return "Tag{" +
                "id=" + id +
                ", blogs=" + blogs +
                ", name='" + name + '\'' +
                '}';
    }
}
