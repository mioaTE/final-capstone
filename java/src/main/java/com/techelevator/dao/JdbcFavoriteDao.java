package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Favorite;
import com.techelevator.model.Post;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoriteDao implements FavoriteDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoriteDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createFavorite(Favorite favorite){
        String sql = "INSERT INTO favorites (post_id, user_id) VALUES ( ?, ?)";
        try{
            jdbcTemplate.update(sql, favorite.getPostId(), favorite.getUserId());
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public int deleteFavorite(int userId, int postId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM favorites WHERE post_id = ? AND user_id = ?;";

        try {
            numberOfRows = jdbcTemplate.update(sql, postId, userId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    @Override
    public List<Post> getAllFavoritesByUserId(int userId){
        List allFavorites = new ArrayList<>();
        Favorite favorite = null;
        String sql = "SELECT favorites.post_id, post.user_id, post.post_description, post.post_img, post.post_likes, post.created_on FROM post JOIN favorites ON post.user_id = favorites.user_id WHERE favorites.user_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                favorite = mapRowToFavorite(results);
                allFavorites.add(favorite);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allFavorites;
    }

    private Favorite mapRowToFavorite(SqlRowSet rs) {
        Favorite favorite= new Favorite();
        favorite.setPostId(rs.getInt("post_id"));
        favorite.setUserId(rs.getInt("user_id"));

        return favorite;
    }
}
