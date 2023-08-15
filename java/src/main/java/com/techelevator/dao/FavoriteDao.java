package com.techelevator.dao;
import com.techelevator.model.Favorite;
import java.util.List;

public interface FavoriteDao {
    void createFavorite(Favorite favorite);
    int deleteFavorite(int userId, int postId);

    List<Favorite> getAllFavoritesByUserId(int userId);
}