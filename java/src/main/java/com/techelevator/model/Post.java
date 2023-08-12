package com.techelevator.model;

public class Post {

    private int postId;

    private int likesCount;

    private String postDescription;

    private String urlImage;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
