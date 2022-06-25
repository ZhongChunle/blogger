package com.zcl.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：blogger
 * 描述：评论内容
 *
 * @author zhong
 * @date 2022-06-25 9:39
 */
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 一个父类评论包含多个子类评论
     */
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments;

    /**
     * 一个子类对应一个父类对象
     */
    @ManyToOne
    private Comment parentComment;

    @ManyToOne
    private Blog blog;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 头像
     */
    private String avater;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", blog=" + blog +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avater='" + avater + '\'' +
                ", creationTime='" + creationTime + '\'' +
                '}';
    }
}
