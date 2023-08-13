package com.techelevator.dao;

public interface LikedDao{

    boolean isLiked(int postId, int userId);

    void like(int postId, int userId);

    void unlike(int postId, int userId);

    int getLikeNumber(int postId);
}