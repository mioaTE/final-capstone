package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class Like {

    private int postId;
    private int userId;

    public int getPostId(){
        return postId;
    }

    public void setPostId(int postId){
        this.postId = postId;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public Like(){}

    public Like(int postId, int userId){
        this.postId = postId;
        this.userId = userId;
    }
}
