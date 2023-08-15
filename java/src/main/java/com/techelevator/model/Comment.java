package com.techelevator.model;

import java.time.LocalDateTime;

public class Comment {

    private int commentId;
    private int userId;
    private int postId;
    private String comment;
    public Comment(){};

    public Comment(int commentId, int userId, int postId, String message, LocalDateTime dateTime, Long secondsAgo, String username) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.comment = message;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}