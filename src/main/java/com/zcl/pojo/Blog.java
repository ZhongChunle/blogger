package com.zcl.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：blogger
 * 描述：博客实体类
 * @Entity 标识实体才能与数据库对上
 * @Table(name = "t_blog") 指定生成数据库的表明，否则就是实体名
 *
 * @author zhong
 * @date 2022-06-25 9:21
 */
@Entity
@Table(name = "t_blog")
public class Blog {
    public Blog() {

    }

    /**
     * @Id 标识主键
     * @GeneratedValue id生成策略
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 类型实体，多的一端，一篇博客对应多个类型
     */
    @ManyToOne
    private Type type;

    /**
     * 一篇博客对应多个标签，多对多关系
     * cascade = CascadeType.PERSIST 级联操作，当新增一个博客中有一个新的标签也会保存到数据库
     */
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tag> tags;

    /**
     * 一篇博客对应一个用户
     */
    @ManyToOne
    private User user;

    /**
     * 一篇博客对应多个评论
     */
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;

    /**
     * 标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;
    /**
     * 首图封面
     */
    private String firstPicture;
    /**
     * 标记
     */
    private String flag;
    /**
     * 浏览次数
     */
    private Integer views;
    /**
     * 是否开启赞赏
     */
    private boolean appreciation;
    /**
     * 转载声明是否开启
     */
    private boolean shareStatement;
    /**
     * 是否开启评论
     */
    private boolean commentabled;
    /**
     * 是否发布【保存草稿】
     */
    private boolean published;
    /**
     * 是否推荐
     */
    private boolean recommected;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommected() {
        return recommected;
    }

    public void setRecommected(boolean recommected) {
        this.recommected = recommected;
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
        return "Blog{" +
                "id=" + id +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommected=" + recommected +
                ", createdDate=" + createdDate +
                ", updateTime=" + updateTime +
                '}';
    }
}
