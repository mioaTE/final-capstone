package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;

public class Post {

    private int postId;

    private int userId;

    private int postLikes;
    @NotEmpty
    private String postDescription;
    @NotEmpty
    private String urlImage;

    private Date createdOn;


    public Date getPostCreateTime() {
        return createdOn;
    }

    public void setPostCreateTime(Date createdTime) {
        this.createdOn = createdTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikesCount() {
        return postLikes;
    }

    public void setLikesCount(int postLikes) {
        this.postLikes = postLikes;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Post() {
    }

    public Post(int postId, int postLikes, String postDescription, String urlImage) {
        this.postId = postId;
        this.postLikes= postLikes;
        this.postDescription = postDescription;
        this.urlImage = urlImage;
    }
}