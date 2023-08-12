package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Post {
//TODO add userId, created On
    private int postId;

    private int userId;

    private int likesCount;

    private String postDescription;

    private String urlImage;

    private Date createdOn;


    public Date getPostCreateTime() {
        return createdOn;
    }

    public void setPostCreateTime (Date createdTime){
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


    public int getLikesCount(){
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Post(){}

    public Post(int postId, int likesCount, String postDescription, String urlImage){
        this.postId = postId;
        this.likesCount = likesCount;
        this.postDescription = postDescription;
        this.urlImage = urlImage;
    }
}
