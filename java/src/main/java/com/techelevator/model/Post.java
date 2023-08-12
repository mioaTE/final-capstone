package com.techelevator.model;

public class Post {

    private int postId;

    private int likesCount;

    private String postDescription;

    private String urlImage;

    public Post(){}

    public Post(int postId, int likesCount, String postDescription, String urlImage){
        this.postId = postId;
        this.likesCount = likesCount;
        this.postDescription = postDescription;
        this.urlImage = urlImage;
    }
}
