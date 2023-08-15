package com.techelevator.dao;
import com.techelevator.model.Favorite;
import com.techelevator.model.Post;

import java.util.List;

public interface FavoriteDao {
    void createFavorite(Favorite favorite);
    int deleteFavorite(int userId, int postId);

    List<Post> getAllFavoritesByUserId(int userId);
}