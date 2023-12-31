package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Like;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLikeDao implements LikeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcLikeDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createLike(Like like){
        String sql = "INSERT INTO likes (post_id, user_id) VALUES ( ?, ?)";
        try{
            jdbcTemplate.update(sql, like.getPostId(), like.getUserId());
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public List<Like> getAllLikes(){
        List allLikes = new ArrayList<>();
        Like like = null;
        String sql = "SELECT post_id, user_id FROM likes;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()){
                like = mapRowToLike(results);
                allLikes.add(like);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return allLikes;
    }


    @Override
    public int deleteLike(int userId, int postId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM likes WHERE post_id = ? AND user_id = ?;";

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
    public List<Like> getLikeByPostId(int postId){
        List<Like> likes = new ArrayList<>();
        Like like = null;
        String sql = "SELECT post_id, user_id FROM likes WHERE post_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);
            if(results.next()){
                like = mapRowToLike(results);
                likes.add(like);
            }
        } catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return likes;
    }

    @Override
    public Like getLikeByUserAndPost(int userId, int postId) {
        Like like = null;
        String sql = "SELECT post_id, user_id FROM likes WHERE user_id = ? AND post_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, postId);
            if (results.next()) {
                like = mapRowToLike(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return like;
    }

    private Like mapRowToLike(SqlRowSet rs) {
        Like like = new Like();
        like.setPostId(rs.getInt("post_id"));
        like.setUserId(rs.getInt("user_id"));

        return like;
    }
}
