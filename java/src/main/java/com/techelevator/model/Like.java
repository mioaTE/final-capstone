package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

public class Like {
    @NotEmpty
    private int postId;
    @NotEmpty
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
