package com.techelevator.dao;
import com.techelevator.model.Like;

import java.util.List;

public interface LikeDao {
    void createLike(Like like);
    List<Like> getLikeByPostId(int postId);
}
