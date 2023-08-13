package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Like;
import com.techelevator.model.Post;
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
    public Like createLike(Like like){
        Like newLike = null;
        //RETURNING???
        String sql = "INSERT INTO like (post_id, user_id) VALUES ( ?, ?)";
//        try{
//            int newPostId = jdbcTemplate.queryForObject(sql, int.class, post.getUserId(), post.getPostDescription(), post.getUrlImage(), post.getLikesCount(), post.getPostCreateTime());
//            newPost = getPostByPostId(newPostId);
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
        return newLike;
    }

    @Override
    public List<Like> getLikeByPostId(int postId){
        List<Like> likes = new ArrayList<>();
        Like like = null;
        String sql = "SELECT post_id, user_id FROM likes WHERE post_id = ?";
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
    private Like mapRowToLike(SqlRowSet rs) {
        Like like = new Like();
        like.setPostId(rs.getInt("post_id"));
        like.setUserId(rs.getInt("user_id"));

        return like;
    }
}
