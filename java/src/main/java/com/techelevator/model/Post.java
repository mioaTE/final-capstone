package com.techelevator.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;

public class Post {

    private int postId;

    private int userId;

    private int likesCount;
    @NotEmpty
    private String postDescription;
    @NotEmpty
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

    public void setUsername(String username) {
    }

    public void setDatePosted(LocalDateTime datePosted) {
    }

    public void setCaption(String caption) {
    }

    public void setFavorited(boolean b) {
    }

//    public void setImages(Object listImageUrls) {
//    }
//
//    public void setComments(List<Comment> listComments) {
//    }
//
//    public void setFavorited(boolean favorited) {
//    }
//
//    public void setLiked(boolean liked) {
//    }
//
//    public void setLikeNumber(int likeNumber) {
//    }
//
//    public void setDatePosted(LocalDateTime now) {
//    }
//
//    public Object getImages() {
//    }
}
